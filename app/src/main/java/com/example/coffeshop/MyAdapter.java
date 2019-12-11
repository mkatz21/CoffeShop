package com.example.coffeshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<UserReservation> myreservations;

    public MyAdapter (Context r, ArrayList<UserReservation> b){

        context = r;
        myreservations = b;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bookingid.setText(myreservations.get(position).getUserreservationbookingID());
        holder.coffeeshopreserved.setText(myreservations.get(position).getUserreservationcoffeeshop());
    }

    @Override
    public int getItemCount() {
        return myreservations.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder

    {
        TextView bookingid, coffeeshopreserved;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookingid = itemView.findViewById(R.id.bookingid);
            coffeeshopreserved = itemView.findViewById(R.id.coffeeshopreserved);
        }
    }
}
