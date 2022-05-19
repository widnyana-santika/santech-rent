package com.san.tech.rent.product.config;

import com.san.tech.rent.product.entity.VehicleModel;
import com.san.tech.rent.product.entity.VehicleType;
import com.san.tech.rent.product.repository.VehicleModelRepository;
import com.san.tech.rent.product.repository.VehicleTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehivleTypeConfig {
    @Bean
    CommandLineRunner vehicleTypeCommandLineRunner(VehicleTypeRepository repository){
        return args -> {
            VehicleType model1 = new VehicleType(
                    "Car"
            );

            VehicleType model2 = new VehicleType(
                    "Motorcycle"
            );

            repository.save(model1);
            repository.save(model2);
        };
    }
}
