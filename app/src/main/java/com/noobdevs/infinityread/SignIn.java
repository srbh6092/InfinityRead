package com.noobdevs.infinityread;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity
{
    Button signInSendOtpBtn;
    EditText signInPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInSendOtpBtn = findViewById(R.id.btn_SignIn_SendOTP);
        signInPhoneNumber = findViewById(R.id.et_SignIn);

        signInSendOtpBtn.setOnClickListener(v -> {
            if(signInPhoneNumber.getText().toString().length() != 10)
            {
                signInPhoneNumber.setError("Invalid Number");
            }
            else {
                Intent intent = new Intent(SignIn.this, OtpVerification.class);
                intent.putExtra("PhoneNumber", signInPhoneNumber.getText().toString());
                startActivity(intent);
                Toast.makeText(SignIn.this, signInPhoneNumber.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}