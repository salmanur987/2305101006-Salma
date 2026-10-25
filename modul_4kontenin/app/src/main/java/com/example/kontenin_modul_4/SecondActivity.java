package com.example.kontenin_modul_4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_PESAN = "extra_pesan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Tombol panah kembali di action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Tampilkan pesan dari MainActivity (jika ada)
        String pesan = getIntent().getStringExtra(EXTRA_PESAN);
        if (pesan != null) {
            TextView tvPesan = findViewById(R.id.tv_pesan);
            tvPesan.setText(pesan);
        }

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());
    }
}