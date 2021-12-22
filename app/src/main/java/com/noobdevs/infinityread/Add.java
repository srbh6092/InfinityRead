package com.noobdevs.infinityread;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Add extends AppCompatActivity
{
    String bookName,
            authorName,
            description,
            bookMainPic,
            bookID;

    EditText bookNameET,
            authorNameET,
            descriptionET;

    Button addBookBtn;


    FirebaseAuth currentUser;
    DatabaseReference userDB;
    DatabaseReference bookDB;
    DatabaseReference currentBookDB;
    DatabaseReference currentUserDB;
    String currentUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //UI Fields
        bookNameET = (EditText) findViewById(R.id.book_name);
        authorNameET = (EditText) findViewById(R.id.author_name);
//        descriptionET = (EditText) findViewById(R.id.et_Description);

        //Button
        addBookBtn = (Button) findViewById(R.id.btn_Add_Submit);

        //Firebase Instance
        currentUser = FirebaseAuth.getInstance();
        currentUserID = currentUser.getUid();
        userDB = FirebaseDatabase.getInstance().getReference().child("Users");
        bookDB = FirebaseDatabase.getInstance().getReference().child("Book");
        currentUserDB = userDB.child(currentUserID);

        addBookBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() , "Button Click: Success", Toast.LENGTH_SHORT).show();
                Log.i("AddActivity", "Button clicked: Success");
                getBookInfo();
                addBookToDB();
                addBookToUserBooksDB();
            }
        });

    }

    private void getBookInfo() {
        bookName = bookNameET.getText().toString();
        authorName = authorNameET.getText().toString();
//        description = descriptionET.getText().toString();

        Log.i("AddActivity", "description: "+description);
        bookMainPic = "URL goes here";
    }

    private void addBookToDB() {
        bookID = bookDB.push().getKey(); //creating a book ID
        Log.i("AddActivity", "bookID: "+bookID);
        currentBookDB = bookDB.child(bookID);

        Map bookInfo = new HashMap<>();
        bookInfo.put("Book Name",bookName);
        bookInfo.put("Author Name",authorName);
//        bookInfo.put("Description",description);
        bookInfo.put("Book Main Pic URL",bookMainPic);
        bookInfo.put("Owner ID",currentUserID);
        currentBookDB.updateChildren(bookInfo);
    }

    private void addBookToUserBooksDB() {
        currentUserDB.child("Book").child(bookID).setValue("true");
    }
}