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
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class BlomMeadworksActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinnerReservationDuration, spinnerReservationTableType;

    Button buttonCheckout;
    String reservationCoffeeShop, reservationDate, reservationTime;
    TextView textViewBlom, textViewDate, textViewTime;

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
        setContentView(R.layout.activity_blom_meadworks);


        buttonCheckout = findViewById(R.id.buttonCheckout);
        buttonCheckout.setOnClickListener(this);

        textViewBlom = findViewById(R.id.textViewBlom);
        textViewDate = findViewById(R.id.textViewReservationDate);
        textViewTime = findViewById(R.id.textViewReservationTime);


        Intent blomIntent =getIntent();
        if (blomIntent != null) {
            reservationDate = blomIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
            reservationTime = blomIntent.getStringExtra("time");
            textViewTime.setText(reservationTime);
        }


        spinnerReservationDuration=findViewById(R.id.spinnerAvailabilityDuration);
        spinnerReservationTableType = findViewById(R.id.spinnerAvailabilityTableType);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterDuration = ArrayAdapter.createFromResource(this,
                R.array.reservation_duration_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterDuration.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerReservationDuration.setAdapter(adapterDuration);

        ArrayAdapter<CharSequence> adapterTableType = ArrayAdapter.createFromResource(this,
                R.array.reservation_table_type_array, android.R.layout.simple_spinner_item);
        adapterTableType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerReservationTableType.setAdapter(adapterTableType);

        //This section is to create the date selector
        final TextView mDisplayDate = findViewById(R.id.textViewReservationDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                int year = cal.get(java.util.Calendar.YEAR);
                int month = cal.get(java.util.Calendar.MONTH);
                int day = cal.get(java.util.Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(BlomMeadworksActivity.this,
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
                        BlomMeadworksActivity.this,
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
        if (view == buttonCheckout){
            reservationCoffeeShop = textViewBlom.getText().toString();
            Intent reservationIntent = new Intent(this, AddPaymentMethodActivity.class);
            reservationIntent.putExtra("date", reservationDate);
            reservationIntent.putExtra("time", reservationTime);
            reservationIntent.putExtra("Coffee Shop", reservationCoffeeShop);
            startActivity(reservationIntent);

        }
    }
}
