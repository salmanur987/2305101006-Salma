package com.example.kontenin_modul_3;

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

    // Gambar pic_1 sampai pic_15 dari res/drawable
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
            holder.image = convertView.findViewById(R.id.imageItem);
            holder.label = convertView.findViewById(R.id.labelItem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String label = context.getString(R.string.item_label, position + 1);
        holder.image.setImageResource(images[position]);
        holder.image.setContentDescription(label);
        holder.label.setText(label);

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        TextView label;
    }
}