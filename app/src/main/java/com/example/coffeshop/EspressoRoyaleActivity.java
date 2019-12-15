package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.text.NumberFormat;

public class EspressoRoyaleActivity extends AppCompatActivity implements View.OnClickListener,
        RadioButton.OnCheckedChangeListener {

    String reservationCoffeeShop, reservationDate, reservationTable, reservationPrice, reservationCoffeeShopStreet, reservationCoffeeShopCity;
    String reservationDuration;
    String reservationSpinnerTime;
    TextView textViewEspressoRoyale, textViewDate, textViewEspressoRoyaleStreet, textViewEspressoRoyaleCity;

    Spinner spinnerERtimeslots;
    TextView textViewCurrentPrice;
    Button buttonAvailabilityBookNow;
    RadioButton radioButtonOwnTable, radioButtonSharedTable, radioButton30,radioButton1,radioButton1half,radioButton2;

    //Declare prices and discounts
    Double dblshareddiscount = 3.00;
    Double newprice;
    Double oldprice=5.00;


    //Setting the price into a Currency format
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_royale);

        textViewEspressoRoyale = findViewById(R.id.textViewEspressoRoyale);
        textViewDate = findViewById(R.id.textViewReservationDate);
        textViewEspressoRoyaleStreet = findViewById(R.id.textViewEspressoRoyaleStreet);
        textViewEspressoRoyaleCity = findViewById(R.id.textViewEspressoRoyaleCity);

        textViewCurrentPrice = findViewById(R.id.textViewCurrentPrice);

        buttonAvailabilityBookNow = findViewById(R.id.buttonAvailabilityBookNow);

        radioButtonOwnTable = findViewById(R.id.radioButtonOwnTable);
        radioButtonSharedTable = findViewById(R.id.radioButtonSharedTable);
        radioButton30 = findViewById(R.id.radioButton30);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton1half = findViewById(R.id.radioButton1half);
        radioButton2 = findViewById(R.id.radioButton2);

        buttonAvailabilityBookNow.setOnClickListener(this);
        radioButtonOwnTable.setOnCheckedChangeListener(this);
        radioButtonSharedTable.setOnCheckedChangeListener(this);
        radioButton30.setOnCheckedChangeListener(this);
        radioButton1.setOnCheckedChangeListener(this);
        radioButton1half.setOnCheckedChangeListener(this);
        radioButton2.setOnCheckedChangeListener(this);

        //Creating spinner and setting it with the array timeslots
        spinnerERtimeslots = findViewById(R.id.spinnerERtimeslots);
        ArrayAdapter<CharSequence> adapterERtimeslots = ArrayAdapter.createFromResource(this, R.array.timeslots, android.R.layout.simple_spinner_item);
        adapterERtimeslots.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerERtimeslots.setAdapter(adapterERtimeslots);

        Intent cometIntent = getIntent();
        if (cometIntent != null) {
            reservationDate = cometIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
        }
    }

    //Setting up what happens when each button is clicked from the duration point of view
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (radioButton30.isChecked()) {
            UpdateCheckOutPrice();
        } else if (radioButton1.isChecked()){
            UpdateCheckOutPrice();
        } else if (radioButton1half.isChecked()){
            UpdateCheckOutPrice();
        } else if (radioButton2.isChecked()){
            UpdateCheckOutPrice();
        }
    }

    //This is the code to update the price based on the combination of what radio buttons have been clicked
    public void UpdateCheckOutPrice() {
        if (radioButtonOwnTable.isChecked() & radioButton30.isChecked()) {
            newprice = oldprice*1;
            reservationDuration = "30 minutes";
            reservationTable = "Own Table";
        } else if (radioButtonSharedTable.isChecked() & radioButton30.isChecked()){
            newprice = oldprice-dblshareddiscount;
            reservationDuration = "30 minutes";
            reservationTable = "Shared Table";
        } else if (radioButtonOwnTable.isChecked() & radioButton1.isChecked()){
            newprice = oldprice*2;
            reservationDuration = "1 hour";
            reservationTable = "Own Table";
        } else if (radioButtonSharedTable.isChecked() & radioButton1.isChecked()){
            newprice = (oldprice)*2-dblshareddiscount;
            reservationDuration = "1 hour";
            reservationTable = "Shared Table";
        } else if (radioButtonOwnTable.isChecked() & radioButton1half.isChecked()){
            newprice = oldprice*3;
            reservationDuration = "1.5 hours";
            reservationTable = "Own Table";
        } else if (radioButtonSharedTable.isChecked() & radioButton1half.isChecked()){
            newprice = (oldprice)*3-dblshareddiscount;
            reservationDuration = "1.5 hours";
            reservationTable = "Shared Table";
        } else if (radioButtonOwnTable.isChecked() & radioButton2.isChecked()){
            newprice = oldprice*4;
            reservationDuration = "2 hours";
            reservationTable = "Own Table";
        } else if (radioButtonSharedTable.isChecked() & radioButton2.isChecked()) {
            newprice = (oldprice) * 4 - dblshareddiscount;
            reservationDuration = "2 hours";
            reservationTable = "Shared Table";
        }

        textViewCurrentPrice.setText(formatter.format(newprice));

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.YourReservations) {

            Intent mainPaymentIntent = new Intent(this, MainPaymentActivity.class);
            startActivity(mainPaymentIntent);

        } else if (item.getItemId() == R.id.Logout) {

            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Logout successful", Toast.LENGTH_LONG).show();
            Intent logoutIntent = new Intent(this, LogInActivity.class);
            startActivity(logoutIntent);

        } else if (item.getItemId() == R.id.Account) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);

        } else if (item.getItemId() == R.id.Home) {

            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    // Creating strings from info, including the basic info of the coffeeshop and sending it up to the add payment page
    @Override
    public void onClick(View view) {
        reservationCoffeeShop = textViewEspressoRoyale.getText().toString();
        reservationCoffeeShopStreet = textViewEspressoRoyaleStreet.getText().toString();
        reservationCoffeeShopCity = textViewEspressoRoyaleCity.getText().toString();
        reservationPrice = textViewCurrentPrice.getText().toString();
        reservationSpinnerTime = spinnerERtimeslots.getSelectedItem().toString();

        Intent reservationIntent = new Intent(this, AddPaymentMethodActivity.class);
        reservationIntent.putExtra("date", reservationDate);
        reservationIntent.putExtra("time", reservationSpinnerTime);
        reservationIntent.putExtra("Coffee Shop", reservationCoffeeShop);
        reservationIntent.putExtra("Duration", reservationDuration);
        reservationIntent.putExtra("Table Type", reservationTable);
        reservationIntent.putExtra("Price", reservationPrice);
        reservationIntent.putExtra("Street", reservationCoffeeShopStreet);
        reservationIntent.putExtra("City", reservationCoffeeShopCity);
        startActivity(reservationIntent);
        }
}
