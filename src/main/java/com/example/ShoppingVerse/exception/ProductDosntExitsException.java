package com.example.ShoppingVerse.exception;

public class ProductDosntExitsException extends RuntimeException{

    public ProductDosntExitsException(String message){
        super(message);
    }
}
