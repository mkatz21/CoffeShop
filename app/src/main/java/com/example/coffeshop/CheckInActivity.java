package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CheckInActivity extends AppCompatActivity implements View.OnClickListener {

    String reservationCoffeeShop, reservationCoffeeShopStreet, reservationCoffeeShopCity, reservationSpinnerTime, reservationDate;
    TextView textViewReservationCoffeeShop, textViewReservationCoffeeShopStreet, textViewReservationCoffeeShopCity, textViewDate, textViewTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);


        textViewDate = findViewById(R.id.textViewDate);
        textViewTime = findViewById(R.id.textViewTime);
        textViewReservationCoffeeShop = findViewById(R.id.textViewReservationCoffeeShop);
        textViewReservationCoffeeShopCity = findViewById(R.id.textViewReservationCoffeeShopCity);
        textViewReservationCoffeeShopStreet = findViewById(R.id.textViewReservationCoffeeShopStreet);

        Intent checkInIntent =getIntent();
        if (checkInIntent != null){
            reservationCoffeeShop = checkInIntent.getStringExtra("Coffee Shop");
            textViewReservationCoffeeShop.setText(reservationCoffeeShop);
            reservationCoffeeShopStreet = checkInIntent.getStringExtra("Street");
            textViewReservationCoffeeShopStreet.setText(reservationCoffeeShopStreet);
            reservationCoffeeShopCity = checkInIntent.getStringExtra("City");
            textViewReservationCoffeeShopCity.setText(reservationCoffeeShopCity);
            reservationDate = checkInIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
            reservationSpinnerTime = checkInIntent.getStringExtra("time");
            textViewTime.setText(reservationSpinnerTime);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
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

            Intent addPaymentIntent = new Intent(this, AddPaymentMethodActivity.class);
            startActivity(addPaymentIntent);
        } else if(item.getItemId() == R.id.Home) {

            Intent HomeIntent = new Intent(this, HomeActivity.class);
            startActivity(HomeIntent);
        } else if(item.getItemId() == R.id.CoffeeShop) {

            Intent coffeeShopIntent = new Intent(this, CoffeeShopActivity.class);
            startActivity(coffeeShopIntent);
        } else if(item.getItemId() == R.id.SignUp) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
