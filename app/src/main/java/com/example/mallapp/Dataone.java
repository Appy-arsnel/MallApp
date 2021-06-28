package com.example.mallapp;

public class Dataone {


    private String imageurl;
    private String name;
    private Integer number;
    private String price;
    private String rating;



    public Dataone() {

    }

    public Dataone(String imageurl, String name, Integer number, String price, String rating) {
        this.imageurl = imageurl;
        this.name = name;
        this.number = number;
        this.price = price;
        this.rating = rating;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
