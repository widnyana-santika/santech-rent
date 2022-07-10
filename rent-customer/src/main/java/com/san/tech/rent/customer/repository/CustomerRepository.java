package com.san.tech.rent.customer.repository;

import com.san.tech.rent.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
