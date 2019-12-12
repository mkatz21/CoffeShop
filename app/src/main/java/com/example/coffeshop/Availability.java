package com.example.coffeshop;

import java.util.Date;

public class Availability {


    public Date AvailabilityDate;
    public Time AvailabilityTime;
    public Boolean AvailabilityStatus;
    public String AvailabilityUserName;
    public Integer AvailabilityBookingID;

    public Availability() {
    }

    public Availability(Date availabilityDate, Time availabilityTime, Boolean availabilityStatus, String availabilityUserName, Integer availabilityBookingID, Double availabilityPrice) {
        AvailabilityDate = availabilityDate;
        AvailabilityTime = availabilityTime;
        AvailabilityStatus = availabilityStatus;
        AvailabilityUserName = availabilityUserName;
        AvailabilityBookingID = availabilityBookingID;
    }
}

