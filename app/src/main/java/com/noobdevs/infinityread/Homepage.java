package com.noobdevs.infinityread;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.noobdevs.infinityread.Model.ModelBookCard;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterBookCard itemAdapter;
    private ArrayList<ModelBookCard> itemList;

    FloatingActionButton floatingActionButton;

    FirebaseAuth currentUser;
    DatabaseReference userDB;
    DatabaseReference bookDB;
    DatabaseReference currentBookDB;
    DatabaseReference currentUserDB;
    String currentUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Firebase Instance
        currentUser = FirebaseAuth.getInstance();
        currentUserID = currentUser.getUid();
        userDB = FirebaseDatabase.getInstance().getReference().child("Users");
        bookDB = FirebaseDatabase.getInstance().getReference().child("Book");
        currentUserDB = userDB.child(currentUserID);

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

        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() , "Add", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext() , Add.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView_BookCard);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        itemList = getAllBooks();//getting books
        itemAdapter = new AdapterBookCard( itemList, Homepage.this);
        itemAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(itemAdapter);
        //preparePaintings();

    }

    private ArrayList<ModelBookCard> getAllBooks() {
        //creating list to store all books
        ArrayList<ModelBookCard> books = new ArrayList<>();

        //reading all  books from book DB
        //using child event listener to get all child keys i.e. book ID
        bookDB.addChildEventListener(new ChildEventListener() {

            ///for every book that is present in DB
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //if snapshot is not null, to avoid exceptions
                if(snapshot.exists()){

                    //reading information of current book
                    String bookName = snapshot.child("Book Name").getValue().toString();
//                    String authorName = snapshot.child("Author Name").getValue().toString();
//                    String description = snapshot.child("Description").getValue().toString();
                    String bookMainPicURL = snapshot.child("Book Main Pic URL").getValue().toString();
                    String ownerID = snapshot.child("Owner ID").getValue().toString();

                    //getting owner name from User DB using owner ID from book information
                    //using single value event listener to get just one particular result using owner ID as key
                    DatabaseReference ownerDB=userDB.child(ownerID);
                    ownerDB.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot ownerSnapshot) {
                            ///if owner is present in owner DB, to  avoid
                            if (ownerSnapshot.exists()) {

                                //getting owner name
                                String ownerName = ownerSnapshot.child(ownerID).child("Name").getValue().toString();

                                //creating book object
                                ModelBookCard book = new ModelBookCard(bookName,
                                        "150",
                                        ownerName,
                                        "4*",
                                        bookMainPicURL,
                                        1
                                );

                                //adding book object to books list
                                books.add(book);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            // Do not Touch
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //returning the list books
        return books;
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