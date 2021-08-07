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
            return null;
        }else {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedPosition.put(parkingTicket, car);
            return parkingTicket;
       }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;

    }

    private boolean isFull(){
            return parkedPosition.size() == DEFAULT_LIMIT;
    }
}
