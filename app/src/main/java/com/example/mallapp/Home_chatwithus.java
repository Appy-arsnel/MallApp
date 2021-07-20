package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class Home_chatwithus extends AppCompatActivity {
ImageView beck,whatsappimg,botimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_chatwithus);

        beck=findViewById(R.id.bak2);
        whatsappimg=findViewById(R.id.imgwhatsApp);
        botimg=findViewById(R.id.imgBot);
        Glide.with(getApplicationContext()).load("https://i.insider.com/5f57ecd6e6ff30001d4e79d0?width=700").into(whatsappimg);
        Glide.with(getApplicationContext()).load("https://capacity.com/wp-content/uploads/2019/08/chatbot-4071274_1920.jpg").into(botimg);
        beck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        whatsappimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean installed = isAppInstalled("com.whatsapp");// gives value true if whatsapp is installed
                                                                      //in phone and vise -versa

                if (installed){
                Toast.makeText(getApplicationContext(),"whatsap opened",Toast.LENGTH_SHORT).show();
                Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW);//Intent for Whatsapp is created
                String url = "https://chat.whatsapp.com/https://chat.whatsapp.com/Jt5X2QFBgLi2twZWUq2F3Y";
                intentWhatsapp.setData(Uri.parse(url));
                intentWhatsapp.setPackage("com.whatsapp");
                startActivity(intentWhatsapp);//starts the intent whatsapp
                }
            }
        });
        botimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"bot opened",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_chatwithus.this,chatbot.class));
            }
        });



    }



    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;

        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
            is_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }
}