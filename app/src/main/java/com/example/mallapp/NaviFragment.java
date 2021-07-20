package com.example.mallapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.squareup.picasso.Picasso;

public class NaviFragment extends Fragment {
    Fragment currentFragment = null;
    FragmentTransaction ft;
    ChipNavigationBar bottomNavigationView;

    private String address;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View rootView=inflater.inflate(R.layout.fragment_navi,container,false);

        return inflater.inflate(R.layout.fragment_navi,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        address="DLF Mall,Baird Place, Delhi Cantonment, New Delhi, Delhi 110010";
        String url = "http://maps.google.com/maps?daddr="+address;
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
        startActivity(intent);

        currentFragment = new HomeFragment();
        ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flFragment, currentFragment);
        ft.commit();


    }




}
