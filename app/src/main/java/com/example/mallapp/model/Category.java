
package com.example.mallapp.model;


public class Category {


    String name;
    String imgurl;
    String rating;
    String desctription;

    public Category() {

    }

    public Category(String name, String imgurl, String rating, String desctription) {
        this.name = name;
        this.imgurl = imgurl;
        this.rating = rating;
        this.desctription = desctription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDesctription() {
        return desctription;
    }

    public void setDesctription(String desctription) {
        this.desctription = desctription;
    }
}
