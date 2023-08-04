package com.example.ShoppingVerse.transformer;

import com.example.ShoppingVerse.Module.Seller;
import com.example.ShoppingVerse.dto.request.SellerRequest;
import com.example.ShoppingVerse.dto.responce.SellerResponce;

public class SellerTransformer {

    public static Seller SellerRequestToSeller(SellerRequest sellerRequest){
        return Seller.builder()
                .name(sellerRequest.getName())
                .sellerEmailId(sellerRequest.getSellerEmailId())
                .panNo(sellerRequest.getPan())
                .build();
    }

    public static SellerResponce SellerToSelleResponce(Seller seller){
        return SellerResponce.builder()
                .name(seller.getName())
                .sellerEmailId(seller.getSellerEmailId())
                .pan(seller.getPanNo())
                .build();
    }
}
