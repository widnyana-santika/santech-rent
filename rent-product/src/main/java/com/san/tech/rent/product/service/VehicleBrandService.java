package com.san.tech.rent.product.service;

import com.san.tech.rent.product.entity.VehicleBrand;

import java.util.List;

public interface VehicleBrandService {
    List<VehicleBrand> getBrands();

    VehicleBrand readBrand(Long id);

    void createBrand(VehicleBrand vehicleBrand);

    void updateBrand(Long id, String brand);

    void deleteBrand(Long id);
}
