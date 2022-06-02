package com.san.tech.rent.product.service;

import com.san.tech.rent.product.entity.VehiclePrice;
import com.san.tech.rent.product.type.PriceType;

import java.math.BigDecimal;
import java.util.List;

public interface VehiclePriceService {
    List<VehiclePrice> getVehiclePrices();

    VehiclePrice readVehiclePrice(Long id);

    List<VehiclePrice> getVehiclePriceByVehicleId(Long vehicleId);

    void createVehiclePrice(VehiclePrice vehiclePrice);

    void updateVehiclePrice(Long id, PriceType priceType, BigDecimal price);

    void deleteVehiclePrice(Long id);
}
