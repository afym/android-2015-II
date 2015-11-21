package com.lab02.m02.collections;

import com.lab02.m02.R;

import java.util.ArrayList;

public class AlbumListCollection {
    public static String[] getHeaders(){
        return new String[]{"Nombre", "Descripcion"};
    }

    public static int[] getLayoutIds() {
        return new int[]{R.id.album_nombre, R.id.album_descripcion};
    }

    public static ArrayList<String[]> getData(){
        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(new String[]{"1", "Invierno 2015", "Mis fotos de invierno del 2015"});
        data.add(new String[]{"2", "Paisajes", "Paisajes muy hermosos"});

        return data;
    }
}
