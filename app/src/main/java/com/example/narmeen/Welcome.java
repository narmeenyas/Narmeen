package com.example.narmeen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends AppCompatActivity {
    private EditText editTextTextPersonName2;
    private Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        editTextTextPersonName2= findViewById(R.id.editTextTextPersonName2);
        buttonBack=findViewById(R.id.buttonBack);

        String name=getIntent().getStringExtra("name");
        editTextTextPersonName2.setText("Welcome "+ ""+name);

    }

    public void back(View view) {
        Intent intent = new Intent(this,MainActivity.class); // this allows us move to another page
        startActivity(intent);
    }
}