package com.parkinglot;

public class UsedTicketException extends RuntimeException{
    @Override

    public String getMessage(){
        return "Parking ticket is used already.";
    }
}
