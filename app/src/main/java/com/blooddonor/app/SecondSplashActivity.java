package com.blooddonor.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.blooddonor.app.databinding.ActivitySecondSplashBinding;
import com.blooddonor.app.view.LoginActivity;
import com.blooddonor.app.view.QuickSearchActivity;


public class SecondSplashActivity extends AppCompatActivity {
    ActivitySecondSplashBinding secondSplashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondSplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_second_splash);

        Window window = getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


        secondSplashBinding.btnSignIn.setOnClickListener(l -> {
            Intent i = new Intent(SecondSplashActivity.this,
                    LoginActivity.class);
            startActivity(i);
        });

        secondSplashBinding.btnCreateAccount.setOnClickListener(l -> {
            Intent i = new Intent(SecondSplashActivity.this,
                    SignUpActivity.class);
            startActivity(i);
        });

        secondSplashBinding.quickSearch.setOnClickListener(l -> {
            Intent i = new Intent(SecondSplashActivity.this,
                    QuickSearchActivity.class);
            startActivity(i);
        });


    }
}