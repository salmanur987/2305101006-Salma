package com.example.kontenin_modul_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

    private final Context context;
    private final LayoutInflater inflater;

    // Gambar dari res/drawable: pic_1 sampai pic_15
    private final int[] images = {
            R.drawable.pic_1, R.drawable.pic_2, R.drawable.pic_3,
            R.drawable.pic_4, R.drawable.pic_5, R.drawable.pic_6,
            R.drawable.pic_7, R.drawable.pic_8, R.drawable.pic_9,
            R.drawable.pic_10, R.drawable.pic_11, R.drawable.pic_12,
            R.drawable.pic_13, R.drawable.pic_14, R.drawable.pic_15
    };

    public ImageAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.relative_layout, parent, false);
            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.img_item);
            holder.label = convertView.findViewById(R.id.tv_label);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.image.setImageResource(images[position]);
        holder.label.setText(context.getString(R.string.foto_label, position + 1));

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        TextView label;
    }
}