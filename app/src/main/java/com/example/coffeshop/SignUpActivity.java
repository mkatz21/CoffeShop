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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import android.widget.Registration;


//Sign up class for users from when we weren't pushing initial login
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText FirstName, LastName, Email, PhoneNumber, Password;
    TextView textviewpolicy;
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
        textviewpolicy = findViewById(R.id.textviewpolicy);


        Create = findViewById(R.id.Create);

        Create.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {

        final String firstName_string = FirstName.getText().toString();
        final String lastName_string = LastName.getText().toString();
        final String email_string = Email.getText().toString();
        final String phoneNumber_string = PhoneNumber.getText().toString();
        final String password_string = Password.getText().toString();


        if (v==Create) {

            Toast.makeText(this, email_string + password_string, Toast.LENGTH_SHORT).show();

                mAuth.createUserWithEmailAndPassword(email_string, password_string)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(SignUpActivity.this, "User Registration is Successful", Toast.LENGTH_SHORT).show();


                                    // Write a message to the database
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                                    final DatabaseReference myRef = database.getReference("Users");

                                      UserInfo myUser = new UserInfo();
                                      myUser.userInfoFirstName = firstName_string;
                                      myUser.userInfoLastName = lastName_string;
                                      myUser.userInfoEmail = email_string;
                                      myUser.userInfoPhoneNumber = phoneNumber_string;


                                      myRef.push().setValue(myUser);



                                } else {

                                    Toast.makeText(SignUpActivity.this, "Failed to Register", Toast.LENGTH_SHORT).show();

                                }

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
        if(item.getItemId() == R.id.YourReservations) {

            Intent mainPaymentIntent = new Intent(this, MainPaymentActivity.class);
            startActivity(mainPaymentIntent);

        } else if(item.getItemId() == R.id.Account) {

            Toast.makeText(this, "You are already on the Account Page", Toast.LENGTH_SHORT).show();


        } else if(item.getItemId() == R.id.Home) {

            Intent HomeIntent = new Intent(this, HomeActivity.class);
            startActivity(HomeIntent);
        } else if(item.getItemId() == R.id.Logout) {

            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Logout successful", Toast.LENGTH_LONG).show();
            Intent logoutIntent = new Intent(this, LogInActivity.class);
            startActivity(logoutIntent);

        }

        return super.onOptionsItemSelected(item);
    }


}
