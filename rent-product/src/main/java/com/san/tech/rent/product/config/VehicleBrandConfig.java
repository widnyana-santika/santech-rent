package com.san.tech.rent.product.config;

import com.san.tech.rent.product.entity.VehicleBrand;
import com.san.tech.rent.product.repository.VehicleBrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class VehicleBrandConfig {
    @Bean
    CommandLineRunner vehicleCommandLineRunner(VehicleBrandRepository repository){
        return args -> {
            List<VehicleBrand> brands = Arrays.asList(
                    new VehicleBrand("Toyota", "Japan"),
                    new VehicleBrand("Honda", "Japan"),
                    new VehicleBrand("Yamaha", "Japan")
            );

            repository.saveAll(brands);
        };
    }
}
