package com.san.tech.rent.product.controller;

import com.san.tech.rent.product.entity.Car;
import com.san.tech.rent.product.model.CarType;
import com.san.tech.rent.product.model.Transmission;
import com.san.tech.rent.product.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
@ComponentScan("com.san.tech.rent.product.serviceImpl")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // search
    @GetMapping
    public List<Car> getCars(){
        return carService.getCars();
    }

    // store
    @PostMapping
    public void registerNewCar(@RequestBody Car car){
        carService.store(car);
    }

    // edit

    // delete
}
