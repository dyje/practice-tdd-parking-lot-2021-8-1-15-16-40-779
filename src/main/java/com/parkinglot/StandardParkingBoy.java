package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<>();
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public ParkingTicket park(Car car) {
        return getAvailableParkingLot().park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return getAvailableParkingLot().fetch(parkingTicket);
    }

    private ParkingLot getAvailableParkingLot(){
        return parkingLots
                .stream()
                .filter(ParkingLot::isSlotAvailable)
                .findFirst()
                .orElseThrow(NoParkingSpaceException::new);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
