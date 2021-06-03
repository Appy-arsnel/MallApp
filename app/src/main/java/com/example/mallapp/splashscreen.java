package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class splashscreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 4000;
    private VideoView video;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        video= findViewById(R.id.splashs);
        image= findViewById(R.id.logo);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splassh);
        video.setVideoURI(uri);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                image.setVisibility(View.INVISIBLE);
                video.start();
            }
        },3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splashscreen.this, LoginActivity.class);
                startActivity(i);
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}