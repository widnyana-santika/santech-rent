package com.san.tech.rent.product.service;

import com.san.tech.rent.product.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getVehicles();

    List<Vehicle> getVehicleByType(Long id);

    List<Vehicle> getVehicleByModel(Long id);

    Vehicle readVehicle(Long id);

    void createVehicle(Vehicle vehicle);

    void updateVehicle(Long id, Long typeId, Long modelId, String model, String transmission, int seat, int baggage);

    void deleteVehicle(Long id);
}
