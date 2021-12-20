package com.noobdevs.infinityread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.noobdevs.infinityread.Model.ModelBookCard;
import com.noobdevs.infinityread.Model.ModelChatCard;

import java.util.ArrayList;

public class DM extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private AdapterBookChat itemAdapter;
    private ArrayList<ModelChatCard> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm);


        recyclerView = findViewById(R.id.recyclerView_DM);
        itemList = new ArrayList<>();

        itemAdapter = new AdapterBookChat( itemList, DM.this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemAdapter);

        preparePaintings();



    }

    private void preparePaintings() {
        int paintings = R.drawable.profile ;

        ModelChatCard item = new ModelChatCard("Shubham Srivastava"  , "369" ,  paintings);
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