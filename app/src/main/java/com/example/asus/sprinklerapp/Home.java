package com.example.asus.sprinklerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home extends AppCompatActivity {

    private ViewFlipper vf;
    private Animation fadeIn,fadeOut;
    ImageView data,history,kalender,tanam,atur,pandu;
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
        tanam = (ImageView) findViewById(R.id.tanam);
        data = (ImageView) findViewById(R.id.data);
        history = (ImageView) findViewById(R.id.history);
        kalender = (ImageView) findViewById(R.id.kalender);
        atur = (ImageView) findViewById(R.id.atur);
        pandu = (ImageView) findViewById(R.id.pandu);
        tanam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Home.this, InfoTanaman.class);
                startActivity(i);
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Home.this, Data.class);
                startActivity(i);
            }
        });

        atur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Home.this, Pengaturan.class);
                startActivity(i);
            }
        });
        pandu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Home.this, Panduan.class);
                startActivity(i);
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Keluar dari aplikasi?");

        // set pesan dari dialog
        alertDialogBuilder
                .setIcon(R.drawable.alert)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        Home.this.finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            startActivity(new Intent(this, About.class));
        }

        else if (item.getItemId() == R.id.out) {
            showDialog();
        }

        return true;
    }
}
