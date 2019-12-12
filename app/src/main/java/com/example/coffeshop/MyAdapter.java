package com.example.coffeshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    //Adding in a comment so I can re-pull down and overwrite my mistakes
    Context context;
    ArrayList<UserReservation> myreservations;

    public MyAdapter (Context r, ArrayList<UserReservation> b){

        context = r;
        myreservations = b;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MyViewHolder viewholder =new MyViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bookingid.setText(myreservations.get(position).userreservationbookingID);
        holder.coffeeshopreserved.setText(myreservations.get(position).userreservationcoffeeshop);
    }

    @Override
    public int getItemCount() {
        return myreservations.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder

    {
        TextView bookingid, coffeeshopreserved;
        RelativeLayout parent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parentLayout);
            bookingid = itemView.findViewById(R.id.bookingid);
            coffeeshopreserved = itemView.findViewById(R.id.coffeeshopreserved);
        }
    }
}
