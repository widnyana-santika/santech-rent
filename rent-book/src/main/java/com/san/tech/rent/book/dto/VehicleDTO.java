package com.san.tech.rent.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VehicleDTO {
    private long id;
    private String vehicleType;
    private String vehicleBrand;
    private String model;
    private String transmission;
    private int seat;
    private int baggage;
}
