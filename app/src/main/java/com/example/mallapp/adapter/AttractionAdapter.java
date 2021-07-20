package com.example.mallapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mallapp.Attraction;
import com.example.mallapp.Attractiondetails;
import com.example.mallapp.Food_Details_one;
import com.example.mallapp.R;
import com.example.mallapp.model.Attractions;
import com.example.mallapp.model.Event;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.PopularViewHolder> {

    private Context context;
    Attractions data[];

    public AttractionAdapter(Context context, Attractions[] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_attraction, parent, false);


        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

        holder.title.setText(data[position].getTitle());

        Glide.with(context).load(data[position].getImageurl()).into(holder.attrimage);
        holder.knowmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "know more", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, Attractiondetails.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                i.putExtra("title", data[position].getTitle());

                i.putExtra("image", data[position].getImageurl());
                i.putExtra("description", data[position].getDescription());
                context.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView attrimage;
        TextView title;
        Button knowmore;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            attrimage = itemView.findViewById(R.id.attrtimg);
            title = itemView.findViewById(R.id.attrttitle);

            knowmore = itemView.findViewById(R.id.btnattrreminder);


        }
    }
}
