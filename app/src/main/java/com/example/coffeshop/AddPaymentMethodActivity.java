package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPaymentMethodActivity extends AppCompatActivity implements View.OnClickListener {


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

        } else if(item.getItemId() == R.id.AddPayment) {

            Toast.makeText(this, "You are already on the Add Payment Method Page", Toast.LENGTH_SHORT).show();

        } else if(item.getItemId() == R.id.Account) {

            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);

        } else if(item.getItemId() == R.id.CheckIn) {

            Intent checkInIntent = new Intent(this, CheckInActivity.class);
            startActivity(checkInIntent);
        } else if(item.getItemId() == R.id.Home) {

            Intent HomeIntent = new Intent(this, HomeActivity.class);
            startActivity(HomeIntent);
        } else if(item.getItemId() == R.id.CoffeeShop) {

            Intent coffeeShopIntent = new Intent(this, CoffeeShopActivity.class);
            startActivity(coffeeShopIntent);
        } else if(item.getItemId() == R.id.SignUp) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);
        }
        return super.onOptionsItemSelected(item);
    }


    // Part A, Identify all of the components (edit texts, buttons, view texts)
    Button buttonBook;
    EditText editTextFirstName, editTextLastName, editTextEnterCardNumber,editTextExpDate, editTextCVV, editTextZipCode;
    TextView textViewthirdspace, textViewReservationSummary, textViewCoffeeShopName, textViewDuration, textViewDate, textViewTime, textViewPaymentSummary, textViewTotal, textViewTotalAmount, textViewReservationDetails, textViewCCInfo;

    String reservationCoffeeShop, reservationDate, reservationTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment_method);




        buttonBook = findViewById(R.id.buttonBook);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEnterCardNumber = findViewById(R.id.editTextEnterCardNumber);
        editTextExpDate = findViewById(R.id.editTextExpDate);
        editTextCVV = findViewById(R.id.editTextCVV);
        editTextZipCode = findViewById(R.id.editTextZipCode);

        textViewthirdspace = findViewById(R.id.textViewthirdspace);
        textViewReservationSummary = findViewById(R.id.textViewReservationSummary);
        textViewCoffeeShopName = findViewById(R.id.textViewCoffeeShopName);
        textViewDuration = findViewById(R.id.textViewDuration);
        textViewDate = findViewById(R.id.textViewDate);
        textViewTime = findViewById(R.id.textViewTime);
        textViewPaymentSummary = findViewById(R.id.textViewPaymentSummary);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewTotalAmount = findViewById(R.id.textViewTotalAmount);
        textViewReservationDetails = findViewById(R.id.textViewReservationDetails);
        textViewCCInfo = findViewById(R.id.textViewCCInfo);

        buttonBook.setOnClickListener(this);

        Intent reservationIntent =getIntent();
        if (reservationIntent != null){
            reservationDate = reservationIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
            reservationTime = reservationIntent.getStringExtra("time");
            textViewTime.setText(reservationTime);
            reservationCoffeeShop = reservationIntent.getStringExtra("Coffee Shop");
            textViewCoffeeShopName.setText(reservationCoffeeShop);
    }

    }

    @Override
    public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("UserReservation");

        if (view == buttonBook) {

            String CreditCardName = editTextEnterCardNumber.getText().toString();
                   String ExpirationDate = editTextExpDate.getText().toString();
                 String CCVNumber = editTextCVV.getText().toString();
               String PostalCode = editTextZipCode.getText().toString();
             String Firstname = editTextFirstName.getText().toString();
           String Lastname = editTextLastName.getText().toString();

              UserReservation createUserReservation = new UserReservation(CreditCardName, ExpirationDate, CCVNumber, PostalCode, Firstname, Lastname);
              myRef.push().setValue(createUserReservation);
    }
}}
