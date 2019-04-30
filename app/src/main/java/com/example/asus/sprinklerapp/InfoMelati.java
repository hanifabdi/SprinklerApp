package com.example.asus.sprinklerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoMelati extends AppCompatActivity {
    Button btMelati;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_melati);
        btMelati = (Button) findViewById(R.id.btmelati);
        btMelati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (InfoMelati.this, InfoTanaman.class);
                startActivity(i);
            }
        });
    }
}
