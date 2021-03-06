package com.example.mallapp;


import android.content.Intent;
import android.media.MediaParser;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mallapp.adapter.AllMenuAdapter;
import com.example.mallapp.adapter.PopularAdapter;
import com.example.mallapp.adapter.RecommendedAdapter;
import com.example.mallapp.model.Allmenu;
import com.example.mallapp.model.FoodData;
import com.example.mallapp.model.GetDatum;
import com.example.mallapp.model.Popular;
import com.example.mallapp.model.Recommended;
import com.example.mallapp.retrofit.ApiInterface;
import com.example.mallapp.retrofit.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class FoodFragment extends Fragment {


CardView foodstore;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_food, container, false);

        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        foodstore=view.findViewById(R.id.foodstore);
        foodstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),foodActivity.class));
            }
        });

    }



}


