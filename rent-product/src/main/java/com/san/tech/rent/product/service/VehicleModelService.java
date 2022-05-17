package com.san.tech.rent.product.service;

import com.san.tech.rent.product.entity.VehicleModel;

import java.util.List;

public interface VehicleModelService {
    List<VehicleModel> getModel();
    VehicleModel readModel(Long id);
    void createModel(VehicleModel vehicleModel);
    void updateModel(Long id, String brand, String model);
    void deleteModel(Long id);
}
