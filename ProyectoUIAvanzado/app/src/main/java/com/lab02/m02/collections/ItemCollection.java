package com.lab02.m02.collections;

import java.util.ArrayList;

public class ItemCollection{
    private String titulo;
    private ArrayList<String> subItems;

    public ItemCollection(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getSubItems() {
        return subItems;
    }

    public void setSubItems(ArrayList<String> subItems) {
        this.subItems = subItems;
    }
}
