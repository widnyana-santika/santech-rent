package com.san.tech.rent.product.entity;

import com.san.tech.rent.product.model.Transmission;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class Vehicle {
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
    private long vehicleType;
    private long vehicleModel;
    private Transmission transmission;
    private int seat;
    private int baggage;

    public Vehicle(Transmission transmission, int seats) {
        this.transmission = transmission;
        this.seat = seats;
    }

    public Vehicle() {

    }
}
