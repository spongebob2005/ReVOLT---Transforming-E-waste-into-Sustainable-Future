package com.example.revolt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText input_Username2, input_Email_3, editTextPhone, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_Username2 = findViewById(R.id.input_product);
        input_Email_3 = findViewById(R.id.input_Email_3);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);

        Button btn_Register = findViewById(R.id.btn_Register);
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                register();
            }
        });

        // Assuming you have a TextView with the ID "alreadyHaveAccount" in your layout
        // You need to set an OnClickListener for this TextView
        // and open the next activity when clicked
        TextView alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }

    public void OpenMain3(View view){
        startActivity(new Intent(MainActivity.this,MainActivity3.class));
    }
    private void register() {
        String username = input_Username2.getText().toString().trim();
        String email = input_Email_3.getText().toString().trim();
        String phoneNumber = editTextPhone.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (isValidUsername(username) && isValidEmail(email) && isValidPhoneNumber(phoneNumber) && isValidPassword(password)) {
            // Perform registration logic (e.g., send data to a server, save to a database)
            // For now, let's just display a toast message
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,MainActivity3.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid input. Please check the fields.", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isValidUsername(String username) {
        // Validate username (e.g., length check)
        return username.length() >= 4;
    }

    private boolean isValidEmail(CharSequence email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Validate phone number (e.g., length check)
        return phoneNumber.length() >= 10;
    }

    private boolean isValidPassword(String password) {
        // Validate password (e.g., length check)
        return password.length() >= 6;
    }
}

