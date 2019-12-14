package com.example.coffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class MainPaymentActivity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<UserReservation> reservationslist;
    MyAdapter reservationadapater;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String email = user.getEmail();

    //Adding in a comment so I can re-pull down and overwrite my mistakes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_payment);

        recyclerView = findViewById(R.id.myRecycler);;
        reservationslist = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference().child("UserReservation");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                   // Toast.makeText(MainPaymentActivity.this, dataSnapshot1.getKey(), Toast.LENGTH_SHORT).show();
                    UserReservation r = dataSnapshot1.getValue(UserReservation.class);
                    Toast.makeText(MainPaymentActivity.this, r.email, Toast.LENGTH_SHORT).show();
                    reservationslist.add(r);

                    /* This code also limits the arraylist to just the reservation created in the moment
                    Doesn't do what we need it to do but gets close?
                    if (r.email == email) {
                        reservationslist.add(r);
                    }
                    else if (r.email != email){
                        continue;
                    }

                     */

                }
                /* ** This code will refine the arraylist to just the reservation created in the moment
                doesn't do what we need it to do but some variant of this hopefully will filter the arraylist just down to current user
                Iterator<UserReservation> iterator = reservationslist.iterator();
                while (iterator.hasNext()) {
                    UserReservation a = iterator.next();
                    if (a.email != email) iterator.remove();
                }
*/
                reservationadapater = new MyAdapter(MainPaymentActivity.this,reservationslist);
                recyclerView.setAdapter(reservationadapater);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainPaymentActivity.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(MainPaymentActivity.this,"Something Went Wrong!",Toast.LENGTH_SHORT).show();

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
        if(item.getItemId() == R.id.Home) {

            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);

        } else if(item.getItemId() == R.id.YourReservations) {

            Toast.makeText(this, "You are already on the Home Page", Toast.LENGTH_SHORT).show();

        } else if(item.getItemId() == R.id.Account) {

            Intent signupIntent = new Intent(this, SignUpActivity.class);
            startActivity(signupIntent);

        } else if(item.getItemId() == R.id.AddPayment) {

            Intent addPaymentIntent = new Intent(this, AddPaymentMethodActivity.class);
            startActivity(addPaymentIntent);
        } else if(item.getItemId() == R.id.CheckIn) {

            Intent checkInIntent = new Intent(this, CheckInActivity.class);
            startActivity(checkInIntent);
        } else if(item.getItemId() == R.id.Logout) {

            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Logout successful", Toast.LENGTH_LONG).show();
            Intent logoutIntent = new Intent(this, LogInActivity.class);
            startActivity(logoutIntent);

        }

        return super.onOptionsItemSelected(item);
    }
}
