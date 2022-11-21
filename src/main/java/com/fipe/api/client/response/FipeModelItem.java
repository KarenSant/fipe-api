package com.fipe.api.client.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;

@Getter
public class FipeModelItem {

    @JsonAlias("nome")
    private String name;

    @JsonAlias("codigo")
    private String code;
}
