package com.example.taskmoviesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovie extends AppCompatActivity {

    TextView txtNameAgent, txtDesc;
    String namaAgent, Desk, gambarAgent;
    ImageView imgAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        txtNameAgent = findViewById(R.id.txt_nama);
        txtDesc = findViewById(R.id.txt_desk);
        imgAgent = findViewById(R.id.img_agent);

        Intent intent = getIntent();

        namaAgent = intent.getStringExtra("judul");
        txtNameAgent.setText(namaAgent);

        Desk = intent.getStringExtra("desk");
        txtDesc.setText(Desk);

        gambarAgent = intent.getStringExtra("gambar");
        Glide.with(DetailMovie.this).
                load("https://image.tmdb.org/t/p/w185" + gambarAgent).
                into(imgAgent);

    }
}