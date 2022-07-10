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
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void updateVehicle(Long id, Vehicle vehicle) {
        VehicleValidator validator = new VehicleValidator(messageSource);
        validator.validateVehicleUpdateAttribute(vehicle);

        VehicleType type = typeService.readType(vehicle.getVehicleTypeId());
        VehicleBrand brand = modelService.readBrand(vehicle.getVehicleBrandId());
        Vehicle existVehicle = readVehicle(id);

        existVehicle.setVehicleTypeId(type.getId());
        existVehicle.setVehicleBrandId(brand.getId());
        existVehicle.setModel(vehicle.getModel());
        existVehicle.setTransmission(vehicle.getTransmission());
        existVehicle.setSeat(vehicle.getSeat());
        existVehicle.setBaggage(vehicle.getBaggage());
    }

    @Override
    @Transactional
    public void updateVehicle(Long id, Long typeId, Long modelId, String model, String transmission, int seat, int baggage) {
        VehicleType type = typeService.readType(id);
        VehicleBrand brand = modelService.readBrand(id);
        Vehicle vehicle = readVehicle(id);

        String upper = transmission.toUpperCase();
        Transmission transmission1 = Transmission.valueOf(upper);

        vehicle.setVehicleTypeId(type.getId());
        vehicle.setVehicleBrandId(brand.getId());
        vehicle.setTransmission(transmission1);
        vehicle.setModel(model);
        vehicle.setSeat(seat);
        vehicle.setBaggage(baggage);
    }

    @Override
    public void updateModelVehicle(Long id, String model) {
        Vehicle existVehicle = readVehicle(id);

        existVehicle.setModel(model);
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = readVehicle(id);

        repository.deleteById(vehicle.getId());
    }
}
