package com.example.asus.sprinklerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoMawar extends AppCompatActivity {
    Button btMawar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_mawar);
        btMawar = (Button) findViewById(R.id.btmawar);
        btMawar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (InfoMawar.this, InfoTanaman.class);
                startActivity(i);
            }
        });
    }
}
