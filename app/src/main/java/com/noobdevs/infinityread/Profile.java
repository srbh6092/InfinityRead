package com.noobdevs.infinityread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity
{
    TabLayout tabLayout;
    FragmentAdapter adapter;
    ViewPager2 viewPager2;
    ImageButton exit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tabLayout =  findViewById(R.id.tabLayout_profile);
        viewPager2 = findViewById(R.id.viewPager_Profile);
        exit = findViewById(R.id.exit);

        FragmentManager fragmentManager = getSupportFragmentManager();

        adapter = new FragmentAdapter(fragmentManager , getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.setElevation(8.0f);

        tabLayout.addTab(tabLayout.newTab().setText("Uploads"));
        tabLayout.addTab(tabLayout.newTab().setText("Borrowed"));
        tabLayout.addTab(tabLayout.newTab().setText("WishList"));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Intent intent ;
                switch (item.getItemId()) {
                    case R.id.bottomBar_Home:
                        intent = new Intent(getApplicationContext() , Homepage.class);
                        intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT );
                        startActivity(intent);
                        Toast.makeText(getApplicationContext() , "Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.bottomBar_Chat:
                        Toast.makeText(getApplicationContext() , "Chat", Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext() , DM.class);
                        startActivity(intent);
                        break;

                    case R.id.bottomBar_Notify:
                        Toast.makeText(getApplicationContext() , "Notify", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Profile.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}