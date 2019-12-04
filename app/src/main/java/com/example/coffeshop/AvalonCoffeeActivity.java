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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AvalonCoffeeActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinnerReservationDuration, spinnerReservationTableType;
    Button buttonCheckout;
    String reservationCoffeeShop, reservationDate, reservationTime;
    TextView textViewLab, textViewDate, textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalon_coffee);

        buttonCheckout = findViewById(R.id.buttonAvailabilityCheckout);
        buttonCheckout.setOnClickListener(this);

        textViewLab = findViewById(R.id.textViewLab);
        textViewDate = findViewById(R.id.textViewReservationDate);
        textViewTime = findViewById(R.id.textViewReservationTime);

        spinnerReservationDuration=findViewById(R.id.spinnerReservationDuration);
        spinnerReservationTableType = findViewById(R.id.spinnerAvailabilityTableType);

        Intent avalonIntent =getIntent();
        if (avalonIntent != null){
            reservationDate = avalonIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
            reservationTime = avalonIntent.getStringExtra("time");
            textViewTime.setText(reservationTime);

        }


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
            reservationCoffeeShop = textViewLab.getText().toString();

        }
    }
}
