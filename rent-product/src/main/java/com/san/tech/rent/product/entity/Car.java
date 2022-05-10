package com.san.tech.rent.product.entity;

import com.san.tech.rent.product.model.CarType;
import com.san.tech.rent.product.model.Transmission;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table
public class Car extends Vehicle{
    private CarType type;
    private String brand;
    private String model;
    private int year;

    public Car(String platNumber, Transmission transmission, CarType type, String brand, String model, int year, int seats) {
        super(platNumber, transmission, seats);
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Car() {

    }
}
