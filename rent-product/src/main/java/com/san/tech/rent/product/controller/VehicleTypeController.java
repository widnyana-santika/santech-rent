package com.san.tech.rent.product.controller;

import com.san.tech.rent.product.entity.VehicleType;
import com.san.tech.rent.product.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vehicletype")
@ComponentScan("com.san.tech.rent.product.serviceImpl")
public class VehicleTypeController {

    private VehicleTypeService service;

    @Autowired
    public VehicleTypeController(VehicleTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<VehicleType> getTypes(){
        return service.getTypes();
    }

    @GetMapping(path = "{vehicleTypeId}")
    public VehicleType readType(@PathVariable("vehicleTypeId") Long id){
        return service.readType(id);
    }

    @PostMapping
    public void createType(@RequestBody VehicleType vehicleType){
        service.createType(vehicleType);
    }

    @PutMapping(path = "{vehicleTypeId}")
    public void updateType(
            @PathVariable("vehicleTypeId") Long id,
            @RequestParam(required = true) String type
    ){
        service.updateType(id, type);
    }

    @DeleteMapping(path = "{vehicleTypeId}")
    public void deleteType(@PathVariable("vehicleTypeId") Long id){
        service.deleteType(id);
    }
}
