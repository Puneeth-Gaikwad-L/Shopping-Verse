package com.example.ShoppingVerse.transformer;

import com.example.ShoppingVerse.Module.Customer;
import com.example.ShoppingVerse.dto.request.CustomerRequestDto;
import com.example.ShoppingVerse.dto.responce.CustomerResponceDto;

public class CustomerTransformer {
    public static Customer CustomerRequestToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .emailId(customerRequestDto.getEmailId())
                .mobNo(customerRequestDto.getModNo())
                .gender(customerRequestDto.getGender())
                .build();
    }

    public static CustomerResponceDto CustomerToCustomerResponce(Customer customer){
        return CustomerResponceDto.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .gender(customer.getGender())
                .modNo(customer.getMobNo())
                .build();
    }
}
