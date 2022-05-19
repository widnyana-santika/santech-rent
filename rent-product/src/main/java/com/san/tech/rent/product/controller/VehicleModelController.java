package com.san.tech.rent.product.controller;

import com.san.tech.rent.product.entity.VehicleModel;
import com.san.tech.rent.product.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vehiclemodel")
@ComponentScan("com.san.tech.rent.product.serviceImpl")
public class VehicleModelController {
    private VehicleModelService service;

    @Autowired
    public VehicleModelController(VehicleModelService service){
        this.service = service;
    }

    // search
    @GetMapping
    public List<VehicleModel> getModel(){
        return service.getModels();
    }

    // read
    @GetMapping(path = "{vehicleModelId}")
    public VehicleModel readModel(@PathVariable("vehicleModelId") Long id){
        return service.readModel(id);
    }

    // create
    @PostMapping
    public void createModel(@RequestBody VehicleModel vehicleModel){
        service.createModel(vehicleModel);
    }

    // update
    @PutMapping(path="{vehicleModelId}")
    public void updateModel(
            @PathVariable("vehicleModelId") Long id,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model
    ){
        service.updateModel(id, brand, model);
    }

    // delete
    @DeleteMapping(path = "{vehicleModelId}")
    public void deleteModel(@PathVariable("vehicleModelId") Long id){
        service.deleteModel(id);
    }
}
