package com.san.tech.rent.product.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class VehicleModel {
    @Id
    @SequenceGenerator(
            name = "vehicleModel_sequence",
            sequenceName = "vehicleModel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicleModel_sequence"
    )
    private Long id;
    private String brand;
    private String model;
    private String manufacture;

    public VehicleModel(String brand, String model, String manufacture){
        this.brand = brand;
        this.model = model;
        this.manufacture = manufacture;
    }
}
