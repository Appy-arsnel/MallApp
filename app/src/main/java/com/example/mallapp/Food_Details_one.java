package com.example.mallapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Food_Details_one extends AppCompatActivity {

    // now we will get data from intent and set to UI

    ImageView imageView;
    TextView itemName;
    TextView itemDescription;
    TextView itemRating;
    RatingBar ratingBar;
    TextView Price;

    String name, description, rating, imageUrl,price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_store_details);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        price=intent.getStringExtra("price");
        rating = intent.getStringExtra("rating");
        imageUrl = intent.getStringExtra("image");
        description = intent.getStringExtra("description");
        imageView = findViewById(R.id.imageView5);
        itemName = findViewById(R.id.name);
        itemDescription = findViewById(R.id.textView8);
        itemRating = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);
        Price=findViewById(R.id.price);

        Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        itemName.setText(name);
        itemDescription.setText(description);
        itemRating.setText(rating);
        Price.setText("Rs."+price);

        ratingBar.setRating(Float.parseFloat(rating));

    }
}
