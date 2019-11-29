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
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
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


    // Part A, Identify all of the edit texts and buttons
    Button buttonSave;
    EditText editTextEnterCardNumber,editTextExpDate, editTextCVV, editTextZipCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment_method);


        //Part B find buttons

        buttonSave = findViewById(R.id.buttonSave);

        editTextEnterCardNumber = findViewById(R.id.editTextEnterCardNumber);
        editTextExpDate = findViewById(R.id.editTextExpDate);
        editTextCVV = findViewById(R.id.editTextCVV);
        editTextZipCode = findViewById(R.id.editTextZipCode);

        buttonSave.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference myRef = database.getReference("Payment");

        //if (view == buttonSave) {

            //String CreditCardNumber = editTextEnterCardNumber.getText().toString();
            //String ExpDate = editTextExpDate.getText().toString();
            //String CVV = editTextCVV.getText().toString();
            //String Zipcode = editTextZipCode.getText().toString();

            //Payment createPayment = new Payment(CreditCardNumber, ExpDate, CVV, Zipcode);
            //myRef.push().setValue(createPayment);

    }
}
