package com.lab02.m02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.ExpandableListView;

import com.lab02.m02.collections.ItemCollection;
import com.lab02.m02.collections.MenuCollection;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private SparseArray<ItemCollection> grupos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.initSparseArray();
        this.buildData();

        ExpandableListView expandList = (ExpandableListView) findViewById(R.id.menu);
        MenuCollection adapter = new MenuCollection(this, grupos);
        expandList.setAdapter(adapter);
    }

    private void initSparseArray(){
        this.grupos = new SparseArray<ItemCollection>();
    }

    public void buildData() {
        ItemCollection prendas = new ItemCollection("Prendas");
        ArrayList<String> prendasItems = new ArrayList<String>();
        prendasItems.add("Camsisas");
        prendasItems.add("Polos");
        prendasItems.add("Pantalones");
        prendas.setSubItems(prendasItems);

        this.grupos.append(0, prendas);

        ItemCollection electrico = new ItemCollection("Electricos");
        ArrayList<String> electricoItems = new ArrayList<String>();
        electricoItems.add("Televisores");
        electricoItems.add("Radios");
        electricoItems.add("Computadoras");
        electrico.setSubItems(electricoItems);

        this.grupos.append(1, electrico);

        ItemCollection juguetes = new ItemCollection("Juguetes");
        ArrayList<String> juguetesItems = new ArrayList<String>();
        juguetesItems.add("Para niños");
        juguetesItems.add("Para niñas");
        juguetesItems.add("Para jovenes");
        juguetes.setSubItems(juguetesItems);

        this.grupos.append(2, juguetes);
    }
}
