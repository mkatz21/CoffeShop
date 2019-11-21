package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_payment);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.Home) {

            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);

        } else if(item.getItemId() == R.id.MainPayment) {

            Toast.makeText(this, "You are already on the Home Page", Toast.LENGTH_SHORT).show();

        } else if(item.getItemId() == R.id.Account) {

            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);

        } else if(item.getItemId() == R.id.AddPayment) {

            Intent addPaymentIntent = new Intent(this, AddPaymentMethodActivity.class);
            startActivity(addPaymentIntent);
        } else if(item.getItemId() == R.id.CheckIn) {

            Intent checkInIntent = new Intent(this, CheckInActivity.class);
            startActivity(checkInIntent);
        } else if(item.getItemId() == R.id.CoffeeShop) {

            Intent coffeeShopIntent = new Intent(this, CoffeeShopActivity.class);
            startActivity(coffeeShopIntent);
        } else if(item.getItemId() == R.id.SignUp) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}