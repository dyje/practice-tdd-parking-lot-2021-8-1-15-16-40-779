package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    //private Car car;
    private Map<ParkingTicket, Car> parkingSlotPosition = new HashMap<>();
    private static int DEFAULT_LIMIT = 10;
    private int capacity;

    public ParkingLot(int parkingLotCapcity) {
        this.capacity = parkingLotCapcity;
    }

    public ParkingLot() {
        capacity = DEFAULT_LIMIT;
    }

    public ParkingTicket park(Car car) {
        if (isFull()){
            throw new NoParkingSpaceException();
        }else {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingSlotPosition.put(parkingTicket, car);
            return parkingTicket;
       }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (isRecognizedTicket(parkingTicket)){
            Car car = parkingSlotPosition.get(parkingTicket);
            parkingSlotPosition.remove(parkingTicket);
            return car;
        }else
            throw new UnrecognizedParkingTicketException();

    }

    public boolean isFull(){
            return parkingSlotPosition.size() == DEFAULT_LIMIT;
    }

    public boolean isRecognizedTicket (ParkingTicket parkingTicket){
        return parkingSlotPosition.containsKey(parkingTicket);
    }

    public boolean isSlotAvailable (){
        return parkingSlotPosition.size() < capacity;
    }

    public Map<ParkingTicket, Car> getParkingSlotPosition() {
        return parkingSlotPosition;
    }


}
