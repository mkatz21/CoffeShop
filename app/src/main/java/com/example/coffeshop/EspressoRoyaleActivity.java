package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class EspressoRoyaleActivity extends AppCompatActivity implements View.OnClickListener,
        RadioButton.OnCheckedChangeListener {
    Spinner spinnerReservationDuration, spinnerReservationTableType, spinnerERtimeslots;
    TextView textViewCurrentPrice;
    Button buttonAvailabilityBookNow;
    RadioButton radioButtonOwnTable, radioButtonSharedTable, radioButton30,radioButton1,radioButton1half,radioButton2;

    //Declare prices
    Double dblthirtyprice = 5.00;
    Double dblshareddiscount = 3.00;
    Double newprice;
    Double oldprice=5.00;

    //String ERTimeSlot1 = "10:00am";
    //String ERTimeSlot2 = "10:30am";
    //String ERTimeSlot3 = "11:00am";
    //String ERTimeSlot4 = "11:30am";
    //String ERTimeSlot5 = "12:00pm";
    //String ERTimeSlot6 = "12:30pm";
    //String ERTimeSlot7 = "1:00pm";
    //String ERTimeSlot8 = "1:30pm";
    //String ERTimeSlot9 = "2:00pm";
    //String ERTimeSlot10 = "2:30pm";
    //String ERTimeSlot11 = "3:00pm";
    //String ERTimeSlot12 = "3:30pm";
    //String ERTimeSlot13 = "4:00pm";
    //String ERTimeSlot14 = "4:30pm";
    //String ERTimeSlot15 = "5:00pm";

    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_royale);

        textViewCurrentPrice = findViewById(R.id.textViewCurrentPrice);

        spinnerReservationDuration = findViewById(R.id.spinnerAvailabilityDuration);
        spinnerReservationTableType = findViewById(R.id.spinnerAvailabilityTableType);

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

        spinnerERtimeslots = findViewById(R.id.spinnerERtimeslots);
        ArrayAdapter<CharSequence> adapterERtimeslots = ArrayAdapter.createFromResource(this,R.array.timeslots, android.R.layout.simple_spinner_item);
        adapterERtimeslots.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerERtimeslots.setAdapter(adapterERtimeslots);

        // Create an ArrayAdapter using the string array and a default spinner layout
        //ArrayAdapter<CharSequence> adapterDuration = ArrayAdapter.createFromResource(this,
                //R.array.reservation_duration_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        //adapterDuration.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        //ArrayAdapter<CharSequence> adapterTableType = ArrayAdapter.createFromResource(this,
                //R.array.reservation_table_type_array, android.R.layout.simple_spinner_item);
        //adapterTableType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //This code is to change the checkout price as reservation table type changes
        //spinnerReservationTableType.setAdapter(adapterTableType);

        //This code is to change the checkout price as duration changes
        //spinnerReservationDuration.setAdapter(adapterDuration);
        //spinnerReservationDuration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

    }

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

    public void UpdateCheckOutPrice() {
        if (radioButtonOwnTable.isChecked() & radioButton30.isChecked()) {
            newprice = oldprice*1;
        } else if (radioButtonSharedTable.isChecked() & radioButton30.isChecked()){
            newprice = oldprice-dblshareddiscount;
        } else if (radioButtonOwnTable.isChecked() & radioButton1.isChecked()){
            newprice = oldprice*2;
        } else if (radioButtonSharedTable.isChecked() & radioButton1.isChecked()){
            newprice = (oldprice)*2-dblshareddiscount;
        } else if (radioButtonOwnTable.isChecked() & radioButton1half.isChecked()){
            newprice = oldprice*3;
        } else if (radioButtonSharedTable.isChecked() & radioButton1half.isChecked()){
            newprice = (oldprice)*3-dblshareddiscount;
        } else if (radioButtonOwnTable.isChecked() & radioButton2.isChecked()){
            newprice = oldprice*4;
        } else if (radioButtonSharedTable.isChecked() & radioButton2.isChecked()) {
            newprice = (oldprice) * 4 - dblshareddiscount;
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
        if (item.getItemId() == R.id.MainPayment) {

            Intent mainPaymentIntent = new Intent(this, MainPaymentActivity.class);
            startActivity(mainPaymentIntent);

        } else if (item.getItemId() == R.id.CoffeeShop) {

            Toast.makeText(this, "You are already on the Coffee Shop Page", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.Account) {

            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);

        } else if (item.getItemId() == R.id.AddPayment) {

            Intent addPaymentIntent = new Intent(this, AddPaymentMethodActivity.class);
            startActivity(addPaymentIntent);
        } else if (item.getItemId() == R.id.CheckIn) {

            Intent checkInIntent = new Intent(this, CheckInActivity.class);
            startActivity(checkInIntent);
        } else if (item.getItemId() == R.id.Home) {

            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
        } else if (item.getItemId() == R.id.SignUp) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        }
}
