package com.san.tech.rent.product.service;

import com.san.tech.rent.product.entity.Car;
import com.san.tech.rent.product.entity.Vehicle;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    Car store(Car car);
    Car update(Car car);
    void delete(Car car);
}
