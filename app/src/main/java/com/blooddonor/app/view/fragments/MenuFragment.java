package com.blooddonor.app.view.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blooddonor.app.MainActivity;
import com.blooddonor.app.R;
import com.blooddonor.app.SecondSplashActivity;
import com.blooddonor.app.databinding.FragmentMenuBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class MenuFragment extends Fragment {

    FragmentMenuBinding menuBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        menuBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false);
        menuBinding.toolbar.setNavigationOnClickListener(l -> getActivity().onBackPressed());

        menuBinding.logOut.setOnClickListener(l -> {

            new MaterialAlertDialogBuilder(getContext())
                    .setTitle("Log out")
                    .setMessage("Do you want to log out?")
                    .setPositiveButton("Log out", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getContext(), SecondSplashActivity.class);
                            startActivity(intent);
                            getActivity().finishAffinity();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .show();

        });

        return menuBinding.getRoot();
    }


    @Override
    public void onResume() {
        super.onResume();
        MainActivity.hideBottomNav();
    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity.showBottomNav();
    }
}