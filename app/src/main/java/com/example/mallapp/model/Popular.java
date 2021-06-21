package com.example.mallapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Popular {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private Long createdAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("imageurl")
    @Expose
    private String imageurl;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * No args constructor for use in serialization
     */
    public Popular() {
    }


    public Popular(Integer id, Long createdAt, String name, String imageurl, String rating, String description) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.imageurl = imageurl;
        this.rating = rating;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

