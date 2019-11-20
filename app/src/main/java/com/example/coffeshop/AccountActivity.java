package com.example.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    Button AccountDetails, PastReservations, Payments, Review;

    @Override
    protected void onCreate(Bundle savedInstanceState)


    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);



        AccountDetails = findViewById(R.id.AccountDetails);
        PastReservations = findViewById(R.id.PastReservations);
        Payments = findViewById(R.id.Payments);
        Review = findViewById(R.id.Review);
    }

    @Override
    public void onClick(View v) {


    }
}
