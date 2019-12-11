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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPaymentMethodActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String email = user.getEmail();

    // Part A, Identify all of the components (edit texts, buttons, view texts)
    Button buttonBook;
    EditText editTextFirstName, editTextLastName, editTextEnterCardNumber, editTextExpDate, editTextCVV, editTextZipCode;
    TextView textViewthirdspace, textViewReservationSummary, textViewCoffeeShopName, textViewDuration, textViewDate, textViewTime, textViewPaymentSummary, textViewTotal, textViewTotalAmount, textViewReservationDetails, textViewCCInfo, textViewTableType;

    String reservationCoffeeShop, reservationDate, bookedTime, reservationPrice, reservationDuration, reservationTable, reservationCoffeeShopStreet, reservationCoffeeShopCity;

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
        textViewTableType = findViewById(R.id.textViewTableType);

        buttonBook.setOnClickListener(this);

        Intent reservationIntent = getIntent();
        if (reservationIntent != null) {
            reservationDate = reservationIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
            bookedTime = reservationIntent.getStringExtra("time");
            textViewTime.setText(bookedTime);
            reservationCoffeeShop = reservationIntent.getStringExtra("Coffee Shop");
            textViewCoffeeShopName.setText(reservationCoffeeShop);
            reservationPrice = reservationIntent.getStringExtra("Price");
            textViewTotalAmount.setText(reservationPrice);
            reservationDuration = reservationIntent.getStringExtra("Duration");
            textViewDuration.setText(reservationDuration);
            reservationTable = reservationIntent.getStringExtra("Table Type");
            textViewTableType.setText(reservationTable);
            reservationCoffeeShopStreet = reservationIntent.getStringExtra("Street");
            reservationCoffeeShopCity = reservationIntent.getStringExtra("City");

        }

    }

    @Override
    public void onClick(View view) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("UserReservation");

        if (view == buttonBook) {

            String userreservationcoffeeshop = textViewCoffeeShopName.getText().toString();
            String UserReservationDate = textViewDate.getText().toString();
            String Firstname = editTextFirstName.getText().toString();
            String Lastname = editTextLastName.getText().toString();
            String CreditCardName = editTextEnterCardNumber.getText().toString();
            String PostalCode = editTextZipCode.getText().toString();
            String ExpirationDate = editTextExpDate.getText().toString();
            String CCVNumber = editTextCVV.getText().toString();
            String ReservationDuration = textViewDuration.getText().toString();
            String ReservationTime = textViewTime.getText().toString();
            String TableType = textViewTableType.getText().toString();
            String PricePaid = textViewTotalAmount.getText().toString();
            String userreservationbookingID = myRef.push().getKey();


            Intent checkInIntent = new Intent(this, CheckInActivity.class);
            checkInIntent.putExtra("date", reservationDate);
            checkInIntent.putExtra("time", bookedTime);
            checkInIntent.putExtra("Coffee Shop", reservationCoffeeShop);
            checkInIntent.putExtra("Duration", reservationDuration);
            checkInIntent.putExtra("Table Type", reservationTable);
            checkInIntent.putExtra("Price", reservationPrice);
            checkInIntent.putExtra("Street", reservationCoffeeShopStreet);
            checkInIntent.putExtra("City", reservationCoffeeShopCity);
            startActivity(checkInIntent);

            UserReservation createUserReservation = new UserReservation(userreservationcoffeeshop, UserReservationDate, Firstname, Lastname, CreditCardName, PostalCode, ExpirationDate, CCVNumber, ReservationDuration, ReservationTime, TableType, PricePaid, userreservationbookingID);
            myRef.push().setValue(createUserReservation);
            myRef.child("Reservation").setValue(userreservationbookingID).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(AddPaymentMethodActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(AddPaymentMethodActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }
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

        } else if (item.getItemId() == R.id.AddPayment) {

            Toast.makeText(this, "You are already on the Add Payment Method Page", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.Account) {

            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);

        } else if (item.getItemId() == R.id.CheckIn) {

            Intent checkInIntent = new Intent(this, CheckInActivity.class);
            startActivity(checkInIntent);
        } else if (item.getItemId() == R.id.Home) {

            Intent HomeIntent = new Intent(this, HomeActivity.class);
            startActivity(HomeIntent);
        } else if (item.getItemId() == R.id.CoffeeShop) {

            Intent coffeeShopIntent = new Intent(this, CoffeeShopActivity.class);
            startActivity(coffeeShopIntent);
        } else if (item.getItemId() == R.id.SignUp) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
