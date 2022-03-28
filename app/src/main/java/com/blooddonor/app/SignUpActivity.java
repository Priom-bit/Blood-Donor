package com.blooddonor.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blooddonor.app.databinding.ActivitySignUpBinding;
import com.blooddonor.app.view.LoginActivity;
import com.blooddonor.app.view.QuickSearchActivity;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding signUpBinding;

    private boolean page1 = true;
    private boolean page2 = false;
    private boolean page3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        signUpBinding.btnLogin.setOnClickListener(l -> {
            Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        });


        signUpBinding.quickSearch.setOnClickListener(l -> {
            Intent i = new Intent(SignUpActivity.this, QuickSearchActivity.class);
            startActivity(i);
        });


        signUpBinding.btnSignUp.setOnClickListener(l -> {
            if (page1) {
                secondPage();
            } else if (page2) {
                thirdPage();
            }
        });
    }

    private void firstPage() {
        page1 = true;
        page2 = false;
        page3 = false;

        signUpBinding.signUp1.setVisibility(View.VISIBLE);
        signUpBinding.signUp2.setVisibility(View.GONE);
        signUpBinding.signUp3.setVisibility(View.GONE);
        signUpBinding.quickSearch.setVisibility(View.VISIBLE);

        signUpBinding.btnSignUp.setText("Sign Up");

        signUpBinding.tvOne.setBackground(getResources().getDrawable(R.drawable.custom_rectangle_theme_color));
        signUpBinding.tvTwo.setBackground(getResources().getDrawable(R.drawable.custom_rectangle));
        signUpBinding.tvThree.setBackground(getResources().getDrawable(R.drawable.custom_rectangle));

        signUpBinding.tvOneText.setTextColor(getColor(R.color.theme_color));
        signUpBinding.tvTwoText.setTextColor(getColor(R.color.black_light));
        signUpBinding.tvThreeText.setTextColor(getColor(R.color.black_light));
    }

    private void secondPage() {
        page1 = false;
        page2 = true;
        page3 = false;

        signUpBinding.signUp1.setVisibility(View.GONE);
        signUpBinding.signUp2.setVisibility(View.VISIBLE);
        signUpBinding.signUp3.setVisibility(View.GONE);
        signUpBinding.quickSearch.setVisibility(View.VISIBLE);

        signUpBinding.btnSignUp.setText("Sign Up");

        signUpBinding.tvOne.setBackground(getResources().getDrawable(R.drawable.custom_rectangle));
        signUpBinding.tvTwo.setBackground(getResources().getDrawable(R.drawable.custom_rectangle_theme_color));
        signUpBinding.tvThree.setBackground(getResources().getDrawable(R.drawable.custom_rectangle));

        signUpBinding.tvOneText.setTextColor(getColor(R.color.black_light));
        signUpBinding.tvTwoText.setTextColor(getColor(R.color.theme_color));
        signUpBinding.tvThreeText.setTextColor(getColor(R.color.black_light));
    }

    private void thirdPage() {
        page1 = false;
        page2 = false;
        page3 = true;

        signUpBinding.signUp1.setVisibility(View.GONE);
        signUpBinding.signUp2.setVisibility(View.GONE);
        signUpBinding.signUp3.setVisibility(View.VISIBLE);
        signUpBinding.quickSearch.setVisibility(View.GONE);

        signUpBinding.btnSignUp.setText("Complete");

        signUpBinding.tvOne.setBackground(getResources().getDrawable(R.drawable.custom_rectangle));
        signUpBinding.tvTwo.setBackground(getResources().getDrawable(R.drawable.custom_rectangle));
        signUpBinding.tvThree.setBackground(getResources().getDrawable(R.drawable.custom_rectangle_theme_color));

        signUpBinding.tvOneText.setTextColor(getColor(R.color.black_light));
        signUpBinding.tvTwoText.setTextColor(getColor(R.color.black_light));
        signUpBinding.tvThreeText.setTextColor(getColor(R.color.theme_color));
    }


    @Override
    public void onBackPressed() {
        if (page3) {
            secondPage();
        } else if (page2) {
            firstPage();
        } else
            super.onBackPressed();
    }
}