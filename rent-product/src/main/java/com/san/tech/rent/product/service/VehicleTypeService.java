package com.san.tech.rent.product.service;

import com.san.tech.rent.product.entity.VehicleType;

import java.util.List;

public interface VehicleTypeService {
    List<VehicleType> getTypes();

    VehicleType readType(Long id);

    void createType(VehicleType vehicleType);

    void updateType(Long id, String type);

    void deleteType(Long id);
}
