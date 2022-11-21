package com.fipe.api.client.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FipeYear {

    @JsonAlias("nome")
    String name;

    @JsonAlias("codigo")
    String code;

}
