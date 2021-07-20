package com.example.mallapp.adapter;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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
import com.example.mallapp.FoodDetails;
import com.example.mallapp.R;
import com.example.mallapp.ReminderBroadcastReceiver;
import com.example.mallapp.model.Event;
import com.example.mallapp.model.Popular;

import java.util.Calendar;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.PopularViewHolder> {

    private Context context;
    Event data[];

    public EventAdapter(Context context, Event[] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_event, parent, false);


        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

        holder.title.setText(data[position].getTitle());
        holder.place.setText(data[position].getPlace());
        holder.desc.setText(data[position].getDescription());
        holder.time.setText(data[position].getTime());

        Glide.with(context).load(data[position].getImageurl()).into(holder.eventimage);
        holder.setreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "set reminder", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, data[position].getTitle());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,data[position].getDescription());
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView eventimage;
        TextView title, place, time, desc;
        Button setreminder;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            eventimage = itemView.findViewById(R.id.eventimg);
            title = itemView.findViewById(R.id.eventtitle);
            place = itemView.findViewById(R.id.eventplace);
            desc = itemView.findViewById(R.id.eventdesc);
            time = (TextView) itemView.findViewById(R.id.eventtime);
            setreminder = itemView.findViewById(R.id.btneventreminder);


        }
    }
}
