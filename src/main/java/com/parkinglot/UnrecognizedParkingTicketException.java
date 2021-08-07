package com.parkinglot;

public class UnrecognizedParkingTicketException extends RuntimeException{
    @Override

    public String getMessage(){
        return "Invalid Ticket.";
    }

}
