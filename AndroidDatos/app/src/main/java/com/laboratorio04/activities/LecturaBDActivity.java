package com.laboratorio04.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.laboratorio04.R;
import com.laboratorio04.modelo.Cuenta;
import com.laboratorio04.modelo.CuentaDAO;
import com.laboratorio04.modelo.DAOException;

public class LecturaBDActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectura_bd);
    }

    @Override
    protected void onStart(){
        super.onStart();
        this.leerCuenta();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lectura_bd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void leerCuenta(){
        CuentaDAO dao = new CuentaDAO(getBaseContext());
        Cuenta cuenta;

        try {
            cuenta = dao.obtener();
            TextView correo = (TextView)findViewById(R.id.tvCorreo);
            correo.setText("Bienvenido " + cuenta.getCorreo());
        }catch (DAOException e) {
            Toast.makeText(this, "Ocurrio un error : " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

}
