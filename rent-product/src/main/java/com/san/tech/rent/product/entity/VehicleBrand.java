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
public class VehicleBrand {
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
    private String manufacture;

    public VehicleBrand(String brand, String manufacture){
        this.brand = brand;
        this.manufacture = manufacture;
    }
}
