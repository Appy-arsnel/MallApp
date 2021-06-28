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
import com.example.mallapp.Food_Details_one;
import com.example.mallapp.R;
import com.example.mallapp.model.Recommended;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder> {

    private Context context;
    Recommended data[];

    public RecommendedAdapter(Context context, Recommended[] data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public RecommendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommended_recycler_items, parent, false);
        return new RecommendedViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedViewHolder holder, final int position) {

        holder.recommendedName.setText(data[position].getName());
        holder.recommendedRating.setText(data[position].getRating());
        holder.recommendedPrice.setText(data[position].getPrice());
        holder.recommendedDeliveryTime.setText(data[position].getTime());
        Glide.with(context).load(data[position].getImageurl()).into(holder.recommendedImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, Food_Details_one.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                i.putExtra("name", data[position].getName());
                i.putExtra("price", data[position].getPrice());
                i.putExtra("rating", data[position].getRating());
                i.putExtra("image", data[position].getImageurl());
                i.putExtra("description", data[position].getDescription());
                i.putExtra("id", data[position].getId().toString());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class RecommendedViewHolder extends RecyclerView.ViewHolder {

        ImageView recommendedImage;
        TextView recommendedName, recommendedRating, recommendedDeliveryTime,  recommendedPrice;

        public RecommendedViewHolder(@NonNull View itemView) {
            super(itemView);

            recommendedImage = itemView.findViewById(R.id.recommended_image);
            recommendedName = itemView.findViewById(R.id.recommended_name);
            recommendedRating = itemView.findViewById(R.id.recommended_rating);
            recommendedDeliveryTime = itemView.findViewById(R.id.recommended_delivery_time);
            recommendedPrice = itemView.findViewById(R.id.recommended_price);

        }
    }


}
