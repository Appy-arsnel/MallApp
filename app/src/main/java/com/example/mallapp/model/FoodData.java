package com.example.mallapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodData {

    @SerializedName("GetDatum")
    @Expose
    private List<GetDatum> getdatum = null;


    public List<GetDatum> getPopular() {
        return getdatum;
    }

    public void setPopular(List<GetDatum> popular) {
        this.getdatum = popular;
    }


}
