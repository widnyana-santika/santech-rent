package com.san.tech.rent;

import com.san.tech.rent.book.dto.CustomerDTO;
import com.san.tech.rent.book.dto.VehicleDTO;
import com.san.tech.rent.book.entity.Book;
import com.san.tech.rent.book.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class RentBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentBookApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BookRepository repository){
        return args -> {
            CustomerDTO customer = CustomerDTO.builder().id(1)
                    .surname("Widnyana Santika")
                    .address("Dalung")
                    .email("wid@gmail.com")
                    .phoneNumber("085799168532")
                    .build();
            VehicleDTO vehicle = VehicleDTO.builder()
                    .id(1).vehicleType("Car")
                    .vehicleBrand("Toyota")
                    .baggage(5)
                    .model("Avanza 2015")
                    .seat(6)
                    .transmission("Manual")
                    .build();
            Book book = Book.builder()
                    .customer(customer)
                    .vehicle(vehicle)
                    .dateFrom(new Date().getTime())
                    .dateTo(new Date().getTime())
                    .build();

            repository.insert(book);
        };
    }
}
