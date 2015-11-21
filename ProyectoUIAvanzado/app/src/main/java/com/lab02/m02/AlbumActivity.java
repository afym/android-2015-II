package com.lab02.m02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.lab02.m02.collections.AlbumListCollection;

import java.util.ArrayList;
import java.util.HashMap;

public class AlbumActivity extends AppCompatActivity {
    public static final String ALBUM_DETAIL = "GALLERY_POSITION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        this.buildList();
    }

    private void buildList(){
        ArrayList<String[]> items = AlbumListCollection.getData();
        String[] header = AlbumListCollection.getHeaders();
        int[] ids = AlbumListCollection.getLayoutIds();
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();

        for (String[] item : items) {
            HashMap<String, String> listItem = new HashMap<String, String>();
            listItem.put("id", item[0]);
            listItem.put(header[0], item[1]);
            listItem.put(header[1], item[2]);
            data.add(listItem);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.album_list, header, ids);

        ListView listView = (ListView) findViewById(R.id.galerias);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AlbumActivity.this, AlbumDetailActivity.class);
                intent.putExtra(ALBUM_DETAIL, position);
                startActivity(intent);
            }
        });
    }
}
