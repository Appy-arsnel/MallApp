package com.example.mallapp;

import android.net.Uri;

public class user {
    private String name ;
    private String email;
    private String mobileno;


    private String photourl;

    public user()
    {

    }
    public user(String name, String email, String mobileno) {
        this.name = name;
        this.email = email;
        this.mobileno = mobileno;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }


    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }





}
