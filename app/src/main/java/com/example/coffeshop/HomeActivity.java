package com.example.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    //Added a comment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout populargallery = findViewById(R.id.populargallery);

        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i<6 ; i++) {

            View view = inflater.inflate(R.layout.popularcoffeespots, populargallery, false);

            TextView textView = view.findViewById(R.id.popularcoffeeshop);
            textView.setText(("Popular Shop"+i));

            ImageView imageView = view.findViewById(R.id.imageButton);
            imageView.setImageResource((R.drawable.ic_launcher_background));

            populargallery.addView(view);

        }

    }
}
