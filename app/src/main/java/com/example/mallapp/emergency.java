package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class emergency extends AppCompatActivity {
    Button emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);


             emergency=findViewById(R.id.emergencyhospitals);
             emergency.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     // Search for restaurants nearby
                     Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospitals");
                     Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                     mapIntent.setPackage("com.google.android.apps.maps");
                     startActivity(mapIntent);

                 }
             });



    }
}