package com.san.tech.rent.product.entity;

import com.san.tech.rent.product.type.Transmission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
public class Vehicle {
    @Id
    @SequenceGenerator(
            name = "vehicle_sequence",
            sequenceName = "vehicle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicle_sequence"
    )
    private long id;
    private long vehicleTypeId;
    private long vehicleModelId;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private int seat;
    private int baggage;

    public Vehicle(long vehicleTypeId, long vehicleModelId, Transmission transmission, int seats, int baggage) {
        this.vehicleTypeId = vehicleTypeId;
        this.vehicleModelId = vehicleModelId;
        this.transmission = transmission;
        this.seat = seats;
        this.baggage = baggage;
    }
}
