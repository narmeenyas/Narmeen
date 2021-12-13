package com.example.narmeen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        list.add(new Item("my first item",R.drawable.img,true,50));
        list.add(new Item("idk",R.drawable.img,true,34));
        list.add(new Item("this is supposed to be a string",R.drawable.img,true,74));
        list.add(new Item("weeeeee",R.drawable.img,true,21));

        //reference to the list view so it can be programmed
        myListView=findViewById(R.id.myListView);

        //connect adapter with data
        myAdapter=new CustomAdapter(this,R.layout.item_row,list);

        //connect adapter with view
        myListView.setAdapter(myAdapter);
        //connects click listener to items in the list

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Item:"+list.get(i),Toast.LENGTH_LONG).show();
            }
        });
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                myAdapter.notifyDataSetChanged();
                return false;

            }
        });
    }
}