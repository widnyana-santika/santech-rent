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
public class VehicleType {
    @Id
    @SequenceGenerator(
            name = "vehicleType_sequence",
            sequenceName = "vehicleType_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicleType_sequence"
    )
    private Long id;
    private String typeDescription;

    public VehicleType(String typeDescription) {
        this.typeDescription = typeDescription;
    }
}
