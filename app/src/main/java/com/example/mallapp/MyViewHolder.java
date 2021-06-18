package com.example.mallapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    ImageView img;
    TextView txt;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        img=itemView.findViewById(R.id.holder);
        txt=itemView.findViewById(R.id.texthold);
    }


}
