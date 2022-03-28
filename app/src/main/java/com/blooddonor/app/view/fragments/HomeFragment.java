package com.blooddonor.app.view.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blooddonor.app.R;
import com.blooddonor.app.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    FragmentHomeBinding homeBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);


        return homeBinding.getRoot();
    }
}