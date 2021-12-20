package com.noobdevs.infinityread;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Profile_Info extends AppCompatActivity
{
    EditText profileInfoNameEt , profileInfoEmailEt , profileInfoDobEt;
    Button profileInfoContinue;
    RadioGroup radioGroup ;

    FirebaseAuth currentUser;
    DatabaseReference userDB;
    DatabaseReference currentUserDB;
    String currentUserID;

    String name;
    String email;
    String dateOfBirth;
    String gender;
    RadioButton genderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__info);

        profileInfoContinue = findViewById(R.id.btn_ProfileInfo_continue);
        profileInfoNameEt = findViewById(R.id.et_ProfileInfo_fullNameET);
        profileInfoEmailEt = findViewById(R.id.et_ProfileInfo_emailET);
        profileInfoDobEt = findViewById(R.id.et_ProfileInfo_dobET);
        radioGroup = findViewById(R.id.radioGroup);


        //Firebase Instance
        currentUser = FirebaseAuth.getInstance();
        currentUserID = currentUser.getUid();
        userDB = FirebaseDatabase.getInstance().getReference().child("Users");
        currentUserDB = userDB.child(currentUserID);




        profileInfoContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(profileInfoNameEt.getText().toString().isEmpty())
                    profileInfoNameEt.setError("Field can't be empty");
                else if(profileInfoEmailEt.getText().toString().isEmpty())
                    profileInfoEmailEt.setError("Field can't be empty");
                else if(profileInfoDobEt.getText().toString().isEmpty())
                    profileInfoDobEt.setError("Field can't be empty");
                else if(radioGroup.getCheckedRadioButtonId() == -1) {
                    int lastChildPos=radioGroup.getChildCount()-1;
                    ((RadioButton)radioGroup.getChildAt(lastChildPos)).setError("Your error");
                }
                else {
                    name=profileInfoNameEt.getText().toString();
                    email=profileInfoEmailEt.getText().toString();
                    dateOfBirth=profileInfoDobEt.getText().toString();
                    genderButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                    gender = genderButton.getText().toString();
                    Map userInfo = new HashMap<>();
                    userInfo.put("Name",name);
                    userInfo.put("Gender",gender);
                    userInfo.put("Email",email);
                    userInfo.put("Date Of Birth",dateOfBirth);
                    currentUserDB.updateChildren(userInfo);
                    Intent intent = new Intent(Profile_Info.this, Homepage.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}