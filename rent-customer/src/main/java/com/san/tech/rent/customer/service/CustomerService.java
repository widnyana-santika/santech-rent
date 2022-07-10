package com.san.tech.rent.customer.service;

import com.san.tech.rent.customer.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Long id);
    List<Customer> getCustomers();
    void createCustomer(Customer customer);
    void updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
}
