package com.san.tech.rent.product.config;

import com.san.tech.rent.product.entity.Car;
import com.san.tech.rent.product.model.CarType;
import com.san.tech.rent.product.model.Transmission;
import com.san.tech.rent.product.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner commandLineRunner(CarRepository repository){
        return args -> {
            Car yaris = new Car(
                    "DK 123 DS",
                    Transmission.AUOTMATIC,
                    CarType.CITY_CAR,
                    "Toyota",
                    "Yaris",
                    2016,
                    4
            );

            Car avanza = new Car(
                    "DK 123 DS",
                    Transmission.AUOTMATIC,
                    CarType.SUV,
                    "Toyota",
                    "Avanza",
                    2019,
                    4
            );

            repository.saveAll(List.of(yaris, avanza));
        };
    }
}
