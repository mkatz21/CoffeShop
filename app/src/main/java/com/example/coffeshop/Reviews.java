package com.example.coffeshop;

import java.util.Date;

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

