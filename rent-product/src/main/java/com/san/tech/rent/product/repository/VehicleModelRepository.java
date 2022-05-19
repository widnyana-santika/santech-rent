package com.san.tech.rent.product.repository;

import com.san.tech.rent.product.entity.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {

    @Query("SELECT m FROM VehicleModel m WHERE m.brand = ?1 and m.model = ?2 ")
    Optional<VehicleModel> findByBrandAndModel(String brand, String model);
}
