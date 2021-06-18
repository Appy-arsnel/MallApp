package com.example.mallapp;

import androidx.annotation.NonNull;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Menu;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;

import com.facebook.login.LoginManager;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    DatabaseReference reff;
    ImageView photo;

    ColorStateList def;
    TextView item1, item2,item3,select;

     ChipNavigationBar bottomNavigationView;

    Fragment currentFragment = null;
    FragmentTransaction ft;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        item1=findViewById(R.id.item1);
        item2=findViewById(R.id.item2);
        item3=findViewById(R.id.item3);
        select=findViewById(R.id.select);
        item2.setTextColor(Color.BLACK);
        item3.setTextColor(Color.BLACK);
        def=item2.getTextColors();
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select.animate().x(0).setDuration(100);
                item1.setTextColor(Color.WHITE);
                item2.setTextColor(def);
                item3.setTextColor(def);
                currentFragment = new HomeFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, currentFragment);
                ft.commit();
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size=item2.getWidth();
                item1.setTextColor(def);
                item2.setTextColor(Color.WHITE);
                item3.setTextColor(def);

                select.animate().x(size).setDuration(100);

                currentFragment = new FoodFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, currentFragment);
                ft.commit();
            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size=item2.getWidth()*2;
                item1.setTextColor(def);
                item2.setTextColor(def);
                item3.setTextColor(Color.WHITE);
                select.animate().x(size).setDuration(100);

                currentFragment = new ShopFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, currentFragment);
                ft.commit();
            }
        });

        setSupportActionBar(toolbar);
       // photo = findViewById(R.id.photo);
       // SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
       // String s1 = sh.getString("photourl", "");

       // Glide.with(getApplicationContext()).load(s1).centerCrop().placeholder(R.drawable.ic_back_img).into(photo);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        bottomNavigationView = findViewById(R.id.bottomNav_view);
        ft = getSupportFragmentManager().beginTransaction();
        currentFragment = new HomeFragment();
        ft.replace(R.id.flFragment, currentFragment);
        ft.commit();
       bottomNavigationView.setItemSelected(R.id.homess,true);
        bottomNavigationView.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                switch (id) {
                    case R.id.homess:

                        currentFragment = new HomeFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.flFragment, currentFragment);


                        ft.commit();
                        break;
                    case R.id.parkingss:

                        currentFragment = new ParkingFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.flFragment, currentFragment);

                        ft.commit();

                        break;
                    case R.id.sales:
                        currentFragment = new SalesFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.flFragment, currentFragment);
                        ft.commit();
                        break;
                    case R.id.navigation:
                        currentFragment = new NaviFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.flFragment, currentFragment);
                        ft.commit();
                        break;


                }





            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Settings:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.SignOut:

                        FirebaseAuth.getInstance().signOut();
                        LoginManager.getInstance().logOut();
                        GoogleSignInOptions gso = new GoogleSignInOptions.
                                Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                                build();

                        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(MainActivity.this, gso);
                        googleSignInClient.signOut();

                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        Toast.makeText(MainActivity.this, "Signed out", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        finish();
    }


}