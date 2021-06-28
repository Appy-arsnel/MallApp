package com.example.mallapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Food_Details_one extends AppCompatActivity {

    // now we will get data from intent and set to UI

    ImageView imageView;
    TextView itemName;
    TextView itemDescription;
    TextView itemRating;
    RatingBar ratingBar;
    TextView Price;
    Button Addtocart;
    ImageView wishlist;
    String name, description, rating, imageUrl, price,id;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://mall-app-8b01d-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private DatabaseReference reff;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_store_details);
        Addtocart=findViewById(R.id.baddtocart);
        wishlist=findViewById(R.id.wishlist);
        wishlist.bringToFront();
        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("rating");
        imageUrl = intent.getStringExtra("image");
        description = intent.getStringExtra("description");
        id = intent.getStringExtra("id");

        imageView = findViewById(R.id.imageView5);
        itemName = findViewById(R.id.name);
        itemDescription = findViewById(R.id.textView8);
        itemRating = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);
        Price = findViewById(R.id.price);
        reff=firebaseDatabase.getReference();
        Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        itemName.setText(name);
        itemDescription.setText(description);
        itemRating.setText(rating);
        Price.setText("Rs." + price);

        ratingBar.setRating(Float.parseFloat(rating));
      Addtocart.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


              Intent i = new Intent(getApplicationContext(), AddtoCart.class);
              i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              i.putExtra("name", name);
              i.putExtra("price", price);
              i.putExtra("rating", rating);
              i.putExtra("image", imageUrl);
              i.putExtra("id", id);
              Toast.makeText(Food_Details_one.this,"Added to cart",Toast.LENGTH_SHORT).show();
              startActivity(i);



          }
      });
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Food_Details_one.this,"Added to cart",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Wishlist.class));
            }
        });


    }

}
