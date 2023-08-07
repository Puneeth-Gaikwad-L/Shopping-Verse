package com.example.ShoppingVerse.transformer;

import com.example.ShoppingVerse.Module.Item;
import com.example.ShoppingVerse.dto.request.ItemRequestDto;
import com.example.ShoppingVerse.dto.responce.ItemResponceDto;

public class ItemTransformer {

    public static Item itemrequestToItem(int requiredQuantity){
        return Item.builder()
                .requiredQuantity(requiredQuantity)
                .build();
    }
    public static ItemResponceDto itemToItemResponce(Item item){
        return ItemResponceDto.builder()
                .itemName(item.getProduct().getProductName())
                .itemPrice(item.getProduct().getPrice())
                .addedQuantity(item.getRequiredQuantity())
                .category(item.getProduct().getCategory())
                .build();
    }
}
