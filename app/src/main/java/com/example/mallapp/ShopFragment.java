package com.example.mallapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class    ShopFragment extends Fragment {
    public static ShopFragment newInstance(){
        ShopFragment fragment=new ShopFragment();
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View rootView=inflater.inflate(R.layout.fragment_shop,container,false);

        return inflater.inflate(R.layout.fragment_shop,container,false);
    }
}
