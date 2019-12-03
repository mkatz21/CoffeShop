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
    public int CCVNumber;


    public UserReservation() {
    }

    public UserReservation(String userReservationCoffeeShop, String userReservationDate, String userReservationBookingID, String firstname, String lastname, String creditCardName, String postalCode, String expirationDate, int CCVNumber) {
        this.UserReservationCoffeeShop = userReservationCoffeeShop;
        this.UserReservationDate = userReservationDate;
        this.UserReservationBookingID = userReservationBookingID;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.CreditCardName = creditCardName;
        this.PostalCode = postalCode;
        this.ExpirationDate = expirationDate;
        this.CCVNumber = CCVNumber;
    }
}
