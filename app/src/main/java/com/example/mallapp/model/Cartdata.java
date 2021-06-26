package com.example.mallapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cartdata {
    private Integer id;

    private Long createdAt;

    private String name;

    private String imageurl;

    private String rating;
    public Cartdata() {
    }

    public Cartdata(Integer id, Long createdAt, String name, String imageurl, String rating) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.imageurl = imageurl;
        this.rating = rating;
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

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

