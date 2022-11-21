package com.fipe.api.client.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FipeModel {

    @JsonAlias("modelos")
    List<FipeModelItem> models;

    @JsonAlias("anos")
    List<FipeYear> years;
}
