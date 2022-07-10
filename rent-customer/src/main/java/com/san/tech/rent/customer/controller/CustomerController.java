package com.san.tech.rent.customer.controller;

import com.san.tech.rent.customer.entity.Customer;
import com.san.tech.rent.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/customer")
@ComponentScan("com.san.tech.rent.customer.serviceImpl")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer){
        log.info("Creating customer");
        service.createCustomer(customer);
    }

    @PutMapping(path="{id}")
    public void updateCustomer(@PathVariable("id") Long id,
                               @RequestBody Customer customer){
        log.info("Update Customer");
        service.updateCustomer(id, customer);
    }

    @DeleteMapping(path={"id"})
    public void deleteMapping(@PathVariable("id") Long id){
        log.info("Delete Customer");
    }
}
