package com.fipe.api.client;

import com.fipe.api.client.response.FipeBrand;
import com.fipe.api.client.response.FipeModel;
import com.fipe.api.model.entity.Brand;
import com.fipe.api.model.entity.Car;
import com.fipe.api.model.entity.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FipeClient {

    @Autowired
    private WebClient webClientCar;


    public Car getByCode(Long codigoProduto) {

        Mono<Car> monoProduto = this.webClientCar
                .method(HttpMethod.GET)
                .uri("/car/{codigo}", codigoProduto)
                .retrieve()
                .bodyToMono(Car.class);
        return null;
    }

    public Flux<FipeBrand> findAllBrands() {
        return this.webClientCar.get()
                .uri("/carros/marcas")
                .retrieve()
                .bodyToFlux(FipeBrand.class);
    }

    public Mono<FipeModel> searchModelByBrand(Long id) {
        return this.webClientCar.get()
                .uri("/carros/marcas/{id}/modelos", id)
                .retrieve()
                .bodyToMono(FipeModel.class);
    }


    public Mono<Model> searchCode1(String brand) {
//        return this.marcaAsincRepository.searchCode(brand);//fmodelEntity.getMarca();
//    }
        return this.webClientCar.get()
                .uri("/carros/marcas")
                .retrieve()
                .bodyToFlux(Brand.class)
                .filter(marca -> marca.getName().equals(brand))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca não encontrada")))
                .flatMap(marca -> webClientCar
                        .method(HttpMethod.GET)
                        .uri("/carros/marcas/{id}/modelos", marca.getKey2())//getCode())
                        .retrieve()
                        .bodyToMono(Model.class));
    }

    public Mono<Model> searchCode(String brand) {
        return this.webClientCar.get()
                .uri("/carros/marcas")
                .retrieve()
                .bodyToFlux(Brand.class)
                .filter(marca -> marca.getName().equals(brand))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca não encontrada")))
                .flatMap(marca -> webClientCar
                        .method(HttpMethod.GET)
                        .uri("/carros/marcas/{id}/modelos", marca.getKey2())//getCode())
                        .retrieve()
                        .bodyToMono(Model.class));

    }
}
