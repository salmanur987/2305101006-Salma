package com.example.modul_2_kontenin;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private static final int JUMLAH_GAMBAR = 15;
    private static final int KOLOM = 3;
    private static final int PADDING_DP = 16;  // padding kiri/kanan grid
    private static final int SPASI_DP = 8;     // jarak antar kolom

    private final Context context;
    private final int[] gambar = new int[JUMLAH_GAMBAR];
    private final int ukuranSisi;

    public ImageAdapter(Context context) {
        this.context = context;

        // Ambil pic_1 sampai pic_15 dari res/drawable
        for (int i = 0; i < JUMLAH_GAMBAR; i++) {
            gambar[i] = context.getResources().getIdentifier(
                    "pic_" + (i + 1), "drawable", context.getPackageName());
        }

        // Hitung ukuran kotak agar gambar persegi dan pas 3 kolom
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int padding = (int) (PADDING_DP * dm.density);
        int spasi = (int) (SPASI_DP * dm.density);
        ukuranSisi = (dm.widthPixels - (2 * padding) - ((KOLOM - 1) * spasi)) / KOLOM;
    }

    @Override
    public int getCount() {
        return gambar.length;
    }

    @Override
    public Object getItem(int position) {
        return gambar[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new AbsListView.LayoutParams(ukuranSisi, ukuranSisi));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setBackgroundColor(0xFFEDE3E7);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(gambar[position]);
        return imageView;
    }
}