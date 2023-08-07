package com.example.ShoppingVerse.Repository;

public class ProductDosntExitsException extends RuntimeException{

    public ProductDosntExitsException(String message){
        super(message);
    }
}
