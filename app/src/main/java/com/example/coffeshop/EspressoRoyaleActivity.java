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
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Calendar;

public class EspressoRoyaleActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinnerReservationDuration, spinnerReservationTableType;
    TextView textViewCurrentPrice, textViewEspressoRoyale, textViewDate, textViewTime;
    String reservationCoffeeShop, reservationDate, reservationTime;
    Button buttonAvailabilityTime1;

    //This section is to create the date selector variables
    private static final String TAG = "HomeActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    private static final String TIME = "MainActivity";
    private TextView mDisplayTime;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;


    //Declare prices
    Double dblthirtyprice = 5.00;
    Double dblhourprice = 10.00;
    Double dblhourandhalfprice = 15.00;
    Double dbltwohourprice = 20.00;
    Double dblshareddiscount = 3.00;
    double newprice;

    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_royale);

        textViewCurrentPrice = findViewById(R.id.textViewCurrentPrice);
        textViewDate = findViewById(R.id.textViewReservationDate);
        textViewTime = findViewById(R.id.textViewReservationTime);

        spinnerReservationDuration = findViewById(R.id.spinnerAvailabilityDuration);
        spinnerReservationTableType = findViewById(R.id.spinnerAvailabilityTableType);

        buttonAvailabilityTime1 = findViewById(R.id.buttonAvailabilityTime1);

        buttonAvailabilityTime1.setOnClickListener(this);

        Intent espressoIntent =getIntent();
        if (espressoIntent != null) {
            reservationDate = espressoIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
            reservationTime = espressoIntent.getStringExtra("time");
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

                DatePickerDialog dialog = new DatePickerDialog(EspressoRoyaleActivity.this,
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
                        EspressoRoyaleActivity.this,
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

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterDuration = ArrayAdapter.createFromResource(this,
                R.array.reservation_duration_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterDuration.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        ArrayAdapter<CharSequence> adapterTableType = ArrayAdapter.createFromResource(this,
                R.array.reservation_table_type_array, android.R.layout.simple_spinner_item);
        adapterTableType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //This code is to change the checkout price as reservation table type changes
        spinnerReservationTableType.setAdapter(adapterTableType);

        //This code is to change the checkout price as duration changes
        spinnerReservationDuration.setAdapter(adapterDuration);
        spinnerReservationDuration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectionCurrent = spinnerReservationDuration.getSelectedItemPosition();

                if (selectionCurrent == 0) {
                    textViewCurrentPrice.setText(formatter.format(dblthirtyprice));
                } else if (selectionCurrent == 1) {
                    textViewCurrentPrice.setText(formatter.format(dblhourprice));
                } else if (selectionCurrent == 2) {
                    textViewCurrentPrice.setText(formatter.format(dblhourandhalfprice));
                } else if (selectionCurrent == 3) {
                    textViewCurrentPrice.setText(formatter.format(dbltwohourprice));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textViewCurrentPrice.setText(formatter.format(dblthirtyprice));
            }
        });

        spinnerReservationTableType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectiontabletype = spinnerReservationTableType.getSelectedItemPosition();
                int selectionCurrent = spinnerReservationDuration.getSelectedItemPosition();
                if (selectiontabletype == 1 & selectionCurrent == 0) {

                    newprice = dblthirtyprice - dblshareddiscount;
                    textViewCurrentPrice.setText(formatter.format(newprice));

                } else if (selectiontabletype == 1 & selectionCurrent == 1) {

                    newprice = dblhourprice - dblshareddiscount;
                    textViewCurrentPrice.setText(formatter.format(newprice));

                } else if (selectiontabletype == 1 & selectionCurrent == 2) {

                    newprice = dblhourandhalfprice - dblshareddiscount;
                    textViewCurrentPrice.setText(formatter.format(newprice));
                } else if (selectiontabletype == 1 & selectionCurrent == 3) {

                    newprice = dbltwohourprice - dblshareddiscount;
                    textViewCurrentPrice.setText(formatter.format(newprice));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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
        if (view == buttonAvailabilityTime1) {
                buttonAvailabilityTime1.setBackgroundColor(Color.GREEN);
            reservationCoffeeShop = textViewEspressoRoyale.getText().toString();
            Intent reservationIntent = new Intent(this, AddPaymentMethodActivity.class);
            reservationIntent.putExtra("date", reservationDate);
            reservationIntent.putExtra("time", reservationTime);
            reservationIntent.putExtra("Coffee Shop", reservationCoffeeShop);
            startActivity(reservationIntent);
        }
    }

}