package com.san.tech.rent.product.repository;

import com.san.tech.rent.product.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v where v.vehicleTypeId = ?1")
    List<Vehicle> findVehicleByVehicleTypeId(Long id);

    @Query("SELECT v FROM Vehicle v where v.vehicleModelId = ?1")
    List<Vehicle> findVehicleByVehicleModelId(Long id);
}
