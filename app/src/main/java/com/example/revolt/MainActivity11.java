package com.example.revolt;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class MainActivity11 extends AppCompatActivity {

    private EditText FromLocation;
    private EditText ToLocation;
    private Button btnGetDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        FromLocation = findViewById(R.id.FromLocation);
        ToLocation = findViewById(R.id.ToLocation);
        btnGetDirection = findViewById(R.id.btnGetDirection);

        btnGetDirection.setOnClickListener(view -> {
            String userlocation = FromLocation.getText().toString();
            String userDestination = ToLocation.getText().toString();

            if (userDestination.equals("") || userDestination.equals("")){
                Toast.makeText(this, "Please enter your location & destination", Toast.LENGTH_SHORT).show();
            } else {
                getDirections(userlocation, userDestination);
            }
        });
    }

    private void getDirections(String from,String to){
        try{
            Uri uri = Uri.parse("https://www.google.com/maps/dir/"+ from + "/" + to);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException exception){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps&hl=en&gl=US&pli=1");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}