package com.noobdevs.infinityread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity
{
    FirebaseAuth.AuthStateListener authStateListener ;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
            }
        };

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user != null)
                {
                    Toast.makeText(MainActivity.this, "Ye hua", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this , Homepage.class );
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, SignIn.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 4000 );


    }

}