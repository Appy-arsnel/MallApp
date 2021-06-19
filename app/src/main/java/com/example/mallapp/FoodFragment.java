package com.example.mallapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mallapp.adapter.AllMenuAdapter;
import com.example.mallapp.adapter.PopularAdapter;
import com.example.mallapp.adapter.RecommendedAdapter;
import com.example.mallapp.model.Allmenu;
import com.example.mallapp.model.FoodData;
import com.example.mallapp.model.GetDatum;
import com.example.mallapp.model.Popular;
import com.example.mallapp.model.Recommended;
import com.example.mallapp.retrofit.ApiInterface;
import com.example.mallapp.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FoodFragment extends Fragment {

    ApiInterface apiInterface;

    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    PopularAdapter popularAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_food,container,false);

        return inflater.inflate(R.layout.fragment_food,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        popularRecyclerView = view.findViewById(R.id.popular_recycler);

        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<GetDatum>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<GetDatum>>() {
            @Override
            public void onResponse(Call<List<GetDatum>> call, Response<List<GetDatum>> response) {

                List<GetDatum> foodDataList = response.body();

                getPopularData(foodDataList.get(0).getPopular());




            }



            @Override
            public void onFailure(Call<List<GetDatum>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void  getPopularData(List<GetDatum> popularList){

        popularAdapter = new PopularAdapter(getContext(), popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }


}


