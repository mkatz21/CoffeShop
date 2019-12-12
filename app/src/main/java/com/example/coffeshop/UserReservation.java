package com.example.coffeshop;

public class UserReservation {

    public String userreservationcoffeeshop;
    public String UserReservationDate;
    public String userreservationbookingID;
    public String Firstname;
    public String Lastname;
    public String CreditCardName;
    public String PostalCode;
    public String ExpirationDate;
    public String CCVNumber;
    public String ReservationDuration;
    public String ReservationTime;
    public String TableType;
    public String PricePaid;
    public String email;

    public UserReservation(){

    }

    public String getUserreservationcoffeeshop() {
        return userreservationcoffeeshop;
    }

    public void setUserreservationcoffeeshop(String userreservationcoffeeshop) {
        this.userreservationcoffeeshop = userreservationcoffeeshop;
    }

    public String getUserreservationbookingID() {
        return userreservationbookingID;
    }

    public void setUserreservationbookingID(String userreservationbookingID) {
        this.userreservationbookingID = userreservationbookingID;
    }

    public UserReservation(String userreservationcoffeeshop, String UserReservationDate, String Firstname, String Lastname, String CreditCardName, String PostalCode, String ExpirationDate, String CCVNumber, String ReservationDuration, String ReservationTime, String TableType, String PricePaid, String userreservationbookingID, String email) {

        this.userreservationcoffeeshop = userreservationcoffeeshop;
        this.UserReservationDate = UserReservationDate;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.CreditCardName = CreditCardName;
        this.PostalCode = PostalCode;
        this.ExpirationDate = ExpirationDate;
        this.CCVNumber = CCVNumber;
        this.ReservationDuration = ReservationDuration;
        this.ReservationTime = ReservationTime;
        this.TableType = TableType;
        this.PricePaid = PricePaid;
        this.userreservationbookingID = userreservationbookingID;
        this.email = email;
    }
}
