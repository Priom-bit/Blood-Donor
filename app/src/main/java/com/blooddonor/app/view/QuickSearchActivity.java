package com.blooddonor.app.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.blooddonor.app.R;
import com.blooddonor.app.databinding.ActivityQuickSearchBinding;

public class QuickSearchActivity extends AppCompatActivity {

    ActivityQuickSearchBinding quickSearchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quickSearchBinding = DataBindingUtil.setContentView(this, R.layout.activity_quick_search);
        quickSearchBinding.toolbar.setNavigationOnClickListener(l -> onBackPressed());
    }
}