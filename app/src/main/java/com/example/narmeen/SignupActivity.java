package com.example.narmeen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    private EditText editTextEmailAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        {

        }
    }
}