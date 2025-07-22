package com.example.revolt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void OpenMain4(View view){
        startActivity(new Intent(MainActivity3.this,MainActivity4.class));
    }
    public void OpenMain5(View view){
        startActivity(new Intent(MainActivity3.this,MainActivity5.class));
    }
    public void OpenMain6(View view){
        startActivity(new Intent(MainActivity3.this,MainActivity6.class));
    }
    public void OpenMain7(View view){
        startActivity(new Intent(MainActivity3.this,MainActivity7.class));
    }
    public void OpenMain8(View view){
        startActivity(new Intent(MainActivity3.this,MainActivity8.class));
    }
    public void OpenMain9(View view){
        startActivity(new Intent(MainActivity3.this,MainActivity9.class));
    }
}