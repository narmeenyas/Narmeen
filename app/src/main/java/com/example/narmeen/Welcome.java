package com.example.narmeen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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


        buttonBack=findViewById(R.id.buttonBack);
        String name=getIntent().getStringExtra("name");


    }



    public void transition(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    public void movetoIntro(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}