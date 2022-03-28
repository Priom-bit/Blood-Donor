package com.blooddonor.app.view.fragments.profile;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blooddonor.app.MainActivity;
import com.blooddonor.app.R;
import com.blooddonor.app.databinding.FragmentManageAddressBinding;


public class ManageAddressFragment extends Fragment {
    FragmentManageAddressBinding manageAddressBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        manageAddressBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_manage_address, container, false);
        manageAddressBinding.toolbar.setNavigationOnClickListener(l -> getActivity().onBackPressed());
        return manageAddressBinding.getRoot();
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