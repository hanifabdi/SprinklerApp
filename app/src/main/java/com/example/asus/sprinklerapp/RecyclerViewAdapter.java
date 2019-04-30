package com.example.asus.sprinklerapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> rvDataJudul;
    private ArrayList<Integer> rvDataGambar;

    RecyclerViewAdapter(ArrayList<String> rvDataJudul, ArrayList<Integer> rvDataGambar){
        this.rvDataJudul = rvDataJudul;
        this.rvDataGambar = rvDataGambar;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiap item
        private TextView Judul, Deskripsi;
        private ImageView Icon;
        private CardView cvMain;
        private Context context;

        ViewHolder(View v) {
            super(v);
            //Untuk Menghubungkan dan Mendapakan Context dari MainActivity
            context = v.getContext();
            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            Judul = (TextView) v.findViewById(R.id.judul);
            Deskripsi = (TextView) v.findViewById(R.id.desk);
            Icon = v.findViewById(R.id.icon);
            cvMain = v.findViewById(R.id.cv_main);
            cvMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0 :
                            intent = new Intent(context, InfoMawar.class);
                            break;
                        case 1 :
                            intent = new Intent(context, InfoCabai.class);
                            break;
                        case 2 :
                            intent = new Intent(context, InfoTomat.class);
                            break;
                        case 3 :
                            intent = new Intent(context, InfoAnggrek.class);
                            break;
                        case 4 :
                            intent = new Intent(context, InfoMelati.class);
                            break;
                        case 5 :
                            intent = new Intent(context, InfoKaktus.class);
                            break;
                        case 6 :
                            intent = new Intent(context, InfoMatahari.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
        final String Nama = rvDataJudul.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan
        holder.Judul.setText(rvDataJudul.get(position));
        holder.Deskripsi.setText("Lihat Info..");
        holder.Icon.setImageResource(rvDataGambar.get(position)); // Mengambil gambar sesuai posisi yang telah ditentukan

    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvDataJudul.size();
    }
}