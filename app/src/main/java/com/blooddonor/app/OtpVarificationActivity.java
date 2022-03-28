package com.blooddonor.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.blooddonor.app.databinding.ActivityOtpVarificationBinding;

public class OtpVarificationActivity extends AppCompatActivity {

    ActivityOtpVarificationBinding otpVarificationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        otpVarificationBinding = DataBindingUtil.setContentView(this, R.layout.activity_otp_varification);

        otpVarificationBinding.btnContiniue.setOnClickListener(l->{
            Intent i = new Intent(OtpVarificationActivity.this, SetNewPasswordActivity.class);
            startActivity(i);
            finish();
        });

        setupOTPInputs();
    }


    private void setupOTPInputs() {
        otpVarificationBinding.otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    otpVarificationBinding.otp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpVarificationBinding.otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    otpVarificationBinding.otp3.requestFocus();
                } else
                    otpVarificationBinding.otp1.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otpVarificationBinding.otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    otpVarificationBinding.otp4.requestFocus();
                } else
                    otpVarificationBinding.otp2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otpVarificationBinding.otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    hideKeyboard();
                } else
                    otpVarificationBinding.otp3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void hideKeyboard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}