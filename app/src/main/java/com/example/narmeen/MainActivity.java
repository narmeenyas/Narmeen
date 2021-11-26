package com.example.narmeen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, DialogInterface.OnClickListener {

    private static final int NOTIFICATION_REMINDER_NIGHT = 1;//this is for the broadcast receiver

    private EditText editTextName , editTextPassword,editTextTextEmailAddress;
    private Button buttonLogin;
    private Intent musicIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //findViewById returns reference to the object with the specified id
        editTextName= findViewById(R.id.editTextTextPersonName);
        editTextPassword= findViewById(R.id.editTextTextPassword);
        buttonLogin=findViewById(R.id.buttonLogin);
        //sets the required button to response long click, otherwise it won't
        buttonLogin.setOnLongClickListener(this);

        //this will start the service which in turn will start the music
        musicIntent= new Intent(this,MusicService.class);
        startService(musicIntent);

        String name= editTextName.getText().toString();

        SharedPreferences sp = getSharedPreferences("settings",MODE_PRIVATE);
        String email= sp.getString("email","");
        String password= sp.getString("password","");

        if(!email.equals("")&&!password.equals("")){
            editTextName.setText(email);
            editTextPassword.setText(password);
        }

        Intent notifyIntent = new Intent(this,NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 1, pendingIntent);
    }


    public void login(View view) {

        Intent intent = new Intent(this,Welcome.class); // this allows us move to another page(welcome)
        if(!editTextName.getText().toString().equals("")&&
                editTextTextEmailAddress.getText().toString().contains("@"))
            {
            SharedPreferences sp = getSharedPreferences("settings",MODE_PRIVATE);
             //open editor for editing
            SharedPreferences.Editor editor= sp.edit();
            //write the wanted settings
            editor.putString("email",editTextName.getText().toString());
            editor.putString("password",editTextPassword.getText().toString());

            //save and close file
            editor.commit();

            intent.putExtra("name", editTextName.getText().toString());
            startActivity(intent);

        }// this method is inherited which is how we are able to implement it
    }

    public void signup(View view) {
        Intent intent = new Intent(this,SignupActivity.class);
        startActivity(intent);
    }
   //clears the email and password input on long click by user
    @Override
    public boolean onLongClick(View view) {
        editTextName.setText("");
        editTextPassword.setText("");
        return true;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }
    public void onBackPressed(){

    }
}