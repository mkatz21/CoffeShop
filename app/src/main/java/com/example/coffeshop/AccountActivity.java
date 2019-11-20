package com.example.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AccountActivity extends AppCompatActivity {

    Button AccountDetails, PastReservations, Payments, Review;

    @Override
    protected void onCreate(Bundle savedInstanceState)


    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);



        AccountDetails = findViewById(AccountDetails);
        PastReservations = findViewById(PastReservations);
        Payments = findViewById(Payments);
        Review = findViewById(Review);
    }

}
