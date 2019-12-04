package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class EspressoRoyaleActivity extends AppCompatActivity {

    Spinner spinnerReservationDuration, spinnerReservationTableType;
    TextView textViewCurrentPrice;

    //Declare prices
    Double dblthirtyprice = 5.00;
    Double dblhourprice = 10.00;
    Double dblhourandhalfprice = 15.00;
    Double dbltwohourprice = 20.00;
    Double dblshareddiscount = 3.00;

    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_royale);

        textViewCurrentPrice = findViewById(R.id.textViewCurrentPrice);

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
}
