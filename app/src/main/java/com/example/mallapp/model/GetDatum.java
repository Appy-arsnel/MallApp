package com.example.mallapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GetDatum {
    private Integer id;
    private Long createdAt;
    private String name;
    private String imageurl;
    private String description;
    private String rating;

    public GetDatum()
    {

    }

    public GetDatum(Integer id, Long createdAt, String name, String imageurl, String description, String rating) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.imageurl = imageurl;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}