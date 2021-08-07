package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    //private Car car;
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private static int DEFAULT_LIMIT = 10;

    public ParkingLot(int capacity) {
        DEFAULT_LIMIT = capacity;
    }

    public ParkingLot() {
    }

    public ParkingTicket park(Car car) {
        if (isFull()){
            throw new NoParkingSpaceException();
        }else {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedPosition.put(parkingTicket, car);
            return parkingTicket;
       }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (isRecognizedTicket(parkingTicket)){
            Car car = parkedPosition.get(parkingTicket);
            parkedPosition.remove(parkingTicket);
            return car;
        }else
            throw new UnrecognizedParkingTicketException();

    }

    private boolean isFull(){
            return parkedPosition.size() == DEFAULT_LIMIT;
    }

    private boolean isRecognizedTicket (ParkingTicket parkingTicket){
        return parkedPosition.containsKey(parkingTicket);
    }
}
