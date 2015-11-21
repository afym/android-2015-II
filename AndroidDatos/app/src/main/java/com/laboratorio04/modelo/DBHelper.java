package com.laboratorio04.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context){
        super(context, "municipalidad.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.getCreateQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(this.getDropQuery());
        this.onCreate(db);
    }

    // Separando metodos para crear cadenas SQLite

    private String getCreateQuery() {
        return "CREATE TABLE IF NOT EXISTS cuenta (id " +
                "INTEGER PRIMARY KEY AUTOINCREMENT, correo TEXT NOT " +
                "NULL, clave TEXT NOT NULL);";
    }

    private String getDropQuery(){
        return "DROP TABLE IF EXISTS cuenta;";
    }
}

