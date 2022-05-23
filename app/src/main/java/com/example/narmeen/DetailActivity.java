package com.example.narmeen;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView courseContent, courseTitle;
    private FileHandler fileHandler, fileHandler2;
    private String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        //this is the language that was clicked in the arraylist
        language=ArrayListActivity.list.get(ArrayListActivity.pos).getDescription();

        courseContent = findViewById(R.id.courseContent);

        String name =getIntent().getStringExtra("name");
        loadContentByName(name);

        if(fileHandler != null )
        {
            courseContent.setText(fileHandler.getContent());
        }
    }
    public void loadContentByName(String name){
        if(name.equals("helloCard")&&language.equals("German")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();


            VideoView videoView = findViewById(R.id.video_view1);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.germano;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);

        }else if(name.equals("helloCard")&&language.equals("Spanish")){
            fileHandler = new FileHandler("Spanish", this);
            fileHandler.readFile();

        }else if(name.equals("helloCard")&&language.equals("Turkish")){
            fileHandler = new FileHandler("Turkish", this);
            fileHandler.readFile();

        }else if(name.equals("helloCard")&&language.equals("Italian")){
            fileHandler = new FileHandler("Italian", this);
            fileHandler.readFile();

        }else if(name.equals("helloCard")&&language.equals("French")){
            fileHandler = new FileHandler("French", this);
            fileHandler.readFile();

        }else if(name.equals("helloCard")&&language.equals("Japanese")){
            fileHandler = new FileHandler("Spanish", this);
            fileHandler.readFile();

        }else if(name.equals("helloCard")&&language.equals("Chinese")){
            fileHandler = new FileHandler("Spanish", this);
            fileHandler.readFile();

        } else if(name.equals("helloCard")&&language.equals("Russian")){
            fileHandler = new FileHandler("Russian", this);
            fileHandler.readFile();

        }else if(name.equals("morningCard")&&language.equals("German")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

            VideoView videoView = findViewById(R.id.video_view1);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.germano;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);

        }else if(name.equals("morningCard")&&language.equals("Spanish")){
            fileHandler = new FileHandler("Spanish", this);
            fileHandler.readFile();

        }else if(name.equals("morningCard")&&language.equals("Turkish")){
            fileHandler = new FileHandler("Turkish", this);
            fileHandler.readFile();

        }else if(name.equals("morningCard")&&language.equals("French")){
            fileHandler = new FileHandler("French", this);
            fileHandler.readFile();

        }else if(name.equals("morningCard")&&language.equals("Italian")){
            fileHandler = new FileHandler("Italian", this);
            fileHandler.readFile();

        }else if(name.equals("morningCard")&&language.equals("Russian")){
            fileHandler = new FileHandler("Russian", this);
            fileHandler.readFile();

        }else if(name.equals("morningCard")&&language.equals("Chinese")){
            fileHandler = new FileHandler("Chinese", this);
            fileHandler.readFile();

        }else if(name.equals("morningCard")&&language.equals("Japanese")){
            fileHandler = new FileHandler("Japanese", this);
            fileHandler.readFile();

        }else if(name.equals("chatCard")&& language.equals("German")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

            VideoView videoView = findViewById(R.id.video_view1);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.germano;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);

        }else if(name.equals("chatCard")&& language.equals("Spanish")){
            fileHandler = new FileHandler("Spanish", this);
            fileHandler.readFile();

        }else if(name.equals("chatCard")&& language.equals("Turkish")){
            fileHandler = new FileHandler("Turkish", this);
            fileHandler.readFile();

        }else if(name.equals("chatCard")&& language.equals("Chinese")){
            fileHandler = new FileHandler("Chinese", this);
            fileHandler.readFile();

        }else if(name.equals("chatCard")&& language.equals("Japanese")){
            fileHandler = new FileHandler("Japanese", this);
            fileHandler.readFile();

        }else if(name.equals("chatCard")&& language.equals("French")){
            fileHandler = new FileHandler("French", this);
            fileHandler.readFile();

        }else if(name.equals("chatCard")&& language.equals("Italian")){
            fileHandler = new FileHandler("Italian", this);
            fileHandler.readFile();

        }else if(name.equals("chatCard")&& language.equals("Russian")){
            fileHandler = new FileHandler("Russian", this);
            fileHandler.readFile();

        }else if(name.equals("foodCard")&&language.equals("German")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

            VideoView videoView = findViewById(R.id.video_view1);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.germano;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);

        }else if(name.equals("foodCard")&&language.equals("Spanish")){
            fileHandler = new FileHandler("Spanish", this);
            fileHandler.readFile();

        }else if(name.equals("foodCard")&&language.equals("Turkish")){
            fileHandler = new FileHandler("Turkish", this);
            fileHandler.readFile();

        }else if(name.equals("foodCard")&&language.equals("French")){
            fileHandler = new FileHandler("French", this);
            fileHandler.readFile();

        }else if(name.equals("foodCard")&&language.equals("Italian")){
            fileHandler = new FileHandler("Italian", this);
            fileHandler.readFile();

        }else if(name.equals("foodCard")&&language.equals("Japanese")){
            fileHandler = new FileHandler("Japanese", this);
            fileHandler.readFile();

        }else if(name.equals("foodCard")&&language.equals("Chinese")){
            fileHandler = new FileHandler("Chinese", this);
            fileHandler.readFile();

        }else if(name.equals("foodCard")&&language.equals("Russian")){
            fileHandler = new FileHandler("Russian", this);
            fileHandler.readFile();

        }else if(name.equals("drinksCard")&&language.equals("German")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

            VideoView videoView = findViewById(R.id.video_view1);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.germano;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);

        }else if(name.equals("drinksCard")&&language.equals("Spanish")){
            fileHandler = new FileHandler("Spanish", this);
            fileHandler.readFile();

        }else if(name.equals("drinksCard")&&language.equals("Turkish")){
            fileHandler = new FileHandler("Turkish", this);
            fileHandler.readFile();

        }else if(name.equals("drinksCard")&&language.equals("French")){
            fileHandler = new FileHandler("French", this);
            fileHandler.readFile();

        }else if(name.equals("drinksCard")&&language.equals("Italian")){
            fileHandler = new FileHandler("Italian", this);
            fileHandler.readFile();

        }else if(name.equals("drinksCard")&&language.equals("Russian")){
            fileHandler = new FileHandler("Russian", this);
            fileHandler.readFile();

        }else if(name.equals("drinksCard")&&language.equals("Chinese")){
            fileHandler = new FileHandler("Chinese", this);
            fileHandler.readFile();

        }else if(name.equals("drinksCard")&&language.equals("Japanese")){
            fileHandler = new FileHandler("Japanese", this);
            fileHandler.readFile();

        }else if(name.equals("foodmoreCard")&&language.equals("German")){
            fileHandler = new FileHandler("German", this);
            fileHandler.readFile();

            VideoView videoView = findViewById(R.id.video_view1);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.germano;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);

        }else if(name.equals("foodmoreCard")&&language.equals("Spanish")){
            fileHandler = new FileHandler("Spanish", this);
            fileHandler.readFile();

        }else if(name.equals("foodmoreCard")&&language.equals("French")){
            fileHandler = new FileHandler("French", this);
            fileHandler.readFile();

        }else if(name.equals("foodmoreCard")&&language.equals("Italian")){
            fileHandler = new FileHandler("Italian", this);
            fileHandler.readFile();

        }else if(name.equals("foodmoreCard")&&language.equals("Turkish")){
            fileHandler = new FileHandler("Turkish", this);
            fileHandler.readFile();

        }else if(name.equals("foodmoreCard")&&language.equals("Russian")){
            fileHandler = new FileHandler("Russian", this);
            fileHandler.readFile();

        }else if(name.equals("foodmoreCard")&&language.equals("Chinese")){
            fileHandler = new FileHandler("Chinese", this);
            fileHandler.readFile();

        }else if(name.equals("foodmoreCard")&&language.equals("Japanese")){
            fileHandler = new FileHandler("Japanese", this);
            fileHandler.readFile();

        }
    }
}