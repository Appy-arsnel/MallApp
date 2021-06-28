package com.example.mallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mallapp.adapter.CartAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class AddtoCart extends AppCompatActivity {
    RecyclerView cartrec;
    CartAdapter cartAdapter;
    String name,rating,imageUrl,price,id;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://mall-app-8b01d-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private DatabaseReference reff;
    private FirebaseUser user;
    private Integer no=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto_cart);
        cartrec=findViewById(R.id.recycleraddedtocard);
        reff=firebaseDatabase.getReference();
        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("rating");
        imageUrl = intent.getStringExtra("image");
        id = intent.getStringExtra("id");

        updatecartdata();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,
                false);

        cartrec.setLayoutManager(layoutManager);
        user = FirebaseAuth.getInstance().getCurrentUser();
        String uid=user.getUid();

        Query query =firebaseDatabase.getReference().child("User").child(uid).child("Cart");
        FirebaseRecyclerOptions<Cartdata> options=new FirebaseRecyclerOptions.Builder<Cartdata>()
                .setQuery(query,Cartdata.class).build();

         cartAdapter=new CartAdapter(options,getApplicationContext());
         cartrec.setAdapter(cartAdapter);
        totalprice();
    }

    private void totalprice() {


    }


    private void updatecartdata() {

        user = FirebaseAuth.getInstance().getCurrentUser();

        String uid = user.getUid();

        Dataone result=new Dataone(imageUrl,name,no,price,rating);
        reff.child("User").child(uid).child("Cart").child(id).setValue(result);


    }

    @Override protected void onStart()
    {
        super.onStart();
        cartAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cartAdapter.stopListening();
    }
}




