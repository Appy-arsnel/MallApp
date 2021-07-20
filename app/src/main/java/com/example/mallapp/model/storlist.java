
package com.example.mallapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class storlist {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private Long createdAt;
    @SerializedName("Store_name")
    @Expose
    private String storeName;
    @SerializedName("imageurl")
    @Expose
    private String imageurl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("place")
    @Expose
    private String place;

    public storlist() {
    }

    public storlist(Integer id, Long createdAt, String storeName, String imageurl, String description, String place) {
        this.id = id;
        this.createdAt = createdAt;
        this.storeName = storeName;
        this.imageurl = imageurl;
        this.description = description;
        this.place = place;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
