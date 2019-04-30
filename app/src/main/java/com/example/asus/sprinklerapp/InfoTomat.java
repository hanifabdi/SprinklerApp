package com.example.asus.sprinklerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoTomat extends AppCompatActivity {
    Button btTomat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tomat);
        btTomat = (Button) findViewById(R.id.bttomat);
        btTomat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (InfoTomat.this, InfoTanaman.class);
                startActivity(i);
            }
        });
    }
}
