package com.san.tech.rent.product.serviceImpl;

import com.san.tech.rent.product.entity.Car;
import com.san.tech.rent.product.entity.Vehicle;
import com.san.tech.rent.product.model.CarType;
import com.san.tech.rent.product.model.Transmission;
import com.san.tech.rent.product.repository.CarRepository;
import com.san.tech.rent.product.repository.VehicleRepository;
import com.san.tech.rent.product.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CarServiceImpl implements CarService {

    private CarRepository repository;

    @Autowired
    public CarServiceImpl(CarRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Car> getCars() {
        return repository.findAll();
    }

    @Override
    public Car store(Car car) {
        System.out.println(car.toString());
        return null;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public void delete(Car car) {

    }


}
