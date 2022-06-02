package com.san.tech.rent.product.serviceImpl;

import com.san.tech.rent.product.entity.Vehicle;
import com.san.tech.rent.product.entity.VehicleBrand;
import com.san.tech.rent.product.entity.VehicleType;
import com.san.tech.rent.product.repository.VehicleRepository;
import com.san.tech.rent.product.service.VehicleBrandService;
import com.san.tech.rent.product.service.VehicleService;
import com.san.tech.rent.product.service.VehicleTypeService;
import com.san.tech.rent.product.type.Transmission;
import com.san.tech.rent.product.validator.VehicleValidator;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@Primary
public class VehicleServiceImpl implements VehicleService, MessageSourceAware {

    private VehicleRepository repository;

    private VehicleTypeService typeService;

    private VehicleBrandService modelService;

    @Setter
    private MessageSource messageSource;

    @Autowired
    public VehicleServiceImpl(VehicleRepository repository,
                              VehicleTypeService typeService,
                              VehicleBrandService modelService){
        this.repository = repository;
        this.typeService = typeService;
        this.modelService = modelService;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return repository.findAll();
    }

    @Override
    public List<Vehicle> getVehicleByType(Long id) {
        VehicleType type = typeService.readType(id);
        return repository.findVehicleByVehicleTypeId(type.getId());
    }

    @Override
    public List<Vehicle> getVehicleByModel(Long id) {
        VehicleBrand model = modelService.readBrand(id);
        return repository.findVehicleByVehicleModelId(model.getId());
    }

    @Override
    public Vehicle readVehicle(Long id) {
        return repository.findById(id).orElseThrow( () ->
                new IllegalStateException(
                        messageSource.getMessage(
                                "err006.vehicle.does.not.exists",
                                new Object[]{id},
                                Locale.ENGLISH
                        )
                )
        );
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        VehicleValidator validator = new VehicleValidator(messageSource);
        validator.validateVehicleCrateAttribute(vehicle);

        VehicleType type = typeService.readType(vehicle.getVehicleTypeId());
        VehicleBrand model = modelService.readBrand(vehicle.getVehicleBrandId());

        repository.save(vehicle);
    }

    @Override
    public void updateVehicle(Long id, Long typeId, Long modelId, String model, String transmission, int seat, int baggage) {
        VehicleValidator validator = new VehicleValidator(messageSource);
        validator.validateVehicleUpdateAttribute(transmission, seat, baggage);

        VehicleType type = typeService.readType(id);
        VehicleBrand brand = modelService.readBrand(id);
        Vehicle vehicle = readVehicle(id);

        vehicle.setVehicleTypeId(type.getId());
        vehicle.setVehicleBrandId(brand.getId());
        vehicle.setTransmission(Transmission.valueOf(transmission));
        vehicle.setSeat(seat);
        vehicle.setBaggage(baggage);
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = readVehicle(id);

        repository.deleteById(vehicle.getId());
    }
}
