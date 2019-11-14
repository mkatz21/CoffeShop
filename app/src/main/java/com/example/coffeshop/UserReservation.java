package com.example.coffeshop;

public class UserReservation {

    public String UserReservationCoffeeShop;
    public String UserReservationDate;
    public String UserReservationBookingID;

    public UserReservation() {
    }

    public UserReservation(String userReservationCoffeeShop, String userReservationDate, String userReservationBookingID) {
        UserReservationCoffeeShop = userReservationCoffeeShop;
        UserReservationDate = userReservationDate;
        UserReservationBookingID = userReservationBookingID;
    }
}
