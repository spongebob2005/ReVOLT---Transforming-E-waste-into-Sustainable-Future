package com.example.revolt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText input_Email_3,editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        input_Email_3 = findViewById(R.id.input_Email);
        editTextPassword = findViewById(R.id.input_password);

        Button btn_Register1 = findViewById(R.id.btn_login);
        btn_Register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    public void OpenMain(View view){
        startActivity(new Intent(MainActivity2.this,MainActivity.class));
    }
    public void OpenMain3(View view){
        startActivity(new Intent(MainActivity2.this,MainActivity3.class));
    }

    private void login() {
        String email = input_Email_3.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (isValidEmail(email) &&  isValidPassword(password)) {
            // Perform registration logic (e.g., send data to a server, save to a database)
            // For now, let's just display a toast message
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid input. Please check the fields.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidPassword(String password) {
        // Validate password (e.g., length check)
        return password.length() >= 6;
    }
    private boolean isValidEmail(CharSequence email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
