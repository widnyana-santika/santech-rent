package com.san.tech.rent.product.serviceImpl;

import com.san.tech.rent.product.entity.VehicleBrand;
import com.san.tech.rent.product.repository.VehicleBrandRepository;
import com.san.tech.rent.product.service.VehicleBrandService;
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
public class VehicleBrandServiceImpl implements VehicleBrandService, MessageSourceAware {

    private VehicleBrandRepository repository;

    @Setter
    private MessageSource messageSource;

    @Autowired
    public VehicleBrandServiceImpl(VehicleBrandRepository repository){
        this.repository = repository;
    }

    @Override
    public List<VehicleBrand> getBrands() {
        return repository.findAll();
    }

    @Override
    public VehicleBrand readBrand(Long id) {
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
    public void createBrand(VehicleBrand vehicleBrand) {
        // validation if brand and model already exists
        Optional<VehicleBrand> modelExist = repository.findByBrandAndModel(vehicleBrand.getBrand());

        if(modelExist.isPresent()){
            throw new IllegalStateException(
                    messageSource.getMessage(
                            "err001.model.exists",
                            new Object[]{modelExist.get().getBrand()},
                            Locale.ENGLISH));
        }

        repository.save(vehicleBrand);
    }

    @Override
    @Transactional
    public void updateBrand(Long id, String brand) {
        VehicleBrand vehicleBrand = repository.findById(id)
                .orElseThrow( () -> new IllegalStateException(
                        messageSource.getMessage(
                                "err002.model.does.not.exists",
                                new Object[]{id},
                                Locale.ENGLISH))
        );

        updateValidation(brand);

        if(StringUtils.isNotEmpty(brand)) {
            vehicleBrand.setBrand(brand);
        }
    }

    @Override
    public void deleteBrand(Long id) {
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

    private void updateValidation(String brand){
        Optional<VehicleBrand> modelExist = repository.findByBrandAndModel(brand);
        if(modelExist.isPresent()){
            throw new IllegalStateException(
                    messageSource.getMessage(
                            "err001.model.exists",
                            new Object[]{modelExist.get().getBrand()},
                            Locale.ENGLISH));
        }
    }

}
