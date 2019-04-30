package com.example.asus.sprinklerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class InfoTanaman extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> Judul;
    private ArrayList<Integer> Icon;
    //Daftar Judul
    private String[] ListJudul = {"Bunga Mawar", "Tanaman Cabai", "Tanaman tomat", "Bunga Anggrek", "Bunga Melati", "Tanaman Kaktus", "Bunga Matahari"};
    //Daftar Gambar
    private int[] ListGambar = {R.drawable.mawar1, R.drawable.cabai1, R.drawable.tomat1, R.drawable.anggrek1, R.drawable.melati1, R.drawable.kaktus1, R.drawable.matahari1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tanaman);
        Judul = new ArrayList<>();
        Icon = new ArrayList<>();
        recyclerView = findViewById(R.id.rview);
        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new RecyclerViewAdapter(Judul, Icon);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
    }
    private void DaftarItem() {
        for (int w = 0; w < ListJudul.length ; w++) {
            Icon.add(ListGambar[w]);
            Judul.add(ListJudul[w]);
        }
    }
}
