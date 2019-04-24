package com.example.asus.sprinklerapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DBHelper db;
    private Button b1;
    private EditText e1;
    private EditText e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DBHelper(this);
        e1 = (EditText) findViewById(R.id.etEmailr);
        e2 = (EditText) findViewById(R.id.etPassr);
        b1 = (Button) findViewById(R.id.btregis);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = e1.getText().toString();
                String a2 = e2.getText().toString();
                if (a1.equals("")||a2.equals("")){
                    Toast.makeText(getApplicationContext(),"Username/Password Kosong!",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean cekemail = db.cekemail(a1);
                    if (cekemail==true){
                        boolean insert = db.insert(a1,a2);
                        if (insert==true){
                            Toast.makeText(getApplicationContext(),"Registrasi Berhasil",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent (Register.this, Login.class);
                            startActivity(i);
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Email Telah Digunakan!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
