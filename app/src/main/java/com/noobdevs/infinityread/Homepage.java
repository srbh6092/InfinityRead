package com.noobdevs.infinityread;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.noobdevs.infinityread.Model.ModelBookCard;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterBookCard itemAdapter;
    private ArrayList<ModelBookCard> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Intent intent ;
                switch (item.getItemId()) {
                    case R.id.bottomBar_Chat:
                        Toast.makeText(getApplicationContext() , "Chat", Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext() , DM.class);
                        startActivity(intent);
                        break;
                    case R.id.bottomBar_Notify:
                        Toast.makeText(getApplicationContext() , "Notify", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottomBar_Profile:
                        Toast.makeText(getApplicationContext() , "Profile", Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext() , Profile.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        recyclerView = findViewById(R.id.recyclerView_BookCard);
        itemList = new ArrayList<>();
        itemAdapter = new AdapterBookCard( itemList, Homepage.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemAdapter);
        preparePaintings();



    }

    private void preparePaintings() {
        int paintings = R.drawable.profile ;

        ModelBookCard item = new ModelBookCard("Inferno" , "369" , "Shubham Srivastava" , "****" , "12+ Pics" , paintings);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemAdapter.notifyDataSetChanged();
    }
}