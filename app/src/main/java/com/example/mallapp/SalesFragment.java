package com.example.mallapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class SalesFragment extends Fragment {
  /*  RecyclerView recyclerView;
    FirebaseRecyclerOptions<salesdta> options;
    FirebaseRecyclerAdapter<salesdta, MyViewHolder> adapter;
    DatabaseReference databaseReference;*/


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sale, container, false);

        return inflater.inflate(R.layout.fragment_sale, container, false);

    }

   /* @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        databaseReference = FirebaseDatabase.getInstance("https://mall-app-8b01d-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference().child("Sale");
        recyclerView = view.findViewById(R.id.salesrec);
        loaddata();

    }

    private void loaddata() {

        options = new FirebaseRecyclerOptions.Builder<salesdta>().setQuery(databaseReference, salesdta.class).build();
        adapter = new FirebaseRecyclerAdapter<salesdta, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull salesdta model) {
                holder.txt.setText(model.getSalesinfo());
                Picasso.get().load(model.getImgurl()).into(holder.img);
            }


            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View y = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sale, parent, false);
                return new MyViewHolder(y);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }*/
}
