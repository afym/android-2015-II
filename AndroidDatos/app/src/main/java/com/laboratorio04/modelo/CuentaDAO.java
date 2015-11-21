package com.laboratorio04.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CuentaDAO {
    private DBHelper dbHelper;

    public CuentaDAO(Context context){
        this.dbHelper = new DBHelper(context);
    }

    public void insertar(String correo, String clave) throws DAOException {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();

        try {
            String[] args = new String[]{correo, clave};
            db.execSQL("INSERT INTO cuenta(correo, clave) VALUES(?, ?);", args);
        } catch (Exception e){
            throw new DAOException("CuentaDAO: Error al insertar" + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public Cuenta obtener() throws DAOException {
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();
        Cuenta modelo = new Cuenta();

        try {
            Cursor c = db.rawQuery("SELECT id, correo, clave FROM cuenta", null);
            if (c.getCount() > 0) {
                c.moveToFirst();
            }

            do {
                int id = c.getInt(c.getColumnIndex("id"));
                String correo = c.getString(c.getColumnIndex("correo"));
                String clave = c.getString(c.getColumnIndex("clave"));

                modelo.setId(id);
                modelo.setCorreo(correo);
                modelo.setClave(clave);
            } while(c.moveToNext());

        } catch (Exception e) {
            throw  new DAOException("Cuenta DAO: Error al obtener :" + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }

        return modelo;
    }

    public void eliminar(int id) throws DAOException {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();

        try {
            String[] args = new String[]{String.valueOf(id)};
            db.execSQL("DELETE FROM cuenta WHERE id = ?", args);
        } catch (Exception e) {
            throw new DAOException("CuentaDAO : Error al eliminar :" + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public void eliminarTodos() throws DAOException {
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM cuenta");
        } catch (Exception e) {
            throw new DAOException("CuentaDAO: Error al eliminar todos : " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }
}
