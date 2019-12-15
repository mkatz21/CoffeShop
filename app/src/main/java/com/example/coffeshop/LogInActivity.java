package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    //Creating button and edittext objects
    EditText editTextUserName, editTextPassword;
    Button buttonLogIn, buttonCreateAccount;

    //Creating Firebase authentication object
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //Declaring button and edittext objects
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount);

        //Setting buttons to onclicklistner
        buttonLogIn.setOnClickListener(this);
        buttonCreateAccount.setOnClickListener(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {

            Toast.makeText(LogInActivity.this, "Nobody is logged in", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(LogInActivity.this, "Somebody is already logged in", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {

        String email = editTextUserName.getText().toString();
        String password = editTextPassword.getText().toString();

        //button functionality 
        if (view == buttonLogIn) {

            if (editTextUserName.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()) {

                Toast.makeText(LogInActivity.this, "Login Fail. Please enter valid email and/or valid 6 character password", Toast.LENGTH_SHORT).show();

            } else {

                LoginUsers(editTextUserName.getText().toString(), editTextPassword.getText().toString());
            }

        }else if (view == buttonCreateAccount) {
                if (editTextUserName.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()) {

                    Toast.makeText(LogInActivity.this, "Registration Fail. Please enter valid email and/or valid 6 character password", Toast.LENGTH_SHORT).show();

                } else {

                    makeNewUsers(editTextUserName.getText().toString(), editTextPassword.getText().toString());

                }

            }
        }

        private void LoginUsers (String email, String password){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                // Sign in success, update UI with the signed-in user's information
                                successfulSignIn();

                            } else {

                                // If sign in fails, display a message to the user.
                                Toast.makeText(LogInActivity.this, "Login Fail. Please enter valid email and 6 character password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

        private void makeNewUsers (String email, String password){

            //Code to register people
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                // Sign in success, update UI with the signed-in user's information (also refers to checking to see if valid for Firebase Authentication)
                                makeNewUsers(editTextUserName.getText().toString(), editTextPassword.getText().toString());

                            } else {

                                // If sign in fails, display a message to the user.
                                Toast.makeText(LogInActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

        //This code is here for when the log in is successful, it will not only Toast you were successful but take you to Highest Important Activity.
        private void successfulSignIn () {

            Intent loginIntent = new Intent(this, HomeActivity.class);
            startActivity(loginIntent);
            Toast.makeText(this, "Log In Successful", Toast.LENGTH_SHORT).show();

        }
    }