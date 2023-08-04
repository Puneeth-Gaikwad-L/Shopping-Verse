package com.example.ShoppingVerse.Controller;

import com.example.ShoppingVerse.Service.SellerService;
import com.example.ShoppingVerse.dto.request.SellerRequest;
import com.example.ShoppingVerse.dto.responce.SellerResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public ResponseEntity addSeller(@RequestBody SellerRequest sellerRequest){
        SellerResponce sellerResponce = sellerService.addSeller(sellerRequest);
        return new ResponseEntity(sellerResponce, HttpStatus.CREATED);
    }
}
