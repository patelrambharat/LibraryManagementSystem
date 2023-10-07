package com.example.librarymanagementsystem.exception;

public class BookNotAvailable extends RuntimeException{
    public BookNotAvailable(String message){
        super(message);
    }
}
