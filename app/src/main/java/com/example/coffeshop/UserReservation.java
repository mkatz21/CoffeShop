package com.example.coffeshop;

public class UserReservation {

    public String UserReservationCoffeeShop;
    public String UserReservationDate;
    public String UserReservationBookingID;
    public String Firstname;
    public String Lastname;
    public String CreditCardName;
    public String PostalCode;
    public String ExpirationDate;
    public String CCVNumber;
    public String ReservationDuration;
    public String ReservationTime;

    public UserReservation(){

    }

    public UserReservation(String UserReservationCoffeeShop, String UserReservationDate, String creditCardName, String expirationDate, String CCVNumber, String postalCode, String firstname, String lastname, String ReservationDuration, String ReservationTime) {
    }

    public UserReservation(String userReservationCoffeeShop, String userReservationDate, String userReservationBookingID, String firstname, String lastname, String creditCardName, String postalCode, String expirationDate, String CCVNumber) {
        this.UserReservationCoffeeShop = userReservationCoffeeShop;
        this.UserReservationDate = userReservationDate;
        this.UserReservationBookingID = userReservationBookingID;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.CreditCardName = creditCardName;
        this.PostalCode = postalCode;
        this.ExpirationDate = expirationDate;
        this.CCVNumber = CCVNumber;
        this.ReservationDuration = ReservationDuration;
        this.ReservationTime = ReservationTime;
    }
}
