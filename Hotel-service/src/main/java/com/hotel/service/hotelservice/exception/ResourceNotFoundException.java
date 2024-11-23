package com.hotel.service.hotelservice.exception;

public class ResourceNotFoundException extends RuntimeException{

   public ResourceNotFoundException(String message){
        super(message);
    }
}
