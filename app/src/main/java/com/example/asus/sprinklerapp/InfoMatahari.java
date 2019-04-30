package com.example.asus.sprinklerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoMatahari extends AppCompatActivity {
    Button btMatahari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_matahari);
        btMatahari = (Button) findViewById(R.id.btmatahari);
        btMatahari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (InfoMatahari.this, InfoTanaman.class);
                startActivity(i);
            }
        });
    }
}
