package com.example.narmeen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView tvFileContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvFileContent = findViewById(R.id.tvFileContent);

        String name =getIntent().getStringExtra("name");
        loadContentByName(name);

    }
    public void loadContentByName(String name){
        if(name.equals("German")){
        }else if(name.equals("Spanish")){

        }
    }
}