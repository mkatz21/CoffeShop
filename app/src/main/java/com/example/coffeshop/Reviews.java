package com.example.coffeshop;

import java.util.Date;

//This is for future creation of a class of Reservation objects that will show on the coffee shop pages. De-scoped for this project
public class Reviews {

    public Integer ReviewsStars;
    public String ReviewsUserName;
    public String ReviewsDescription;
    public Date ReviewsDate;

    public Reviews() {
    }

    public Reviews(Integer reviewsStars, String reviewsUserName, String reviewsDescription, Date reviewsDate) {
        ReviewsStars = reviewsStars;
        ReviewsUserName = reviewsUserName;
        ReviewsDescription = reviewsDescription;
        ReviewsDate = reviewsDate;
    }
}

