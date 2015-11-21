package com.lab02.m02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.lab02.m02.collections.DestinyCollection;
import com.lab02.m02.events.DestinyTextWatcher;

public class SearchFormActivity extends AppCompatActivity {
    private AutoCompleteTextView destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_form);
        this.buildAutoCompleteTextView();
    }

    private void buildAutoCompleteTextView(){
        this.destino = (AutoCompleteTextView)this.findViewById(R.id.destino_auto_complete);
        this.destino.addTextChangedListener(new DestinyTextWatcher());
        // Adapter
        int layout = android.R.layout.simple_dropdown_item_1line;
        String[] destinies = DestinyCollection.getData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout, destinies);
        this.destino.setAdapter(adapter);

    }
}
