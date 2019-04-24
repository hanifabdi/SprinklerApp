package com.example.asus.sprinklerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class Home extends AppCompatActivity {

    private ViewFlipper vf;
    private Animation fadeIn,fadeOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vf = (ViewFlipper)findViewById(R.id.vf);
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        vf.setInAnimation(fadeIn);
        vf.setOutAnimation(fadeOut);
        vf.setAutoStart(true);
        vf.setFlipInterval(5000);
        vf.startFlipping();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night).setTitle("Day Mode");
        }
        else {
            menu.findItem(R.id.night).setTitle("Night Mode");
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            startActivity(new Intent(this, About.class));
        }
        else if (item.getItemId() == R.id.night) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode==AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            Intent i = new Intent (Home.this, Home.class);
            startActivity(i);
        }
        else if (item.getItemId() == R.id.out) {
            startActivity(new Intent(this, Login.class));
        }

        return true;
    }
}
