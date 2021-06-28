package com.example.mallapp.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mallapp.R;
import com.example.mallapp.Cartdata;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.net.InternetDomainName;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

public class CartAdapter extends FirebaseRecyclerAdapter<Cartdata, CartAdapter.cardViewholder> {
    private Context context;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://mall-app-8b01d-default-rtdb.asia-southeast1.firebasedatabase.app/");
     DatabaseReference reff;


    public CartAdapter(@NonNull FirebaseRecyclerOptions<Cartdata> options, Context context) {
        super(options);
        this.context = context;

    }
    Integer no;


    @Override
    protected void onBindViewHolder(@NonNull cardViewholder holder, int position, @NonNull Cartdata model) {
        no=model.getNumber();


        String uid=FirebaseAuth.getInstance().getCurrentUser().getUid();

        holder.delete.bringToFront();




        holder.Name.setText(model.getName());
        holder.Rating.setText(model.getRating());

        holder.Price.setText(model.getPrice());
        Glide.with(context).load(model.getImageurl()).into(holder.AddedImage);
        holder.number.setText(String.valueOf(model.getNumber()));
        reff=firebaseDatabase.getReference().child("User").child(uid).child("Cart");
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no++;


                HashMap<String,Object> result=new HashMap<>();
                result.put("number",no);
                result.put("price",String.valueOf(Integer.parseInt(model.getPrice())+Integer.parseInt(model.getPrice())));
                reff.child(getRef(position).getKey()).updateChildren(result);

            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no--;


                HashMap<String,Object> result=new HashMap<>();
                result.put("number",no);
                result.put("price",String.valueOf(Integer.parseInt(model.getPrice())-Integer.parseInt(model.getPrice())));
                reff.child(getRef(position).getKey()).updateChildren(result);


                if(no==0){
                    reff.child(getRef(position).getKey()).removeValue();
                }
            }

        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff.child(getRef(position).getKey()).removeValue();
            }
        });



    }



    @NonNull
    @Override
    public CartAdapter.cardViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_addedtocart, parent, false);
        return new CartAdapter.cardViewholder(view);

    }



    public class cardViewholder extends RecyclerView.ViewHolder {


        ImageView AddedImage;
        TextView Name, Rating, Price,number;


        ImageButton plus,minus;
        ImageView delete;

        public cardViewholder(@NonNull View itemView) {
            super(itemView);

            AddedImage = itemView.findViewById(R.id.addimage);
            Name = itemView.findViewById(R.id.addname);
            Rating = itemView.findViewById(R.id.addrating);
            number = itemView.findViewById(R.id.addnumber);
            Price = itemView.findViewById(R.id.addprice);
            plus = itemView.findViewById(R.id.addplus);
            minus = itemView.findViewById(R.id.addminus);
            delete = itemView.findViewById(R.id.deletecart);


        }
    }

}
