package com.example.coffeshop;

import android.media.Image;

public class UserInfo {

    public String userInfoName;
    public String userInfoPassword;
    public String userInfoFirstName;
    public String userInfoLastName;
    public String userInfoPhoneNumber;
    public String userInfoEmail;
    public String userInfoHomeZipcode;
    public String userInfoCurrentZipcode;
    public Image userInfoImage;

    public UserInfo() {
    }

    public UserInfo(String userInfoName, String userInfoPassword, String userInfoFirstName, String userInfoLastName, String userInfoPhoneNumber, String userInfoEmail, String userInfoHomeZipcode, String userInfoCurrentZipcode, Image userInfoImage) {
        this.userInfoName = userInfoName;
        this.userInfoPassword = userInfoPassword;
        this.userInfoFirstName = userInfoFirstName;
        this.userInfoLastName = userInfoLastName;
        this.userInfoPhoneNumber = userInfoPhoneNumber;
        this.userInfoEmail = userInfoEmail;
        this.userInfoHomeZipcode = userInfoHomeZipcode;
        this.userInfoCurrentZipcode = userInfoCurrentZipcode;
        this.userInfoImage = userInfoImage;
    }

    public UserInfo(String userInfoPassword, String userInfoFirstName, String userInfoLastName, String userInfoEmail, String userInfoPhoneNumber) {
        this.userInfoPassword = userInfoPassword;
        this.userInfoFirstName = userInfoFirstName;
        this.userInfoLastName = userInfoLastName;
        this.userInfoEmail = userInfoEmail;
        this.userInfoPhoneNumber = userInfoPhoneNumber;
    }
}






