package com.example.mallapp.retrofit;

import com.example.mallapp.model.FoodData;
import com.example.mallapp.model.GetDatum;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("application/json")
    Call<List<GetDatum>> getAllData();


    // lets make our model class of json data.

}

