package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLots = parkingLot;
    }

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public ParkingTicket park(Car car) {
        return getAvailableParkingLot().park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return findParkingLot(parkingTicket).fetch(parkingTicket);
    }

    private ParkingLot getAvailableParkingLot(){
        return parkingLots
                .stream()
                .filter(ParkingLot::isSlotAvailable)
                .findFirst()
                .orElseThrow(NoParkingSpaceException::new);
    }

    private ParkingLot findParkingLot (ParkingTicket parkingTicket){
        return parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.isRelated(parkingTicket))
                .findFirst()
                .orElseThrow(UnrecognizedParkingTicketException::new);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
