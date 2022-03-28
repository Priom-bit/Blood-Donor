package com.blooddonor.app.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.blooddonor.app.OtpVarificationActivity;
import com.blooddonor.app.R;
import com.blooddonor.app.SignUpActivity;
import com.blooddonor.app.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    ActivityForgotPasswordBinding forgotPasswordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forgotPasswordBinding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password);

        forgotPasswordBinding.btnReset.setOnClickListener(l -> {
            Intent i = new Intent(ForgotPasswordActivity.this, OtpVarificationActivity.class);
            startActivity(i);
            finish();
        });

        forgotPasswordBinding.btnSignUp.setOnClickListener(l -> {
            Intent i = new Intent(ForgotPasswordActivity.this, SignUpActivity.class);
            startActivity(i);
            finish();
        });
    }
}