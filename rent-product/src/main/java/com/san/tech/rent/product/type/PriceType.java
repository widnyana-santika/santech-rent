package com.san.tech.rent.product.type;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum PriceType implements Serializable {
    DAILY("daily"),
    WEEKLY("weekly"),
    MONTHLY("monthly"),
    YEARLY("yearly");

    private String value;

    PriceType(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }
}
