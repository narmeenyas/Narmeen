package com.example.narmeen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

  //  Item item= new Item();

    private FileHandler fileHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

      //  String description = item.getDescription();

        String name =getIntent().getStringExtra("name");
        loadContentByName(name);

    }
    //in the onclick in the main it sends the value of the card to this page(name)
    //the extra intent is what moves the values from activities
    //we need to also get the description which is the language name from the list
    //which makes 6 categories for each language

    public void loadContentByName(String name){
        if(name.equals("helloCard")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

        }else if(name.equals("morningCard")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

        }else if(name.equals("chatCard")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

        }else if(name.equals("foodCard")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

        }else if(name.equals("drinksCard")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

        }else if(name.equals("foodmoreCard")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

        }
    }
}