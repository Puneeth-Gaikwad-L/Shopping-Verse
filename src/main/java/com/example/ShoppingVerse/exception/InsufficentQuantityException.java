package com.example.ShoppingVerse.exception;

public class InsufficentQuantityException extends RuntimeException{

    public InsufficentQuantityException(String message){
        super(message);
    }
}
