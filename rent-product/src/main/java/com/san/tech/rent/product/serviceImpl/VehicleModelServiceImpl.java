package com.san.tech.rent.product.serviceImpl;

import com.san.tech.rent.product.entity.VehicleModel;
import com.san.tech.rent.product.repository.VehicleModelRepository;
import com.san.tech.rent.product.service.VehicleModelService;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Primary
public class VehicleModelServiceImpl implements VehicleModelService, MessageSourceAware {

    private VehicleModelRepository repository;

    @Setter
    private MessageSource messageSource;

    @Autowired
    public VehicleModelServiceImpl(VehicleModelRepository repository){
        this.repository = repository;
    }

    @Override
    public List<VehicleModel> getModel() {
        return repository.findAll();
    }

    @Override
    public VehicleModel readModel(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new IllegalStateException(
                        messageSource.getMessage(
                                "err002.model.does.not.exists",
                                new Object[]{id},
                                Locale.ENGLISH
                        )
                )
        );
    }

    @Override
    public void createModel(VehicleModel vehicleModel) {
        // validation if brand and model already exists
        Optional<VehicleModel> modelExist = repository.findByBrandAndModel(vehicleModel.getBrand(), vehicleModel.getModel());

        if(modelExist.isPresent()){
            throw new IllegalStateException(
                    messageSource.getMessage(
                            "err001.model.exists",
                            new Object[]{modelExist.get().getBrand(), modelExist.get().getModel()},
                            Locale.ENGLISH));
        }

        repository.save(vehicleModel);
    }

    @Override
    @Transactional
    public void updateModel(Long id, String brand, String model) {
        boolean exist = repository.existsById(id);

        VehicleModel vehicleModel = repository.findById(id)
                .orElseThrow( () -> new IllegalStateException(
                        messageSource.getMessage(
                                "err002.model.does.not.exists",
                                new Object[]{id},
                                Locale.ENGLISH))
        );

        updateValidation(brand, model);

        if(StringUtils.isNotEmpty(brand)) {
            vehicleModel.setBrand(brand);
        }

        if(StringUtils.isNotEmpty(model)){
            vehicleModel.setModel(model);
        }
    }

    @Override
    public void deleteModel(Long id) {
        boolean exist = repository.existsById(id);

        if(!exist){
            throw new IllegalStateException(
                    messageSource.getMessage(
                            "err002.model.does.not.exists",
                            new Object[]{id},
                            Locale.ENGLISH)
            );
        }

        repository.deleteById(id);
    }

    private void updateValidation(String brand, String model){
        Optional<VehicleModel> modelExist = repository.findByBrandAndModel(brand, model);
        if(modelExist.isPresent()){
            throw new IllegalStateException(
                    messageSource.getMessage(
                            "err001.model.exists",
                            new Object[]{modelExist.get().getBrand(), modelExist.get().getModel()},
                            Locale.ENGLISH));
        }
    }

}
