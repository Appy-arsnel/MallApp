package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {






    // creating object of ViewPager
        ViewPager mViewPager;
        ProgressBar progressBar;
        // images array



    int[] images;

        // Creating Object of ViewPagerAdapter
        ViewPagerAdapter mViewPagerAdapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            // Initializing the ViewPager Object
            mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

            // Initializing the ViewPagerAdapter
            mViewPagerAdapter = new ViewPagerAdapter(MainActivity.this);

            // Adding the Adapter to the ViewPager
            mViewPager.setAdapter(mViewPagerAdapter);
        }
    }