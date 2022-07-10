package com.san.tech.rent.type;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum Gender implements Serializable {
    MALE("Male"),
    FEMALE("Female");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }
}
