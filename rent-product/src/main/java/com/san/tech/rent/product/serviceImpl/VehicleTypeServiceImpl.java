package com.san.tech.rent.product.serviceImpl;

import com.san.tech.rent.product.entity.Vehicle;
import com.san.tech.rent.product.entity.VehicleType;
import com.san.tech.rent.product.repository.VehicleTypeRepository;
import com.san.tech.rent.product.service.VehicleTypeService;
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
public class VehicleTypeServiceImpl implements VehicleTypeService, MessageSourceAware {

    private VehicleTypeRepository repository;

    @Setter
    private MessageSource messageSource;

    @Autowired
    public VehicleTypeServiceImpl(VehicleTypeRepository repository){
        this.repository = repository;
    }

    @Override
    public List<VehicleType> getTypes() {
        return repository.findAll();
    }

    @Override
    public VehicleType readType(Long id) {
        return repository.findById(id).orElseThrow(() ->
            new IllegalStateException(
                    messageSource.getMessage(
                            "err003.type.does.not.exists",
                            new Object[]{id},
                            Locale.ENGLISH
                    )
            )
        );
    }

    @Override
    public void createType(VehicleType vehicleType) {
        if(StringUtils.isEmpty(vehicleType.getTypeDescription())){
            throw new IllegalStateException(
                    messageSource.getMessage(
                            "err005.input.required",
                            new Object[]{"Type Description"},
                            Locale.ENGLISH
                    )
            );
        }

        Optional<VehicleType> typeExist = repository.findByType(vehicleType.getTypeDescription());

        if(typeExist.isPresent()){
            throw new IllegalStateException(
                messageSource.getMessage(
                        "err004.type.exists",
                        new Object[]{vehicleType.getTypeDescription()},
                        Locale.ENGLISH
                )
            );
        }

        repository.save(vehicleType);
    }

    @Override
    @Transactional
    public void updateType(Long id, String type) {
        VehicleType vehicleType = repository.findById(id).orElseThrow(() ->
            new IllegalStateException(
                messageSource.getMessage(
                        "err003.type.does.not.exists",
                        new Object[]{id},
                        Locale.ENGLISH
                )
            )
        );

        Optional<VehicleType> typeExist = repository.findByType(type);
        if(typeExist.isPresent()){
            throw new IllegalStateException(
                messageSource.getMessage(
                        "err004.type.exists",
                        new Object[]{type},
                        Locale.ENGLISH
                )
            );
        }

        if(StringUtils.isNotEmpty(type)){
            vehicleType.setTypeDescription(type);
        }

    }

    @Override
    public void deleteType(Long id) {
        boolean typeExist = repository.existsById(id);

        if(!typeExist){
            throw new IllegalStateException(
                messageSource.getMessage(
                        "err003.type.does.not.exists",
                        new Object[]{id},
                        Locale.ENGLISH
                )
            );
        }

        repository.deleteById(id);
    }
}
