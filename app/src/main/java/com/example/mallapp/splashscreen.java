package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class splashscreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 4000;
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        video= findViewById(R.id.splashs);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splassh);
        video.setVideoURI(uri);
        video.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splashscreen.this, MainActivity.class);
                startActivity(i);
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}