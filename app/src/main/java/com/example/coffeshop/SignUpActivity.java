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

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;

//test
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText FirstName, LastName, Email, PhoneNumber, Password, ConfirmPassword;
    Button Create;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        Email = findViewById(R.id.Email);
        PhoneNumber = findViewById(R.id.PhoneNumber);
        Password = findViewById(R.id.Password);
        ConfirmPassword = findViewById(R.id.ConfirmPassword);

        Create = findViewById(R.id.Create);

        Create.setOnClickListener(this);


        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {

        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if (v==Create) {

            makeNewUsers(Email.getText().toString(), Password.getText().toString());

        } else if (v==Create) {

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                              Intent loginIntent =  new Intent(SignUpActivity.this, HomeActivity.class);
                              startActivity(loginIntent);


                            }


                        }
                    });



        }
    }

   public void makeNewUsers (String Email, String Password) {
       mAuth.createUserWithEmailAndPassword(Email, Password)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {

                           Toast.makeText(SignUpActivity.this, "User Registration is Successful", Toast.LENGTH_SHORT).show();

                       } else {

                           Toast.makeText(SignUpActivity.this, "Failed to Register", Toast.LENGTH_SHORT).show();

                       }

                   }
               });}






// this was added from other screens?//

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

        } else if(item.getItemId() == R.id.CheckIn) {

            Toast.makeText(this, "You are already on the Check In Page", Toast.LENGTH_SHORT).show();

        } else if(item.getItemId() == R.id.Account) {

            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);

        } else if(item.getItemId() == R.id.AddPayment) {

            Intent addPaymentIntent = new Intent(this, AddPaymentMethodActivity.class);
            startActivity(addPaymentIntent);
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


}
