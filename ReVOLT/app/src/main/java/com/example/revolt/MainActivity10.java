package com.example.revolt;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.net.URI;

public class MainActivity10 extends AppCompatActivity {

    private EditText FromLocation;
    private EditText ToLocation;
    private Button btnGetDirection;
    private Button submit;
    AutoCompleteTextView auto_view;
    ArrayAdapter aAdapter;
    String[] item={"Green Peace","Navdanya","Aaranyak","Kalpavriksh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        FromLocation = findViewById(R.id.FromLocation);
        ToLocation = findViewById(R.id.ToLocation);
        btnGetDirection = findViewById(R.id.btnGetDirection);
        auto_view = findViewById(R.id.auto_view1);
        submit = findViewById(R.id.submit1);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, item);
        auto_view.setAdapter(aAdapter);

        auto_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity10.this, "Item:" + item, Toast.LENGTH_SHORT).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMainActivity12();
            }
        });

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
    public void OpenMainActivity12(){
        Intent intent=new Intent(this,MainActivity12.class);
        startActivity(intent);
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