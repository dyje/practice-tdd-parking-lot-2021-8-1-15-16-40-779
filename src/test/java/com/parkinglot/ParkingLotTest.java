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
        Car parkedCar = parkingLot.fetch(parkingTicket);
        
        //then
        assertEquals(parkedCar, car);
    }
    
    @Test
    void should_return_the_right_car_when_fetch_twice_given_two_parked_cars_and_two_parking_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket car1ParkingTicket = parkingLot.park(car1);
        ParkingTicket car2ParkingTicket = parkingLot.park(car2);

                
        //when
        Car actualCar1 = parkingLot.fetch(car1ParkingTicket);
        Car actualCar2 = parkingLot.fetch(car2ParkingTicket);
        
        //then
        assertEquals(actualCar1, car1);
        assertEquals(actualCar2, car2);
    }
    
}
