package com.fipe.api.scheduled;


import com.fipe.api.client.FipeClient;
import com.fipe.api.client.response.FipeModel;
import com.fipe.api.model.entity.Brand;
import com.fipe.api.model.entity.Model;
import com.fipe.api.repository.BrandAsincRepository;
import com.fipe.api.repository.ModelAsincRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@EnableScheduling
public class Scheduler {

    @Autowired
    private FipeClient fipeClient;

    @Autowired
    private BrandAsincRepository brandAsincRepository;

    @Autowired
    private ModelAsincRepository modelAsincRepository;

   @Scheduled(fixedRate = 1000)
    public Disposable getBrandsAndModels() {
        log.info("inicio modelos");
        return fipeClient.findAllBrands()
                .filterWhen(fipeBrand -> brandAsincRepository.notExistsByCode(fipeBrand.getCode()))
                .flatMap(fipeBrand -> brandAsincRepository.save(Brand.builder().name(fipeBrand.getName()).key2(fipeBrand.getCode()).build()))
                .flatMap(zu -> this.getAndSaveModels(zu))
                .flatMap(model -> modelAsincRepository.save(model))
                .subscribe();



    }

    private Flux<Model> getAndSaveModels(Brand brand) {

        log.info("inicio model 1");
        log.info("getname     "+brand.getName());
        return fipeClient.searchModelByBrand(Long.valueOf(brand.getKey2()))
                .map(FipeModel::getModels)
                .flatMapMany(Flux::fromIterable)
                .filterWhen(model -> modelAsincRepository.notExistsByCode(model.getCode()))
                .map(modelo -> Model.builder()
                        .name(modelo.getName())
                        .code(modelo.getCode())
                        .brand(brand)
                        .build()
                );
        //return null;
    }

}
