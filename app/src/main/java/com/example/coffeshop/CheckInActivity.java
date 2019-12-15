package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class CheckInActivity extends AppCompatActivity implements View.OnClickListener {

    String reservationCoffeeShop, reservationCoffeeShopStreet, reservationCoffeeShopCity, reservationSpinnerTime, reservationDate;
    TextView textViewReservationCoffeeShop, textViewReservationCoffeeShopStreet, textViewReservationCoffeeShopCity, textViewDate, textViewTime;

    //QR Generation pieces
    ImageView qrImage;
    String inputValue, TAG = "GenerateQRCode";
    Bitmap bitmap;
    QRGEncoder qrgEncoder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);


        textViewDate = findViewById(R.id.textViewDate);
        textViewTime = findViewById(R.id.textViewTime);
        textViewReservationCoffeeShop = findViewById(R.id.textViewReservationCoffeeShop);
        textViewReservationCoffeeShopCity = findViewById(R.id.textViewReservationCoffeeShopCity);
        textViewReservationCoffeeShopStreet = findViewById(R.id.textViewReservationCoffeeShopStreet);

        //QR Generation
        qrImage = findViewById(R.id.defaultQRCode);

        //getting infromation sent over from addpayment intent and saving it in strings
        Intent checkInIntent =getIntent();
        if (checkInIntent != null){
            reservationCoffeeShop = checkInIntent.getStringExtra("Coffee Shop");
            textViewReservationCoffeeShop.setText(reservationCoffeeShop);
            reservationCoffeeShopStreet = checkInIntent.getStringExtra("Street");
            textViewReservationCoffeeShopStreet.setText(reservationCoffeeShopStreet);
            reservationCoffeeShopCity = checkInIntent.getStringExtra("City");
            textViewReservationCoffeeShopCity.setText(reservationCoffeeShopCity);
            reservationDate = checkInIntent.getStringExtra("date");
            textViewDate.setText(reservationDate);
            reservationSpinnerTime = checkInIntent.getStringExtra("time");
            textViewTime.setText(reservationSpinnerTime);
            inputValue = checkInIntent.getStringExtra("BookingID");

        }

        //Generate QR Code from BookingID using code from http://www.androidmads.info/2018/07/how-to-generate-qr-code-in-android.html
        if (inputValue.length()> 0){
            WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int width = point.x;
            int height = point.y;
            int smallerDimension = width < height ? width : height;
            smallerDimension = smallerDimension * 3 / 4;

            qrgEncoder = new QRGEncoder(
                    inputValue, null,
                    QRGContents.Type.TEXT,
                    smallerDimension);
            try {
                bitmap = qrgEncoder.encodeAsBitmap();
                qrImage.setImageBitmap(bitmap);
            } catch (WriterException e) {
                Log.v(TAG, e.toString());
            }
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

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);

        } else if(item.getItemId() == R.id.Home) {

            Intent HomeIntent = new Intent(this, HomeActivity.class);
            startActivity(HomeIntent);
        } else if(item.getItemId() == R.id.Logout) {

            Intent coffeeShopIntent = new Intent(this, CoffeeShopActivity.class);
            startActivity(coffeeShopIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
