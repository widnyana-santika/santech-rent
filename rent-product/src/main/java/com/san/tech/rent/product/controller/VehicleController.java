package com.san.tech.rent.product.controller;

import com.san.tech.rent.product.entity.Vehicle;
import com.san.tech.rent.product.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vehicle")
@ComponentScan("com.san.tech.rent.product.serviceImpl")
public class VehicleController {

    private VehicleService service;

    @Autowired
    public VehicleController(VehicleService service){
        this.service = service;
    }

    @GetMapping
    public List<Vehicle> getVehicles(){
        return service.getVehicles();
    }

    @GetMapping(path = "/type/{vehicleTypeId}")
    public List<Vehicle> getVehicleByType(@PathVariable("vehicleTypeId") Long id){
        return service.getVehicleByType(id);
    }

    @GetMapping(path = "/model/{vehicleModelId}")
    public List<Vehicle> getVehiclByModel(@PathVariable("vehicleModelId") Long id){
        return service.getVehicleByModel(id);
    }

    @GetMapping(path = "{vehicleId}")
    public Vehicle readVehicle(@PathVariable("vehicleId") Long id){
        return service.readVehicle(id);
    }

    @PostMapping
    public void createVehicle(@RequestBody Vehicle vehicle){
        service.createVehicle(vehicle);

    }

    @PutMapping(path = "{vehicleId}")
    public void updateVehicle(
            @PathVariable("vehicleId") Long id,
            @RequestParam() Long typeId,
            @RequestParam() Long brandId,
            @RequestParam() String model,
            @RequestParam() String transmission,
            @RequestParam() int seat,
            @RequestParam() int baggage
    ){
        service.updateVehicle(id, typeId, brandId, model, transmission, seat, baggage);
    }

    @DeleteMapping(path = "{vehicleId}")
    public void deleteVehicle(@PathVariable("vehicleId") Long id){
        service.deleteVehicle(id);
    }

}
