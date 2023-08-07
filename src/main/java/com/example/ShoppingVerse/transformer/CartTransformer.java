package com.example.ShoppingVerse.transformer;

import com.example.ShoppingVerse.Module.Cart;
import com.example.ShoppingVerse.Module.Item;
import com.example.ShoppingVerse.dto.responce.CartResponeDto;
import com.example.ShoppingVerse.dto.responce.ItemResponceDto;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {

    public static CartResponeDto cartToCartResponce(Cart cart){
        List<ItemResponceDto> itemResponceDtoList = new ArrayList<>();
        for(Item item: cart.getItems()){
            itemResponceDtoList.add(ItemTransformer.itemToItemResponce(item));
        }
        return CartResponeDto.builder()
                .customerName(cart.getCustomer().getName())
                .cartTotal(cart.getCartTotal())
                .cartItems(itemResponceDtoList)
                .build();
    }
}
