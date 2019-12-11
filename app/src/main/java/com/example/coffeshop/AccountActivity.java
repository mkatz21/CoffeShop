package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    Button AccountDetails, PastReservations, Payments, Review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        AccountDetails = findViewById(R.id.AccountDetails);
        PastReservations = findViewById(R.id.PastReservations);
        Payments = findViewById(R.id.Payments);
        Review = findViewById(R.id.Review);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.YourReservations) {

            Intent mainPaymentIntent = new Intent(this, MainPaymentActivity.class);
            startActivity(mainPaymentIntent);

        } else if(item.getItemId() == R.id.CheckIn) {

            Toast.makeText(this, "You are already on the Check In Page", Toast.LENGTH_SHORT).show();

        } else if(item.getItemId() == R.id.Account) {

            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);

        } else if(item.getItemId() == R.id.AddPayment) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);

        } else if(item.getItemId() == R.id.Home) {

            Intent HomeIntent = new Intent(this, HomeActivity.class);
            startActivity(HomeIntent);
        } else if(item.getItemId() == R.id.Logout) {

            Intent coffeeShopIntent = new Intent(this, CoffeeShopActivity.class);
            startActivity(coffeeShopIntent);
        }

        return super.onOptionsItemSelected(item);
    }


}
