package com.blooddonor.app.view.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.blooddonor.app.R;
import com.blooddonor.app.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
FragmentProfileBinding profileBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        profileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        profileBinding.toolbar.setNavigationOnClickListener(l-> getActivity().onBackPressed());

        profileBinding.numberToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    profileBinding.tvMobileNo.setTextColor(getResources().getColor(R.color.theme_color));
                else
                    profileBinding.tvMobileNo.setTextColor(getResources().getColor(R.color.textColor_3));
            }
        });

        profileBinding.toggleAvailableToDonate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    profileBinding.layoutAvailableToDonate.setVisibility(View.VISIBLE);
                else
                    profileBinding.layoutAvailableToDonate.setVisibility(View.GONE);
            }
        });

        profileBinding.toggleEmergencyDonater.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    profileBinding.layoutEmergencyDonater.setVisibility(View.GONE);
                else
                    profileBinding.layoutEmergencyDonater.setVisibility(View.VISIBLE);
            }
        });

        profileBinding.history.setOnClickListener(l -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.navigation_history);
        });

        profileBinding.manageAddress.setOnClickListener(l -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.navigation_manage_address);
        });


        return profileBinding.getRoot();
    }
}