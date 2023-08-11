package com.example.ShoppingVerse.Controller;
import com.example.ShoppingVerse.Enum.ProductCategory;
import com.example.ShoppingVerse.Service.ProductService;
import com.example.ShoppingVerse.dto.request.ProductRequest;
import com.example.ShoppingVerse.dto.responce.ProductResponce;
import com.example.ShoppingVerse.exception.SellerNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequest productRequest){
        try {
            ProductResponce productResponce = productService.addProduct(productRequest);
            return new ResponseEntity(productResponce, HttpStatus.CREATED);
        }catch (SellerNotFound e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
