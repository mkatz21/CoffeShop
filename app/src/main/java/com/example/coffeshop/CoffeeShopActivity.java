package com.example.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CoffeeShopActivity extends AppCompatActivity {
    Spinner spinnerReservationDuration, spinnerReservationTableType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shop);

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
    }
}
