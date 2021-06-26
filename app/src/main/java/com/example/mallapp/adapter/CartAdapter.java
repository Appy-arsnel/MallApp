package com.example.mallapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mallapp.FoodDetails;
import com.example.mallapp.R;
import com.example.mallapp.model.Cartdata;
import com.example.mallapp.model.Popular;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.PopularViewHolder> {

    private Context context;
    Cartdata data[];

    public CartAdapter(Context context, Cartdata[] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_recycler_items, parent, false);


        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

        holder.popularName.setText(data[position].getName());


        Glide.with(context).load(data[position].getImageurl()).into(holder.popularImage);

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, FoodDetails.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                i.putExtra("name", data[position].getName());
                i.putExtra("rating", data[position].getRating());
                i.putExtra("image", data[position].getImageurl());
                context.startActivity(i);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView popularImage;
        TextView popularName;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            popularName = itemView.findViewById(R.id.all_menu_name);
            popularImage = itemView.findViewById(R.id.all_menu_image);

        }
    }
}
