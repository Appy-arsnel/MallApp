package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mallapp.adapter.CartAdapter;
import com.example.mallapp.adapter.RecommendedAdapter;
import com.example.mallapp.model.Cartdata;
import com.example.mallapp.model.Recommended;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AddtoCart extends AppCompatActivity {
    RecyclerView cartrec;
    CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto_cart);
    cartrec=findViewById(R.id.recycleraddedtocard);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,
                false);

        cartrec.setLayoutManager(layoutManager);
        cartdata();


    }

    private void cartdata() {


        String carturl="https://x8ki-letl-twmt.n7.xano.io/api:jwtfZ8_V/cart";
        StringRequest request = new StringRequest(carturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Cartdata data[] = gson.fromJson(response, Cartdata[].class);
                cartAdapter = new CartAdapter(getBaseContext(), data);
                cartrec.setAdapter(cartAdapter);


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




