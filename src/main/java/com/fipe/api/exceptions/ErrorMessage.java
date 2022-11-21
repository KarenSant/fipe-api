package com.fipe.api.exceptions;

public class ErrorMessage {

    private Long id;

    private String name;

    private Integer brand_id;

    private Integer amount;

    private String category;

    private String key2;

    public ErrorMessage(int value, Long id, String name, Integer brand_id, Integer amount, String category, String key2, String description){
        this.id = id;
        this.name = name;
        this.brand_id = brand_id;
        this.amount = amount;
        this.category = category;
        this.key2 = key2;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Integer getBrand_id(){
        return brand_id;
    }
    public Integer getAmount(){
        return amount;
    }
    public String getCategory(){
        return category;
    }
    public String getKey2(){
        return key2;
    }


}
