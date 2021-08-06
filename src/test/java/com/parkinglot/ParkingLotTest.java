package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);
        
        //then
        assertNotNull(parkingTicket);
    }
    
    @Test
    void should_return_car_when_fetch_given_parking_ticket_and_parked_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
                
        //when
        Car parkedCar = parkingLot.fetch(car);
        
        //then
        assertEquals(parkedCar, car);
    }
    
    
}
