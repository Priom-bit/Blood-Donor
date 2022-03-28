package com.blooddonor.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.blooddonor.app.databinding.ActivitySetNewPasswordBinding;

public class SetNewPasswordActivity extends AppCompatActivity {

    ActivitySetNewPasswordBinding newPasswordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newPasswordBinding = DataBindingUtil.setContentView(this, R.layout.activity_set_new_password);


        newPasswordBinding.btnSave.setOnClickListener(l->{
            newPasswordBinding.setPasswordLayout.setVisibility(View.GONE);
            newPasswordBinding.successfullLayout.setVisibility(View.VISIBLE);
        });

    }
}