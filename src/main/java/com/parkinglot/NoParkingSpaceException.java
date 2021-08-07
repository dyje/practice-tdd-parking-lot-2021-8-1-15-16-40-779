package com.parkinglot;

public class NoParkingSpaceException extends RuntimeException {
    @Override
    public String getMessage(){
        return "No available position.";
    }
}
