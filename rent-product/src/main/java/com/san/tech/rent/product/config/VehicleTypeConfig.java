package com.san.tech.rent.product.config;

import com.san.tech.rent.product.entity.VehicleType;
import com.san.tech.rent.product.repository.VehicleTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class VehicleTypeConfig {
    @Bean
    CommandLineRunner vehicleTypeCommandLineRunner(VehicleTypeRepository repository){
        return args -> {

            List<VehicleType> types = Arrays.asList(
                    new VehicleType("Car"),
                    new VehicleType("Motorcycle"));

            repository.saveAll(types);
        };
    }
}
