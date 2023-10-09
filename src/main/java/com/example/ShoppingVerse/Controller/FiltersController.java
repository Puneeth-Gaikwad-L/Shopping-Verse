package com.example.ShoppingVerse.Controller;

import com.example.ShoppingVerse.Enum.ProductCategory;
import com.example.ShoppingVerse.Service.FilterService;
import com.example.ShoppingVerse.Service.ProductService;
import com.example.ShoppingVerse.dto.responce.ProductResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filters")
public class FiltersController {
    @Autowired
    FilterService filterService;
    @GetMapping("/get_by_price_and_category")
    public ResponseEntity getProdByPriceandCategory(@RequestParam("c") ProductCategory category, @RequestParam("p") int price){
        List<ProductResponce> productResponceList= filterService.getProdByPriceandCategory(category, price);
        return new ResponseEntity(productResponceList, HttpStatus.FOUND);
    }
}
