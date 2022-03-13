package com.example.narmeen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ArrayListActivity extends AppCompatActivity  {
    //the object of the view - design
    private ListView myListView;
    //the object for the adapter connecting the data to the view
    private CustomAdapter myAdapter;
    //object containing the items to be displayed - Data
    private ArrayList<Item> list;
    private FirebaseAuth maFirebaseAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase database= FirebaseDatabase.getInstance("https://narmeen-730a9-default-rtdb.europe-west1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        getSupportActionBar().hide();


        String UID = maFirebaseAuth.getUid();
        Toast.makeText(this, "UID:"+UID, Toast.LENGTH_LONG);
        //build reference fo user related data in real time database suing user ID
        DatabaseReference myRef = database.getReference("users/"+UID);


        //adds an item to the FB under the reference specified
        //TODO change this into the object you need to use (reminder / appointment)
        //TODO alter the code so the data is uploaded to the firebase only when the user clicks the button
        //myRef.push().setValue(new Item(2,true,"this is my first item",R.id.imageItem));

        list=new ArrayList<>();

        list.add(new Item("Spanish",R.drawable.ss));
        list.add(new Item("Italian",R.drawable.italian));
        list.add(new Item("German",R.drawable.german));
        list.add(new Item("French",R.drawable.french));
        list.add(new Item("Chinese",R.drawable.chinese));
        list.add(new Item("Japanese",R.drawable.japanese));
        list.add(new Item("Russian",R.drawable.russian));
        list.add(new Item("Turkish",R.drawable.turkish));

        //reference to the list view so it can be programmed
        myListView=findViewById(R.id.myListView);

        myListView.setDivider(null);

        //connect adapter with data
        myAdapter=new CustomAdapter(this,R.layout.item_row,list);

        //connect adapter with view
        myListView.setAdapter(myAdapter);

        //connects click listener to items in the list
        //when you click the item it shows the values that it has
        //change this to redirect to main page

       myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             // Toast.makeText(getApplicationContext(),"Item:"+list.get(i),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ArrayListActivity.this,MainActivity.class);
                intent.putExtra("id",list.get(i).getDescription()); //this is what language was chosen
                startActivity(intent);
            }
        });


    }
}