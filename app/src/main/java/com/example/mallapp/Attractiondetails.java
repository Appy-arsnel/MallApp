package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Attractiondetails extends AppCompatActivity {

    ImageView image;
    TextView itemTitle;
    TextView itemDescription;
    String title, description, imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractiondetails);
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        imageUrl = intent.getStringExtra("image");
        description = intent.getStringExtra("description");
        image = findViewById(R.id.attrtimgdet);
        itemTitle = findViewById(R.id.attrdetailsttitle);
        itemDescription = findViewById(R.id.attrdetailsdesc);
        Glide.with(getApplicationContext()).load(imageUrl).into(image);
        itemTitle.setText(title);
        itemDescription.setText(description);


    }
}