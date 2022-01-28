package com.example.narmeen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    private static final int NOTIFICATION_REMINDER_NIGHT = 1;//this is for the broadcast receiver


    private Intent musicIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        //this will start the service which in turn will start the music
        musicIntent= new Intent(this,MusicService.class);
        startService(musicIntent);

        Intent notifyIntent = new Intent(this,NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 1, pendingIntent);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
    }
  private BottomNavigationView.OnNavigationItemSelectedListener navListener =
          new BottomNavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                  Fragment selectedFragment = null;
                  switch (item.getItemId()){
                      case R.id.topicsFragment:
                          selectedFragment=new TopicsFragment();
                          break;
                      case R.id.collectionFragment:
                          selectedFragment=new CollectionFragment();
                          break;
                      case R.id.profileFragment:
                          selectedFragment=new ProfileFragment();
                          break;
                      case R.id.premiumFragment:
                          selectedFragment=new PremiumFragment();
                          break;
                  }
                  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                  return true;

              }
          };
}