package com.example.asus.sprinklerapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private TextView pindah;
    DBHelper db;
    private Button c1;
    private EditText d1;
    private EditText d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pindah = (TextView) findViewById(R.id.pindah);
        db = new DBHelper(this);
        d1 = (EditText) findViewById(R.id.etEmail);
        d2 = (EditText) findViewById(R.id.etPass);
        c1 = (Button) findViewById(R.id.btlogin);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f1 = d1.getText().toString();
                String f2 = d2.getText().toString();
                if (f1.equals("")||f2.equals("")){
                    Toast.makeText(getApplicationContext(),"Username/Password Kosong!",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean ceklogin = db.ceklogin(f1,f2);
                    if (ceklogin==true){
                            Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent (Login.this, Home.class);
                            startActivity(i);
                        }
                    else {
                        Toast.makeText(getApplicationContext(),"Username/Password Salah!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Login.this, Register.class);
                startActivity(i);
            }
        });
    }
}