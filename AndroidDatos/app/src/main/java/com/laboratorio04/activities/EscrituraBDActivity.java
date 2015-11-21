package com.laboratorio04.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.laboratorio04.R;
import com.laboratorio04.modelo.CuentaDAO;
import com.laboratorio04.modelo.DAOException;

public class EscrituraBDActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escritura_bd);
        ActionBar actionBar = getActionBar();
        int colorDrawable = getResources().getColor(R.color.naranja);
        actionBar.setBackgroundDrawable(new ColorDrawable(colorDrawable));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_escritura_bd, menu);
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

    public void guardar(View view) {
        EditText correo = (EditText)findViewById(R.id.txtCorreo);
        EditText clave = (EditText)findViewById(R.id.txtClave);

        CuentaDAO dao = new CuentaDAO(getBaseContext());

        try {
            dao.eliminarTodos();
            dao.insertar(correo.getText().toString(), clave.getText().toString());
            Toast.makeText(this, "Se inserto correctamente", Toast.LENGTH_LONG).show();
        } catch (DAOException e) {
            Toast.makeText(this, " Error : ".concat(e.getMessage()),Toast.LENGTH_SHORT).show();
        }

    }

    public void continuar(View view){
        Intent intent = new Intent(this, LecturaBDActivity.class);
        startActivity(intent);
    }
}