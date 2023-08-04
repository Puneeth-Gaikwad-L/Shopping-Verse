package com.example.ShoppingVerse.exception;

public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound(String message){
        super(message);
    }
}
