package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mallapp.adapter.EventAdapter;
import com.example.mallapp.adapter.PopularAdapter;
import com.example.mallapp.adapter.RecommendedAdapter;
import com.example.mallapp.model.Event;
import com.example.mallapp.model.Recommended;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class event extends AppCompatActivity {
    RecyclerView eventrecycle;
    EventAdapter eventAdapter;

    ImageView back;
    private static final String eventurl = "https://x8ki-letl-twmt.n7.xano.io/api:jwtfZ8_V/event";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        eventrecycle = findViewById(R.id.eventRecycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        eventrecycle.setLayoutManager(layoutManager);
        eventrecycle();

    }

    private void eventrecycle() {

        StringRequest request = new StringRequest(eventurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Event data[] = gson.fromJson(response, Event[].class);
                eventAdapter = new EventAdapter(getBaseContext(), data);
                eventrecycle.setAdapter(eventAdapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        request.setRetryPolicy(new DefaultRetryPolicy(
                6000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        );
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

    }
}