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
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    //This section is to create the date selector variables
    private static final String TAG = "HomeActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    public String timeSend;

    private static final String TIME = "MainActivity";
    private TextView mDisplayTime;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;
    public String dateSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_layout);
/* Commenting this out for now, to remove in general code cleanup
        //This section is to create a duration dropdown menu
        Spinner durationdropdown = findViewById(R.id.spinnerduration);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.duration,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        durationdropdown.setAdapter(adapter);
*/

        //This section is to create the date selector
        final TextView mDisplayDate = findViewById(R.id.textViewDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                int year = cal.get(java.util.Calendar.YEAR);
                int month = cal.get(java.util.Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(HomeActivity.this,
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
                dateSend = selecteddate;
            }
        };

        /*
        We previously allowed the user to pick time from the homepage, but instead moved to an array-based time to allow for future appointment slot checking and manipulation
        Code is left here for potential future use if we can get it more granularly manipulable

        final TextView mDisplayTime = findViewById(R.id.textViewTime);
        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR);
                int minute = cal.get(Calendar.MINUTE);
                boolean isPM = (hour>=12);

                TimePickerDialog dialogtime = new TimePickerDialog(
                        HomeActivity.this,
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
                timeSend = selectedtime;



            }
        };


         */
    }

    //This is Avalon's clicklable image coding to redirect to its specific page
    public void showavalon (View view) {
        Intent avalonIntent = new Intent(this, AvalonCoffeeActivity.class);
        avalonIntent.putExtra("date", dateSend);
        avalonIntent.putExtra("time", timeSend);
        startActivity(avalonIntent);
    }

    //This is Black Diesel's clicklable image coding to redirect to its specific page
    public void showblackdiesel(View view) {
        Intent blackdieselIntent = new Intent(this, BlackDieselActivity.class);
        blackdieselIntent.putExtra("date", dateSend);
        blackdieselIntent.putExtra("time", timeSend);
        startActivity(blackdieselIntent);
    }

    //This is Bloommeadworks's clicklable image coding to redirect to its specific page
    public void showbloommeadworks(View view) {
        Intent blomIntent = new Intent(this, BlomMeadworksActivity.class);
        blomIntent.putExtra("date", dateSend);
        blomIntent.putExtra("time", timeSend);
        startActivity(blomIntent);
    }

    //This is Labs's clicklable image coding to redirect to its specific page
    public void showlab(View view) {
        Intent labIntent = new Intent(this, CoffeeShopActivity.class);
        labIntent.putExtra("date", dateSend);
        labIntent.putExtra("time", timeSend);
        startActivity(labIntent);
    }

    //This is Comet's clicklable image coding to redirect to its specific page
    public void showcomet(View view) {
        Intent cometIntent = new Intent(this, CometCoffeeActivity.class);
        cometIntent.putExtra("date", dateSend);
        cometIntent.putExtra("time", timeSend);
        startActivity(cometIntent);
    }

    //This is Vertex's clicklable image coding to redirect to its specific page
    public void showvertex(View view) {
        Intent vertexIntent = new Intent(this, VertexActivity.class);
        vertexIntent.putExtra("date", dateSend);
        vertexIntent.putExtra("time", timeSend);
        startActivity(vertexIntent);
    }

    //This is Literati's clicklable image coding to redirect to its specific page
    public void showliterati(View view) {
        Intent literatiIntent = new Intent(this, LiteratiActivity.class);
        literatiIntent.putExtra("date", dateSend);
        literatiIntent.putExtra("time", timeSend);
        startActivity(literatiIntent);
    }

    //This is Espresso's clicklable image coding to redirect to its specific page
    public void showespresso(View view) {
        Intent espressoIntent = new Intent(this, EspressoRoyaleActivity.class);
        espressoIntent.putExtra("date", dateSend);
        espressoIntent.putExtra("time", timeSend);
        startActivity(espressoIntent);
    }

    //This is RoosRoasts's clicklable image coding to redirect to its specific page
    public void showroosroast(View view) {
        Intent roosroastIntent = new Intent(this, RoosRoastActivity.class);
        roosroastIntent.putExtra("date", dateSend);
        roosroastIntent.putExtra("time", timeSend);
        startActivity(roosroastIntent);
    }

    @Override
        public boolean onCreateOptionsMenu (Menu menu){

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.mainmenu, menu);


            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            if (item.getItemId() == R.id.YourReservations) {

                Intent mainPaymentIntent = new Intent(this, MainPaymentActivity.class);
                startActivity(mainPaymentIntent);

            } else if (item.getItemId() == R.id.Home) {

                Toast.makeText(this, "You are already on the Home Page", Toast.LENGTH_SHORT).show();

            } else if (item.getItemId() == R.id.Account) {

                Intent signupIntent = new Intent(this, SignUpActivity.class);
                startActivity(signupIntent);

            } else if (item.getItemId() == R.id.Logout) {

                FirebaseAuth.getInstance().signOut();
                Toast.makeText(this, "Logout successful", Toast.LENGTH_LONG).show();
                Intent logoutIntent = new Intent(this, LogInActivity.class);
                startActivity(logoutIntent);

            }

            return super.onOptionsItemSelected(item);
        }

    @Override
    public void onClick(View view) {

    }
}


