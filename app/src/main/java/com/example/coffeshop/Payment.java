package com.example.coffeshop;

import java.util.Date;

//Creates the class where we can save individual credit card payment methods for future use as a saved part of a user's account
public class Payment {

    public String PaymentUserName;
    public Integer PaymentCreditCardNumber;
    public String PaymentCreditCardName;
    public Integer PaymentZipCode;
    public Date PaymentExpirationDate;
    public Integer PaymentCVVNumber;
    public Boolean PaymentPrimaryPayment;
    public String PaymentNickName;

    public Payment() {
    }

    public Payment(String paymentUserName, Integer paymentCreditCardNumber, String paymentCreditCardName, Integer paymentZipCode, Date paymentExpirationDate, Integer paymentCVVNumber, Boolean paymentPrimaryPayment, String paymentNickName) {
        PaymentUserName = paymentUserName;
        PaymentCreditCardNumber = paymentCreditCardNumber;
        PaymentCreditCardName = paymentCreditCardName;
        PaymentZipCode = paymentZipCode;
        PaymentExpirationDate = paymentExpirationDate;
        PaymentCVVNumber = paymentCVVNumber;
        PaymentPrimaryPayment = paymentPrimaryPayment;
        PaymentNickName = paymentNickName;
    }
}
