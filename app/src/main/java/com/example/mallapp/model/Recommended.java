package com.example.mallapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recommended {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private Long createdAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("imageurl")
    @Expose
    private String imageurl;
    @SerializedName("description")
    @Expose
    private String description;


    public Recommended() {
    }
    public Recommended(Integer id, Long createdAt, String name, String rating, String time, String price, String imageurl, String description) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.rating = rating;
        this.time = time;
        this.price = price;
        this.imageurl = imageurl;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}