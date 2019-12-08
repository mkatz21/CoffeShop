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

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUserName, editTextPassword;
    Button buttonLogIn, buttonCreateAccount,buttonContinueAsGuest;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount);
        buttonContinueAsGuest = findViewById(R.id.buttonContinueAsGuest);

        buttonLogIn.setOnClickListener(this);
        buttonCreateAccount.setOnClickListener(this);
        buttonContinueAsGuest.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {

        if (view == buttonLogIn){
            loginUser(editTextUserName.getText().toString(), editTextPassword.getText().toString());
        } else if( view == buttonCreateAccount){
            Intent createaccountIntent = new Intent(this, SignUpActivity.class);
            startActivity(createaccountIntent);
        } else if (view == buttonContinueAsGuest) {
            Intent asguestIntent = new Intent(this, HomeActivity.class);
            startActivity(asguestIntent);
        }
        }



    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information; take them to the Importance Search activity
                            Intent loginIntent = new Intent(LogInActivity.this, HomeActivity.class);
                            startActivity(loginIntent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LogInActivity.this, "LogIn Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
}}
