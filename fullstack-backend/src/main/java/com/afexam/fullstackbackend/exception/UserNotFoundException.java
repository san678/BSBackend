package com.afexam.fullstackbackend.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id){
        super("Could not found user id "+id);
    }
}
