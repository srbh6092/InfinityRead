package com.noobdevs.infinityread;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Profile_Info extends AppCompatActivity
{
    EditText profileInfoNameEt , profileInfoEmailEt , profileInfoDobEt;
    Button profileInfoContinue;
    RadioGroup radioGroup ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__info);

        profileInfoContinue = findViewById(R.id.btn_ProfileInfo_continue);
        profileInfoNameEt = findViewById(R.id.et_ProfileInfo_fullNameET);
        profileInfoEmailEt = findViewById(R.id.et_ProfileInfo_emailET);
        profileInfoDobEt = findViewById(R.id.et_ProfileInfo_dobET);
        radioGroup = findViewById(R.id.radioGroup);




        profileInfoContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(profileInfoNameEt.getText().toString().isEmpty())
                {
                    profileInfoNameEt.setError("Field can't be empty");
                }
                else if(profileInfoEmailEt.getText().toString().isEmpty())
                {
                    profileInfoEmailEt.setError("Field can't be empty");
                }
                else if(profileInfoDobEt.getText().toString().isEmpty())
                {
                    profileInfoDobEt.setError("Field can't be empty");
                }
                else if(radioGroup.getCheckedRadioButtonId() == -1)
                {
                    int lastChildPos=radioGroup.getChildCount()-1;
                    ((RadioButton)radioGroup.getChildAt(lastChildPos)).setError("Your error");
                }
                else {
                    Intent intent = new Intent(Profile_Info.this, Homepage.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}