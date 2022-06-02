package com.san.tech.rent.product.controller;

import com.san.tech.rent.product.entity.VehiclePrice;
import com.san.tech.rent.product.service.VehiclePriceService;
import com.san.tech.rent.product.type.PriceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vehicleprice")
@ComponentScan("com.san.tech.rent.product.serviceImpl")
public class VehiclePriceController {

    private VehiclePriceService service;

    @Autowired
    public VehiclePriceController(VehiclePriceService service){
        this.service = service;
    }

    @GetMapping
    public List<VehiclePrice> getVehiclePrices(){
        return service.getVehiclePrices();
    }

    // Get price by id
    @GetMapping(path = "{id}")
    public VehiclePrice getVehiclePriceById(@PathVariable("id") Long id){
        return service.readVehiclePrice(id);
    }

    // Get price by vehicle
    @GetMapping(path = "/vehicle/{id}")
    public List<VehiclePrice> getVehiclePriceByVehicleId(@PathVariable("id") Long id){
        return service.getVehiclePriceByVehicleId(id);
    }

    // Create vehicle price
    @PostMapping
    public void createVehiclePrice(@RequestBody VehiclePrice vehiclePrice){
        service.createVehiclePrice(vehiclePrice);
    }

    // Update vehicle price
    @PutMapping(path = "{id}")
    public void updateVehiclePrice(
            @PathVariable("id") Long id,
            @RequestParam() String priceType,
            @RequestParam() BigDecimal price
    ){
        service.updateVehiclePrice(id, PriceType.valueOf(priceType), price);
    }

    // Delete vehicle price
    @DeleteMapping(path = "{id}")
    public void deleteVehiclePrice(@PathVariable("id") Long id){
        service.deleteVehiclePrice(id);
    }
}
