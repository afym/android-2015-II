package com.lab02.m02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.lab02.m02.collections.AlbumListCollection;
import com.lab02.m02.collections.ImagesCollection;

import java.util.ArrayList;

public class AlbumDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        Intent intent = getIntent();
        int gallery = intent.getIntExtra(AlbumActivity.ALBUM_DETAIL, 0);
        ArrayList<String[]> data = AlbumListCollection.getData();
        this.getSupportActionBar().setTitle(data.get(gallery)[1]);

        GridView gridview = (GridView) findViewById(R.id.fotos);
        gridview.setAdapter(new ImagesCollection(this, gallery));
    }
}