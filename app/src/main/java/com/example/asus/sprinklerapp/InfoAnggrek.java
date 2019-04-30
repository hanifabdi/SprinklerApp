package com.example.asus.sprinklerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoAnggrek extends AppCompatActivity {
    Button btAnggrek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_anggrek);
        btAnggrek = (Button) findViewById(R.id.btanggrek);
        btAnggrek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (InfoAnggrek.this, InfoTanaman.class);
                startActivity(i);
            }
        });
    }
}
