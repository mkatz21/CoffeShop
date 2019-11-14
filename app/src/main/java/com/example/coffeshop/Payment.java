package com.example.coffeshop;

import java.util.Date;

public class Payment {

    public String PaymentUserName;
    public Integer PaymentCreditCardNumber;
    public String PaymentCreditCardName;
    public Integer PaymentZipCode;
    public Date PaymentExpirationDate;
    public Integer PaymentCSVNumber;
    public Boolean PaymentPrimaryPayment;
    public String PaymentNickName;

    public Payment() {
    }

    public Payment(String paymentUserName, Integer paymentCreditCardNumber, String paymentCreditCardName, Integer paymentZipCode, Date paymentExpirationDate, Integer paymentCSVNumber, Boolean paymentPrimaryPayment, String paymentNickName) {
        PaymentUserName = paymentUserName;
        PaymentCreditCardNumber = paymentCreditCardNumber;
        PaymentCreditCardName = paymentCreditCardName;
        PaymentZipCode = paymentZipCode;
        PaymentExpirationDate = paymentExpirationDate;
        PaymentCSVNumber = paymentCSVNumber;
        PaymentPrimaryPayment = paymentPrimaryPayment;
        PaymentNickName = paymentNickName;
    }
}
