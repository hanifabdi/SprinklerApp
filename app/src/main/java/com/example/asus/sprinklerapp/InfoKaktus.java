package com.example.asus.sprinklerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoKaktus extends AppCompatActivity {
    Button btKaktus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_kaktus);
        btKaktus = (Button) findViewById(R.id.btkaktus);
        btKaktus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (InfoKaktus.this, InfoTanaman.class);
                startActivity(i);
            }
        });
    }
}
