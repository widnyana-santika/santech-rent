package com.san.tech.rent.product.config;

import com.san.tech.rent.product.entity.VehicleModel;
import com.san.tech.rent.product.repository.VehicleModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleModelConfig {
    @Bean
    CommandLineRunner vehicleCommandLineRunner(VehicleModelRepository repository){
        return args -> {
            VehicleModel model1 = new VehicleModel(
                    "Toyota",
                    "Yaris",
                    "Japan"
            );

            repository.save(model1);
        };
    }
}
