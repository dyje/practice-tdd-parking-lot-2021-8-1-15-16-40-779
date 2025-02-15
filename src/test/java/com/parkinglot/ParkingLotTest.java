package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        //Car actualCar = parkingLot.fetch(wrongParkingTicket);
        Exception exceptionMessage = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(wrongParkingTicket));

        //then
        //assertNull(actualCar);
        assertEquals("Unrecognized parking ticket.", exceptionMessage.getMessage());
    }

    @Test
    void should_return_nothing_when_fetch_given_parked_car_and_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);

        //when
        Exception exceptionMessage = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(parkingTicket));


        //then
        assertEquals("Unrecognized parking ticket.", exceptionMessage.getMessage());
    }

    @Test
    void should_return_throw_exception_with_error_message_given_parking_lot_no_slot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        List<ParkingTicket> parkingTickets = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            parkingTickets.add(parkingLot.park(car));
        }

        //when
        Exception exceptionMessage = assertThrows(NoParkingSpaceException.class, () -> parkingLot.park(car));

        //then
        assertEquals("No available position.", exceptionMessage.getMessage());

    }

    @Test
    void should_throw_exception_with_error_message_when_fetch_given_unrecognized_parking_ticket_and_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket unRecognizedTicket = new ParkingTicket();

        //when
        Exception exceptionMessage = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(unRecognizedTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exceptionMessage.getMessage());
    }

    @Test
    void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_car_and_standard_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);

    }

    @Test
    void should_return_car_when_fetch_given_parking_ticket_and_parked_car_and_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //when
        Car parkedCar = standardParkingBoy.fetch(parkingTicket);

        //then
        assertEquals(parkedCar, car);
    }

    @Test
    void should_return_the_right_car_when_fetch_twice_given_two_parked_cars_and_two_parking_tickets_and_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket car1ParkingTicket = standardParkingBoy.park(car1);
        ParkingTicket car2ParkingTicket = standardParkingBoy.park(car2);


        //when
        Car actualCar1 = standardParkingBoy.fetch(car1ParkingTicket);
        Car actualCar2 = standardParkingBoy.fetch(car2ParkingTicket);

        //then
        assertEquals(actualCar1, car1);
        assertEquals(actualCar2, car2);
    }

    @Test
    void should_throw_exception_with_error_message_when_fetch_given_parked_car_and_wrong_ticket_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when
        Exception exceptionMessage = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(wrongParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exceptionMessage.getMessage());
    }

    @Test
    void should_throw_exception_with_error_message_when_fetch_given_parked_car_and_used_ticket_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);

        //when
        Exception exceptionMessage = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(parkingTicket));


        //then
        assertEquals("Unrecognized parking ticket.", exceptionMessage.getMessage());
    }

    @Test
    void should_return_throw_exception_with_error_message_given_parking_lot_no_slot_and_a_car_and_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        List<ParkingTicket> parkingTickets = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            parkingTickets.add(parkingLot.park(car));
        }

        //when
        Exception exceptionMessage = assertThrows(NoParkingSpaceException.class, () -> parkingLot.park(car));

        //then
        assertEquals("No available position.", exceptionMessage.getMessage());

    }
    
    @Test
    void should_return_parking_ticket_from_first_parking_lot_when_park_given_two_parking_lots_and_available_slots_and_car_and_parking_boy() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        Car car = new Car();
                
        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        
        //then
        assertTrue(standardParkingBoy.getParkingLots().get(0).getParkingSlotPosition().containsKey(parkingTicket));
    }

    @Test
    void should_return_parking_ticket_from_second_parking_lot_when_park_given_first_parking_lot_is_full_and_car_and_parking_boy(){
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        Car car = new Car();
        List<ParkingTicket> parkingTicket = new LinkedList<>();

        for (int i = 0; i < 10 ; i++) {
            parkingTicket.add(standardParkingBoy.park(car));
        }

        //when
        ParkingTicket secondLotParkingTicket = standardParkingBoy.park(car);

        //then
        assertTrue(standardParkingBoy.getParkingLots().get(1).getParkingSlotPosition().containsKey(secondLotParkingTicket));
    }

    @Test
    void should_return_the_right_car_from_parking_lots_when_fetch_twice_given_two_parked_cars_and_two_parking_tickets_and_parking_boy() {
        Car car1 = new Car();
        Car car2 = new Car();
        StandardParkingBoy StandardParkingBoy = new StandardParkingBoy(new ParkingLot());
        ParkingTicket car1ParkingTicket = StandardParkingBoy.park(car1);
        ParkingTicket car2ParkingTicket = StandardParkingBoy.park(car2);

        //when
        Car actualCar1 = StandardParkingBoy.fetch(car1ParkingTicket);
        Car actualCar2 = StandardParkingBoy.fetch(car2ParkingTicket);

        //then
        assertEquals(car1, actualCar1);
        assertEquals(car2, actualCar2);
    }

    @Test
    void should_throw_exception_with_error_message_when_fetch_given_parked_car_and_parking_lots_and_wrong_ticket_a_parking_boy() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        //when
        Exception exceptionMessage = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(wrongParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exceptionMessage.getMessage());
    }

    @Test
    void should_throw_exception_with_error_message_when_fetch_given_parked_car_and_parking_lots_and_used_ticket_and_parking_boy() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy((Arrays.asList(new ParkingLot(), new ParkingLot())));
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(parkingTicket);

        //when
        Exception exceptionMessage = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(parkingTicket));


        //then
        assertEquals("Unrecognized parking ticket.", exceptionMessage.getMessage());
    }

    @Test
    void should_return_throw_exception_with_error_message_given_parking_lots_no_slot_and_a_car_and_parking_boy() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy((Arrays.asList(new ParkingLot(), new ParkingLot())));
        Car car = new Car();
        List<ParkingTicket> firstParkingLotParkingTicket = new LinkedList<>();
        List<ParkingTicket> secondParkingLotParkingTicket = new LinkedList<>();


        for (int i = 0; i < 10; i++) {
            firstParkingLotParkingTicket.add(standardParkingBoy.park(car));
        }
        for (int i = 0; i < 10; i++){
            secondParkingLotParkingTicket.add(standardParkingBoy.park(car));
        }

        //when
        Exception exceptionMessage = assertThrows(NoParkingSpaceException.class, () -> standardParkingBoy.park(car));

        //then
        assertEquals("No available position.", exceptionMessage.getMessage());

    }
    
}
