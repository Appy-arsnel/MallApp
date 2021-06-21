package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mallapp.adapter.PopularAdapter;
import com.example.mallapp.adapter.RecommendedAdapter;
import com.example.mallapp.model.GetDatum;
import com.example.mallapp.model.Popular;
import com.example.mallapp.model.Recommended;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class foodActivity extends AppCompatActivity {
    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    PopularAdapter popularAdapter;
    RecommendedAdapter recommendedAdapter;
    ImageView back;
    private static final String popularurl = "https://x8ki-letl-twmt.n7.xano.io/api:jwtfZ8_V/food_store";
    private static final String recomurl = "https://x8ki-letl-twmt.n7.xano.io/api:jwtfZ8_V/recommendes_food";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        popularRecyclerView = findViewById(R.id.popular_recycler);
        recommendedRecyclerView = findViewById(R.id.recyclerecomweek);
        back = findViewById(R.id.back2);
        back.bringToFront();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FoodFragment.class));
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        popularRecyclerView.setLayoutManager(layoutManager);

        recommendedRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));


        populardata();

        recomdata();


    }



    public void recomdata() {
        StringRequest request = new StringRequest(recomurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Recommended data[] = gson.fromJson(response, Recommended[].class);
                recommendedAdapter = new RecommendedAdapter(getBaseContext(), data);
                recommendedRecyclerView.setAdapter(recommendedAdapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }


    public void populardata() {

        StringRequest request = new StringRequest(popularurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Popular data[] = gson.fromJson(response, Popular[].class);
                popularAdapter = new PopularAdapter(getBaseContext(), data);
                popularRecyclerView.setAdapter(popularAdapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

}