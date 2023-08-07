package com.example.ShoppingVerse.Repository;

public class InsufficentQuantityException extends RuntimeException{

    public InsufficentQuantityException(String message){
        super(message);
    }
}
