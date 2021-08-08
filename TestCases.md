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