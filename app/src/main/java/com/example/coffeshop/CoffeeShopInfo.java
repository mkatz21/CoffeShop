package com.example.coffeshop;

import android.media.Image;

//This is to create the CoffeeShop DB object for firebase. We then went in and manually created each individual coffee shop directly in the console
public class CoffeeShopInfo {

    public Integer CoffeeShopInfoOpenHour;
    public Integer CoffeeShopInfoCloseHour;
    public String CoffeeShopInfoStreetName;
    public Integer CoffeeShopInfoStreetNumber;
    public Integer CoffeeShopInfoZipCode;
    public Image CoffeeShopInfoImage;
    public String CoffeeShopInfoDescription;
    public String CoffeeShopInfoPhoneNumber;
    public Boolean CoffeeShopInfoWifi;
    public Boolean CoffeeShopInfoIsPopular;
    public Boolean CoffeeShopInfoIsTrending;
    public Boolean CoffeeShopInfoIsNew;
    public String CoffeeShopInfoMenuLink;

    public CoffeeShopInfo() {
    }

    public CoffeeShopInfo(Integer coffeeShopInfoOpenHour, Integer coffeeShopInfoCloseHour, String coffeeShopInfoStreetName, Integer coffeeShopInfoStreetNumber, Integer coffeeShopInfoZipCode, Image coffeeShopInfoImage, String coffeeShopInfoDescription, String coffeeShopInfoPhoneNumber, Boolean coffeeShopInfoWifi, Boolean coffeeShopInfoIsPopular, Boolean coffeeShopInfoIsTrending, Boolean coffeeShopInfoIsNew, String coffeeShopInfoMenuLink) {
        CoffeeShopInfoOpenHour = coffeeShopInfoOpenHour;
        CoffeeShopInfoCloseHour = coffeeShopInfoCloseHour;
        CoffeeShopInfoStreetName = coffeeShopInfoStreetName;
        CoffeeShopInfoStreetNumber = coffeeShopInfoStreetNumber;
        CoffeeShopInfoZipCode = coffeeShopInfoZipCode;
        CoffeeShopInfoImage = coffeeShopInfoImage;
        CoffeeShopInfoDescription = coffeeShopInfoDescription;
        CoffeeShopInfoPhoneNumber = coffeeShopInfoPhoneNumber;
        CoffeeShopInfoWifi = coffeeShopInfoWifi;
        CoffeeShopInfoIsPopular = coffeeShopInfoIsPopular;
        CoffeeShopInfoIsTrending = coffeeShopInfoIsTrending;
        CoffeeShopInfoIsNew = coffeeShopInfoIsNew;
        CoffeeShopInfoMenuLink = coffeeShopInfoMenuLink;
    }
}
