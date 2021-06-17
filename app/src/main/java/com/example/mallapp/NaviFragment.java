package com.example.mallapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NaviFragment extends Fragment {
    public static NaviFragment newInstance(){
        NaviFragment fragment=new NaviFragment();
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View rootView=inflater.inflate(R.layout.fragment_navi,container,false);

        return inflater.inflate(R.layout.fragment_navi,container,false);
    }
}
