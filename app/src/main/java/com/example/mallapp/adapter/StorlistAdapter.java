package com.example.mallapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mallapp.R;
import com.example.mallapp.Shopmall;
import com.example.mallapp.model.Event;
import com.example.mallapp.model.storlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class StorlistAdapter extends RecyclerView.Adapter<StorlistAdapter.PopularViewHolder> /*implements Filterable */{

    private Context context;

    List<storlist> storllist;
    List<storlist> storlistAll;



    public StorlistAdapter(Context context, List<storlist> storllist, Shopmall shopmall) {
        this.context = context;
        this.storllist = storllist;

        this. storlistAll=new ArrayList<>(storllist);
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_storelist, parent, false);


        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {


        holder.place.setText(storllist.get(position).getPlace());
        holder.title.setText(storllist.get(position).getStoreName());

        Glide.with(context).load(storllist.get(position).getImageurl()).into(holder.storeimage);
       /* holder.setreminder.setOnClickListener(new View.OnClickListener() {
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
        });*/


    }

    @Override
    public int getItemCount() {
        return storllist.size();
    }

 /*   @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<storlist> filteredList =new ArrayList<>();

                if(constraint.toString().isEmpty()) {
                    filteredList.addAll(storlistAll);
                }
                else{
                    for(storlist storel:storlistAll)
                    {
                        if(storel.getStoreName().toLowerCase().contains(constraint.toString().toLowerCase())){
                            filteredList.add(storel);
                        }
                    }

                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                storllist.clear();
                storllist.addAll((Collection<? extends storlist>) results.values);
                notifyDataSetChanged();

            }
        };
    }
*/
 public void filterList(ArrayList<storlist> filteredList) {
     storllist = filteredList;
     notifyDataSetChanged();
 }
    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView storeimage;
        TextView title, place;


        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);


            title = itemView.findViewById(R.id.storelisttitle);
            place = itemView.findViewById(R.id.storeplace);
            storeimage = itemView.findViewById(R.id.storelistimg);




        }
    }
}
