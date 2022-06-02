package com.san.tech.rent.product.entity;

import com.san.tech.rent.product.type.PriceType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
public class VehiclePrice {
    @Id
    @SequenceGenerator(
            name = "vehicleprice_sequence",
            sequenceName = "vehicleprice_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicleprice_sequence"
    )
    private Long id;
    private Long vehicleId;
    @Enumerated(EnumType.STRING)
    private PriceType priceType;
    private BigDecimal price;
}
