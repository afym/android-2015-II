package com.lab02.m02.collections;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.lab02.m02.R;

public class ImagesCollection extends BaseAdapter {
    private Activity activity;
    private int gallery;

    public ImagesCollection(Activity activity, int gallery){
        this.activity = activity;
        this.gallery = gallery;
    }

    @Override
    public int getCount() {
        return this.getImages().length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        imageView = new ImageView(this.activity);
        imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(this.getImages()[position]);

        return imageView;
    }

    private int[] getImages(){
        int[] gallery = null;

        switch (this.gallery){
            case 0:
                gallery =  new int[]{R.drawable.g11,R.drawable.g12,
                        R.drawable.g13, R.drawable.g14};
                break;
            case 1:
                gallery =  new int[]{R.drawable.g21, R.drawable.g23, R.drawable.g24,
                        R.drawable.g25, R.drawable.g26};
        }

        return gallery;
    }
}
