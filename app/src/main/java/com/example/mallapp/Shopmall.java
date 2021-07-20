package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mallapp.adapter.PopularAdapter;
import com.example.mallapp.adapter.RecommendedAdapter;
import com.example.mallapp.adapter.StorlistAdapter;
import com.example.mallapp.model.Recommended;
import com.example.mallapp.model.storlist;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shopmall extends AppCompatActivity {
    StorlistAdapter storlistAdapter;
    RecyclerView storeRecyclerView;
    EditText searchView;
   List<storlist> storlis;
    private ArrayList<storlist> Stur;
    private static final String storelisturl = "https://x8ki-letl-twmt.n7.xano.io/api:jwtfZ8_V/storelist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopmall);
        storeRecyclerView=findViewById(R.id.recyclestorlist);
        searchView=findViewById(R.id.searchstor);
        storlis=new ArrayList<>();

         searchView.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }

             @Override
             public void afterTextChanged(Editable s) {
                 filter(s.toString());
             }
         });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        storeRecyclerView.setLayoutManager(layoutManager);


        storelistrecyle();
        storlistAdapter=new StorlistAdapter(getApplicationContext(),storlis,this);
        storeRecyclerView.setAdapter(storlistAdapter);
    }

    private void filter(String text) {
        ArrayList<storlist> filteredList = new ArrayList<>();
        for (storlist item : storlis) {
            if (item.getStoreName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
         storlistAdapter.filterList(filteredList);

    }

    private void storelistrecyle() {
        JsonArrayRequest request=new JsonArrayRequest(storelisturl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response == null) {
                    Toast.makeText(getApplicationContext(), "Couldn't fetch the contacts! Pleas try again.", Toast.LENGTH_LONG).show();
                    return;
                }
                List<storlist> items = new Gson().fromJson(response.toString(), new TypeToken<List<storlist>>() {
                }.getType());

                storlis.clear();
                storlis.addAll(items);

                storlistAdapter.notifyDataSetChanged();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        );

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);


    }
}