package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    
    @Test
    void should_return_nothing_when_fetch_given_parked_car_and_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when
        Car actualCar = parkingLot.fetch(wrongParkingTicket);
        
        //then
        assertNull(actualCar);
    }
    
    @Test
    void should_return_nothing_when_fetch_given_parked_car_and_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket); //used already
                
        //when
        Car actualCar = parkingLot.fetch(parkingTicket);
        
        //then
        assertNull(actualCar);
    }
    
    @Test
    void should_return_nothing_when_park_given_parking_lot_no_slot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();

        //when
        ParkingTicket parkingTicketForCar1 = parkingLot.park(car1);
        ParkingTicket parkingTicketForCar2 = parkingLot.park(car2);
        ParkingTicket parkingTicketForCar3 = parkingLot.park(car3);
        ParkingTicket parkingTicketForCar4 = parkingLot.park(car4);
        ParkingTicket parkingTicketForCar5 = parkingLot.park(car5);
        ParkingTicket parkingTicketForCar6 = parkingLot.park(car6);
        ParkingTicket parkingTicketForCar7 = parkingLot.park(car7);
        ParkingTicket parkingTicketForCar8 = parkingLot.park(car8);
        ParkingTicket parkingTicketForCar9 = parkingLot.park(car9);
        ParkingTicket parkingTicketForCar10 = parkingLot.park(car10);


        //then
        assertNull(parkingTicketForCar10);

    }
    
    
    
}
