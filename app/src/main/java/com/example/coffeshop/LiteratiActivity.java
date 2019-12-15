package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.text.NumberFormat;

public class LiteratiActivity extends AppCompatActivity implements View.OnClickListener,
        RadioButton.OnCheckedChangeListener {


    String reservationCoffeeShop, reservationDate, reservationSpinnerTime, reservationDuration, reservationTable, reservationPrice, reservationCoffeeShopStreet, reservationCoffeeShopCity;
    TextView textViewLiterati, textViewDate, textViewLiteratiStreet, textViewLiteratiCity;

    Spinner spinnerLITtimeslots;
    TextView textViewCurrentPrice;
    Button buttonAvailabilityBookNow;
    RadioButton radioButtonOwnTable, radioButtonSharedTable, radioButton30,radioButton1,radioButton1half,radioButton2;

    //Declare prices and discounts
    Double dblshareddiscount = 3.00;
    Double newprice;
    Double oldprice=5.00;

    //Setting the price into a Currency format
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    //This section is to create the date selector variables
    private static final String TAG = "HomeActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    private static final String TIME = "MainActivity";
    private TextView mDisplayTime;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literati);

        textViewLiterati = findViewById(R.id.textViewLiterati);
        textViewDate = findViewById(R.id.textViewReservationDate);
        textViewLiteratiStreet = findViewById(R.id.textViewLiteratiStreet);
        textViewLiteratiCity = findViewById(R.id.textViewLiteratiCity);

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
        spinnerLITtimeslots = findViewById(R.id.spinnerLITTimeSlots);
        ArrayAdapter<CharSequence> adapterLITtimeslots = ArrayAdapter.createFromResource(this,R.array.timeslots, android.R.layout.simple_spinner_item);
        adapterLITtimeslots.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLITtimeslots.setAdapter(adapterLITtimeslots);


        Intent literatiIntent =getIntent();
        if (literatiIntent != null) {
            reservationDate = literatiIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
        }


        //This section is to create the date selector
        final TextView mDisplayDate = findViewById(R.id.textViewReservationDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                int year = cal.get(java.util.Calendar.YEAR);
                int month = cal.get(java.util.Calendar.MONTH);
                int day = cal.get(java.util.Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(LiteratiActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        //This section is to have the date selected seen in textview
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "-" + day + "-" + year);
                String selecteddate = month + "-" + day + "-" + year;
                mDisplayDate.setText(selecteddate);
                reservationDate = selecteddate;
            }
        };
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

        } else if(item.getItemId() == R.id.Logout) {

            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Logout successful", Toast.LENGTH_LONG).show();
            Intent logoutIntent = new Intent(this, LogInActivity.class);
            startActivity(logoutIntent);

        } else if(item.getItemId() == R.id.Account) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);


        } else if(item.getItemId() == R.id.Home) {

            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }
    // Creating strings from info, including the basic info of the coffeeshop and sending it up to the add payment page
    @Override
    public void onClick(View view) {
        if (view == buttonAvailabilityBookNow){
            reservationCoffeeShop = textViewLiterati.getText().toString();
            reservationCoffeeShopStreet = textViewLiteratiStreet.getText().toString();
            reservationCoffeeShopCity = textViewLiteratiCity.getText().toString();
            reservationPrice = textViewCurrentPrice.getText().toString();
            reservationSpinnerTime = spinnerLITtimeslots.getSelectedItem().toString();
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

}
