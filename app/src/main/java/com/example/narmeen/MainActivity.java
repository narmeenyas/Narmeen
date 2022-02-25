package com.example.narmeen;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    private static final int NOTIFICATION_REMINDER_NIGHT = 1;//this is for the broadcast receiver

    private Intent musicIntent;
    private CardView helloCard,morningCard, basicCard,foodCard,drinksCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        basicCard = findViewById(R.id.basicCard);
        helloCard = findViewById(R.id.helloCard);


        //this will start the service which in turn will start the music
        musicIntent= new Intent(this,MusicService.class);
        startService(musicIntent);

        Intent notifyIntent = new Intent(this,NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 1, pendingIntent);

  // navigation bar code below (functional)
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CoursesFragment()).commit();

    /*    helloCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,DetailActivity.class);
                i.putExtra("name","Spanish");
                startActivity(i);
            }
        });

     */

    }
  private BottomNavigationView.OnNavigationItemSelectedListener navListener =
          new BottomNavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                  Fragment selectedFragment = null;
                  switch (item.getItemId()){
                      case R.id.nav_courses:
                          selectedFragment=new CoursesFragment();
                          break;
                      case R.id.nav_extra:
                          selectedFragment=new ExtraFragment();
                          break;
                      case R.id.nav_profiles:
                          selectedFragment=new ProfilesFragment();
                          break;
                      case R.id.nav_premiu:
                          selectedFragment=new PremiuFragment();
                          break;
                  }
                  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                  return true;

              }
          };
    //see the quiz video resource 13:11 - this makes the option chosen highlighted which could be useful in
    //multiple answer questions
}