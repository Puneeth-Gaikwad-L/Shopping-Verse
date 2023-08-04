package com.example.ShoppingVerse.Controller;

import com.example.ShoppingVerse.Service.CustomerService;
import com.example.ShoppingVerse.dto.request.CustomerRequestDto;
import com.example.ShoppingVerse.dto.responce.CustomerResponceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        CustomerResponceDto customerResponceDto = customerService.addCustomer(customerRequestDto);
        return new ResponseEntity(customerResponceDto, HttpStatus.CREATED);
    }
}
