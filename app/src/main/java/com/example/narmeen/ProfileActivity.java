package com.example.narmeen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST = 0;//a static variable which saves a unique number for the request of the camera
    private static final int GALLERY_REQUEST = 1;//a static variable which saves a unique number for the request of the gallery

    private Button buttonPicture;
    private Button buttonGallery;
    private ImageView imageViewProfile;

    private Bitmap pic;//bitmap is a type of a picture memoriser which is built like
    // a table and saves every pixel as a color in the table
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        buttonPicture = findViewById(R.id.buttonPicture);
        buttonPicture.setOnClickListener(this);
        buttonGallery = findViewById(R.id.buttonGallery);
        buttonGallery.setOnClickListener(this);
        imageViewProfile = findViewById(R.id.imageViewProfile);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonPicture){//checks which button is pressed
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,CAMERA_REQUEST);//calls the camera from the phone
        }else{
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//uri:its like a url
            // for a site that contains all the pictures that user took
            startActivityForResult(i,GALLERY_REQUEST);//calls the memorized photos that the user took
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {//checks if the request was from the camera
            if (resultCode == RESULT_OK) {//checks if the camera request was successful
                pic = (Bitmap) data.getExtras().get("data");//saves the picture data
                imageViewProfile.setImageBitmap(pic);
            }
        } else {//request from gallery
            if (resultCode == RESULT_OK) {//checks if the gallery request was successful
                Uri targetUri = data.getData();//the address that the content provider follows to provide data
                try {
                    //Decode an input stream into a bitmap.
                    pic = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                    //content provider is the main source of data which we can access by content resolver
                    //content resolver is the "client" to get data from the provider
                    imageViewProfile.setImageBitmap(pic);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        //bring xml and put it on the activity
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settingsMenu:
                Toast.makeText(ProfileActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exitMenu:
                //      closeApplication();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
