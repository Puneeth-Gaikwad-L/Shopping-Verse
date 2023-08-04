package com.example.ShoppingVerse.Repository;

import com.example.ShoppingVerse.Module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer findByEmailId(String emailId);
}
