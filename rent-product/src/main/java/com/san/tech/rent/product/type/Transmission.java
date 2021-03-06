package com.san.tech.rent.product.type;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum Transmission implements Serializable {
    AUTOMATIC("automatic"),
    MANUAL("manual");

    private String value;

    Transmission(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }
}
