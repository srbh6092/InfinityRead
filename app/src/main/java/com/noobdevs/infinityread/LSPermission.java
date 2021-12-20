package com.noobdevs.infinityread;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LSPermission extends AppCompatActivity {
    Button allowButton;
    private final int LOCATION_PERMISSION_CODE = 100;
    private final int STORAGE_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        allowButton = findViewById(R.id.allowbutton);

        allowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean location = checkPermission(Manifest.permission.ACCESS_FINE_LOCATION ,  LOCATION_PERMISSION_CODE);
                boolean storage  = checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE ,  STORAGE_PERMISSION_CODE);
                if(location==true && storage==true) {
                    Intent intent = new Intent(LSPermission.this, Profile_Info.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        boolean location = checkPermission(Manifest.permission.ACCESS_FINE_LOCATION ,  LOCATION_PERMISSION_CODE);
        boolean storage  = checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE ,  STORAGE_PERMISSION_CODE);
        if(location==true && storage==true) {
            Intent intent = new Intent(LSPermission.this, Profile_Info.class);
            startActivity(intent);
            finish();
        }
    }

    public boolean checkPermission(String permission, int requestCode)
        {
           if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {

                // Requesting the permission
                ActivityCompat.requestPermissions(this, new String[] { permission }, requestCode);
                return false;
           }
            else {
                return true;
                 }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
