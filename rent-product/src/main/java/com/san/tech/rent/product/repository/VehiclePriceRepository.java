package com.san.tech.rent.product.repository;

import com.san.tech.rent.product.entity.VehiclePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiclePriceRepository extends JpaRepository<VehiclePrice, Long> {

    @Query("SELECT v FROM VehiclePrice v WHERE v.vehicleId = ?1")
    List<VehiclePrice> getVehiclePriceByVehicleId(Long id);
}
