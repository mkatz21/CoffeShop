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
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Calendar;

public class AvalonCoffeeActivity extends AppCompatActivity implements View.OnClickListener,
        RadioButton.OnCheckedChangeListener {

    String reservationCoffeeShop, reservationDate, reservationTime, reservationDuration, reservationTable, reservationPrice;
    TextView textViewAvalon, textViewDate, textViewTime;
    Spinner spinnerAVtimeslots;
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
        setContentView(R.layout.activity_avalon_coffee);

        textViewAvalon = findViewById(R.id.textViewAvalon);
        textViewDate = findViewById(R.id.textViewReservationDate);
        textViewTime = findViewById(R.id.textViewReservationTime);

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
        spinnerAVtimeslots = findViewById(R.id.spinnerAVtimeslots);
        ArrayAdapter<CharSequence> adapterAVtimeslots = ArrayAdapter.createFromResource(this,R.array.timeslots, android.R.layout.simple_spinner_item);
        adapterAVtimeslots.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAVtimeslots.setAdapter(adapterAVtimeslots);


        Intent avalonIntent =getIntent();
        if (avalonIntent != null){
            reservationDate = avalonIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
            reservationTime = avalonIntent.getStringExtra("time");
            textViewTime.setText(reservationTime);

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

                DatePickerDialog dialog = new DatePickerDialog(AvalonCoffeeActivity.this,
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
        final TextView mDisplayTime = findViewById(R.id.textViewReservationTime);
        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                int hour = cal.get(java.util.Calendar.HOUR);
                int minute = cal.get(Calendar.MINUTE);
                boolean isPM = (hour>=12);

                TimePickerDialog dialogtime = new TimePickerDialog(
                        AvalonCoffeeActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        (TimePickerDialog.OnTimeSetListener) mTimeSetListener,
                        hour,minute,isPM);
                dialogtime.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogtime.show();
            }
        });

        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                String timeSet = "";
                if (hour > 12) {
                    hour -= 12;
                    timeSet = "PM";
                } else if (hour == 0) {
                    hour += 12;
                    timeSet = "AM";
                } else if (hour == 12){
                    timeSet = "PM";
                }else{
                    timeSet = "AM";
                }

                String min = "";
                if (minute < 10)
                    min = "0" + minute ;
                else
                    min = String.valueOf(minute);

                String selectedtime = hour +":"+ minute+" "+timeSet.toString();
                mDisplayTime.setText(selectedtime);
                reservationTime = selectedtime;



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
        if(item.getItemId() == R.id.MainPayment) {

            Intent mainPaymentIntent = new Intent(this, MainPaymentActivity.class);
            startActivity(mainPaymentIntent);

        } else if(item.getItemId() == R.id.CoffeeShop) {

            Toast.makeText(this, "You are already on the Coffee Shop Page", Toast.LENGTH_SHORT).show();

        } else if(item.getItemId() == R.id.Account) {

            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);

        } else if(item.getItemId() == R.id.AddPayment) {

            Intent addPaymentIntent = new Intent(this, AddPaymentMethodActivity.class);
            startActivity(addPaymentIntent);
        } else if(item.getItemId() == R.id.CheckIn) {

            Intent checkInIntent = new Intent(this, CheckInActivity.class);
            startActivity(checkInIntent);
        } else if(item.getItemId() == R.id.Home) {

            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
        } else if(item.getItemId() == R.id.SignUp) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonAvailabilityBookNow){
            reservationCoffeeShop = textViewAvalon.getText().toString();
            reservationPrice = textViewCurrentPrice.getText().toString();
            Intent reservationIntent = new Intent(this, AddPaymentMethodActivity.class);
            reservationIntent.putExtra("date", reservationDate);
            reservationIntent.putExtra("time", reservationTime);
            reservationIntent.putExtra("Coffee Shop", reservationCoffeeShop);
            reservationIntent.putExtra("Duration", reservationDuration);
            reservationIntent.putExtra("Table Type", reservationTable);
            reservationIntent.putExtra("Price", reservationPrice);
            startActivity(reservationIntent);

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

}
