package com.example.coffeshop;

import java.util.Date;

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
