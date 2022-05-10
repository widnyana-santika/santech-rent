package com.san.tech.rent.product.entity;

import com.san.tech.rent.product.model.Transmission;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class Vehicle {
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private long id;
    private String platNumber;
    private Transmission transmission;
    private int seats;

    public Vehicle(String platNumber, Transmission transmission, int seats) {
        this.platNumber = platNumber;
        this.transmission = transmission;
        this.seats = seats;
    }

    public Vehicle() {

    }
}
