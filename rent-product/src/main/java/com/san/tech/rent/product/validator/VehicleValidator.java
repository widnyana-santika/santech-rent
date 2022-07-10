package com.san.tech.rent.product.validator;

import com.san.tech.rent.product.entity.Vehicle;
import com.san.tech.rent.product.type.VehicleType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class VehicleValidator {

    @Setter
    private MessageSource messageSource;

    public void validateVehicleCrateAttribute(Vehicle vehicle){
        objectCannotEmpty(vehicle.getTransmission(), VehicleType.TRANSMISSION);
        integerCannotLessThanOne(vehicle.getSeat(), VehicleType.SEAT);
        integerCannotLessThanOne(vehicle.getBaggage(), VehicleType.BAGGAGE);
    }

    public void validateVehicleUpdateAttribute(Vehicle vehicle){
        stringCannotEmpty(vehicle.getTransmission().getValue(), VehicleType.TRANSMISSION);
        integerCannotLessThanOne(vehicle.getSeat(), VehicleType.SEAT);
        integerCannotLessThanOne(vehicle.getBaggage(), VehicleType.BAGGAGE);
    }

    private void objectCannotEmpty(Object value, String attributeType){
        if(value == null){
            throw new IllegalStateException(
                    messageSource.getMessage(
                            "err005.input.required",
                            new Object[]{attributeType},
                            Locale.ENGLISH
                    )
            );
        }
    }

    private void stringCannotEmpty(String value, String attributeType){
        if(StringUtils.isEmpty(value)){
            throw new IllegalStateException(
                    messageSource.getMessage(
                            "err005.input.required",
                            new Object[]{attributeType},
                            Locale.ENGLISH
                    )
            );
        }
    }

    private void integerCannotLessThanOne(int value, String attributeType){
        if(value < 1){
            throw new IllegalStateException(
                    messageSource.getMessage(
                            "err005.input.required",
                            new Object[]{attributeType},
                            Locale.ENGLISH
                    )
            );
        }
    }
}
