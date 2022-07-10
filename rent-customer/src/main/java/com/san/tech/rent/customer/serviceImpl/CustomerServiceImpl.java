package com.san.tech.rent.customer.serviceImpl;

import com.san.tech.rent.customer.entity.Customer;
import com.san.tech.rent.customer.repository.CustomerRepository;
import com.san.tech.rent.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Primary
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getCustomers(){
        return repository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id){
        return repository.getById(id);
    }

    @Override
    public void createCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Long id, Customer customer){
        Customer toUpdate = this.getCustomerById(id);

        toUpdate.setSurname(customer.getSurname());
        toUpdate.setEmail(customer.getEmail());
        toUpdate.setGender(customer.getGender());
        toUpdate.setAddress(customer.getAddress());
        toUpdate.setPhoneNumber(customer.getPhoneNumber());
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
