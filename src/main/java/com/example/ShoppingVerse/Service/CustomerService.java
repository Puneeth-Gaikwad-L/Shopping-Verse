package com.example.ShoppingVerse.Service;

import com.example.ShoppingVerse.Module.Customer;
import com.example.ShoppingVerse.Repository.CustomerRepository;
import com.example.ShoppingVerse.dto.request.CustomerRequestDto;
import com.example.ShoppingVerse.dto.responce.CustomerResponceDto;
import com.example.ShoppingVerse.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponceDto addCustomer(CustomerRequestDto customerRequestDto) {

        Customer savedCustomer = customerRepository.save(CustomerTransformer.CustomerRequestToCustomer(customerRequestDto));
        return CustomerTransformer.CustomerToCustomerResponce(savedCustomer);
    }
}
