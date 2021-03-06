package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FoodDetails extends AppCompatActivity {

    // now we will get data from intent and set to UI

    ImageView imageView;
    TextView itemName;
    TextView itemDescription;
    TextView itemRating;
    RatingBar ratingBar;

    String name, description, rating, imageUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");

        rating = intent.getStringExtra("rating");
        imageUrl = intent.getStringExtra("image");
        description = intent.getStringExtra("details");

        imageView = findViewById(R.id.imageView5);
        itemName = findViewById(R.id.name);
        itemDescription = findViewById(R.id.textView8);
        itemRating = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);

        Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        itemName.setText(name);
        itemDescription.setText(description);
        itemRating.setText(rating);
        ratingBar.setRating(Float.parseFloat(rating));

    }
}
