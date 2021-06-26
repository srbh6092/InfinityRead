package com.noobdevs.infinityread;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BottomBar extends AppCompatActivity {
    View bottomBar;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_bar);

        bottomBar = findViewById(R.id.bottomAppBar);

        floatingActionButton = findViewById(R.id.floatingActionButton);

    }
}
