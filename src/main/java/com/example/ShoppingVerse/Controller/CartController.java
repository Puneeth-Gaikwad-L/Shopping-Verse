package com.example.ShoppingVerse.Controller;

import com.example.ShoppingVerse.Module.Item;
import com.example.ShoppingVerse.exception.InsufficentQuantityException;
import com.example.ShoppingVerse.exception.ProductDosntExitsException;
import com.example.ShoppingVerse.Service.CartService;
import com.example.ShoppingVerse.Service.ItemService;
import com.example.ShoppingVerse.dto.request.ItemRequestDto;
import com.example.ShoppingVerse.dto.responce.CartResponeDto;
import com.example.ShoppingVerse.exception.CustomerNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ItemService itemService;

    @Autowired
    CartService cartService;

    @PostMapping("/add_to_cart")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){
        try{
            Item item = itemService.createItem(itemRequestDto);
            CartResponeDto cartResponeDto = cartService.addItemToCart(itemRequestDto,item);
            return new ResponseEntity<>(cartResponeDto,HttpStatus.ACCEPTED);
        }catch (CustomerNotFound | ProductDosntExitsException | InsufficentQuantityException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
