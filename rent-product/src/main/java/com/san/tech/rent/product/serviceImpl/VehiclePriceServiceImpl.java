package com.san.tech.rent.product.serviceImpl;

import com.san.tech.rent.product.entity.Vehicle;
import com.san.tech.rent.product.entity.VehiclePrice;
import com.san.tech.rent.product.repository.VehiclePriceRepository;
import com.san.tech.rent.product.service.VehiclePriceService;
import com.san.tech.rent.product.service.VehicleService;
import com.san.tech.rent.product.type.PriceType;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

@Service
@Primary
public class VehiclePriceServiceImpl implements VehiclePriceService, MessageSourceAware {

    private VehiclePriceRepository repository;

    private VehicleService vehicleService;

    @Setter
    private MessageSource messageSource;

    @Autowired
    public VehiclePriceServiceImpl(VehiclePriceRepository repository, VehicleService vehicleService){
        this.repository = repository;
        this.vehicleService = vehicleService;
    }

    @Override
    public List<VehiclePrice> getVehiclePrices() {
        return repository.findAll();
    }

    @Override
    public VehiclePrice readVehiclePrice(Long id) {
        return repository.findById(id).orElseThrow(() ->
            new IllegalStateException(messageSource.getMessage(
                    "err007.price.does.not.exists",
                    new Object[]{id},
                    Locale.ENGLISH
            ))
        );
    }

    @Override
    public List<VehiclePrice> getVehiclePriceByVehicleId(Long vehicleId) {
        Vehicle vehicle = vehicleService.readVehicle(vehicleId);

        return repository.getVehiclePriceByVehicleId(vehicle.getId());
    }

    @Override
    public void createVehiclePrice(VehiclePrice vehiclePrice) {
        Vehicle vehicle = vehicleService.readVehicle(vehiclePrice.getVehicleId());

        repository.save(vehiclePrice);
    }

    @Override
    public void updateVehiclePrice(Long id, PriceType type, BigDecimal price) {
        VehiclePrice vehiclePrice = readVehiclePrice(id);

        vehiclePrice.setPriceType(type);
        vehiclePrice.setPrice(price);
    }

    @Override
    public void deleteVehiclePrice(Long id) {
        Vehicle vehicle = vehicleService.readVehicle(id);

        repository.deleteById(vehicle.getId());
    }
}
