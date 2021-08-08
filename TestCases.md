# story 1
[X] Case1  
    Given a parking lot and a car  
    When park the car  
    Then return a parking ticket.

[X] Case2
    Given a Car and parking ticket
    When fetch the car
    Then return car

[X] Case3
    Given a Car and a fake ticket
    When fetch the car
    Then return no Car

[X] Case4
    Given a Car and a used parking ticket
    When fetch the car
    Then return no Car

[X] Case5
    Given a Car and a no parking ticket
    When fetch the car
    Then return no Car

[X] Case6
    Given a Car and full parking lot
    When park the car
    Then return no car is parked

# story 2 
[X] Case1 
    Given parking lot, and an unrecognized ticket 
    When fetch the car 
    Then display error message "Unrecognized parking ticket"

[X] Case2 
    Given parking lot, and a used ticket 
    When fetch the car 
    Then display error message "Unrecognized parking ticket"

[X] Case3 
    Given parking lot, without any position and a car 
    When park the car 
    Then display error message "No available position"

# story 3
[X] Case1 
    Given a parking lot, a standard parking boy, and a car 
    When park the car 
    Then return a parking ticket

[X] Case2 
    Given a parking lot with a parked card, a standard parking boy, and a parking ticket 
    When fetch the car 
    Then return the car

[X] Case3 
    Given a parking lot with two parked cars, a standard parking boy, and two parking tickets 
    When fetch the car 
    Then return the right car with each ticket

[X] Case4 
    Given a parking lot, a standard parking boy, and a wrong parking ticket 
    When fetch the car 
    Then return nothing with error message "Unrecognized parking ticket."

[X] Case5 
    Given a parking lot, a standard parking boy, and a used parking ticket 
    When fetch the car 
    Then return nothing with error message "Unrecognized parking ticket."

[X] Case6 
    Given a parking lot without any position a standard parking boy, and a car 
    When park the car 
    Then return nothing with error message "No available position."

# story 4
[X] Case1
    Given a standard parking boy, two parking lots and both available, and a car
    When park the car
    Then return ticket and park car to the first parking lot

[X] Case2
    Given a standard parking boy, two parking lots and first is full and second is available, and a car
    When park the car
    Then return ticket and park car to the second parking lot

[X] Case3
    Given a standard parking boy, two parking lots, both with parked car and parking ticket
    When fetch the car twice
    Then return right car with each ticket

[X] Case4
    Given a standard parking boy, two parking lots, unrecognized ticket
    When fetch the car
    Then return nothing with error message "Unrecognized parking ticket."

[X] Case5
    Given a standard parking boy, two parking lots, used ticket
    When fetch the car
    Then return nothing with error message "Unrecognized parking ticket."

[X] Case6
    Given a standard parking boy, two parking lots, no available parking slot for both
    When park the car
    Then return nothing with error message "No available position."