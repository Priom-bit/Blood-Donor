package com.blooddonor.app.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;


import com.blooddonor.app.MainActivity;
import com.blooddonor.app.R;
import com.blooddonor.app.SignUpActivity;
import com.blooddonor.app.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginBinding.btnSignUp.setOnClickListener(l -> {
            Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(i);
            finish();
        });

        loginBinding.btnForgotPassword.setOnClickListener(l -> {
            Intent i = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(i);
            finish();
        });

        loginBinding.btnSignIn.setOnClickListener(l -> {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finishAffinity();
        });


    }
}