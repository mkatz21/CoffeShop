package com.example.coffeshop;

import java.util.Date;

public class Reviews {

    public Integer ReviewsStars;
    public String ReviewsDescription;
    public Date ReviewsDate;

    public Reviews() {
    }

    public Reviews(Integer reviewsStars, String reviewsDescription, Date reviewsDate) {
        ReviewsStars = reviewsStars;
        ReviewsDescription = reviewsDescription;
        ReviewsDate = reviewsDate;
    }
}
