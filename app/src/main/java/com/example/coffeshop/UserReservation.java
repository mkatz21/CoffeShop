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
    public String TableType;
    public String PricePaid;

    public UserReservation(){

    }

    public UserReservation(String UserReservationCoffeeShop, String UserReservationDate, String Firstname, String Lastname, String CreditCardName, String PostalCode,String ExpirationDate, String CCVNumber, String ReservationDuration, String ReservationTime, String TableType, String PricePaid) {

        this.UserReservationCoffeeShop = UserReservationCoffeeShop;
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
    }
}
