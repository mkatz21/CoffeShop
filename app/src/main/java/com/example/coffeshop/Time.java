package com.example.coffeshop;

import androidx.annotation.NonNull;
//Time class used for timepicker
public class Time {

    int hour;
    int minute;
    boolean am;

    public Time(int hour, int minute, boolean am){
        this.hour = hour;
        this.minute = minute;
        this.am = am;
    }
    public Time(){

    }

    @NonNull
    @Override
    public String toString() {
        return hour+":"+minute;
    }
}
