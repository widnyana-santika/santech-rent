package com.san.tech.rent.product.repository;

import com.san.tech.rent.product.entity.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Long> {

    @Query("SELECT m FROM VehicleBrand m WHERE m.brand = ?1")
    Optional<VehicleBrand> findByBrandAndModel(String brand);
}
