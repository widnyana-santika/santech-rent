package com.san.tech.rent.product.repository;

import com.san.tech.rent.product.entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {

    @Query("SELECT t FROM VehicleType t WHERE t.typeDescription = ?1")
    Optional<VehicleType> findByType(String type);
}
