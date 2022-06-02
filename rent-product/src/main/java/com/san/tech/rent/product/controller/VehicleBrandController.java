package com.san.tech.rent.product.controller;

import com.san.tech.rent.product.entity.VehicleBrand;
import com.san.tech.rent.product.service.VehicleBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vehiclebrand")
@ComponentScan("com.san.tech.rent.product.serviceImpl")
public class VehicleBrandController {
    private VehicleBrandService service;

    @Autowired
    public VehicleBrandController(VehicleBrandService service){
        this.service = service;
    }

    // search
    @GetMapping
    public List<VehicleBrand> getModel(){
        return service.getBrands();
    }

    // read
    @GetMapping(path = "{vehicleBrandId}")
    public VehicleBrand readModel(@PathVariable("vehicleBrandId") Long id){
        return service.readBrand(id);
    }

    // create
    @PostMapping
    public void createModel(@RequestBody VehicleBrand vehicleBrand){
        service.createBrand(vehicleBrand);
    }

    // update
    @PutMapping(path="{vehicleBrandId}")
    public void updateModel(
            @PathVariable("vehicleBrandId") Long id,
            @RequestParam(required = false) String brand
    ){
        service.updateBrand(id, brand);
    }

    // delete
    @DeleteMapping(path = "{vehicleBrandId}")
    public void deleteModel(@PathVariable("vehicleBrandId") Long id){
        service.deleteBrand(id);
    }
}
