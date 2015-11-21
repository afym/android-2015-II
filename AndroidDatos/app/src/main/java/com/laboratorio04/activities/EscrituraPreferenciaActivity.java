package com.laboratorio04.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.laboratorio04.R;

public class EscrituraPreferenciaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escritura_preferencia);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_escritura_preferencia, menu);
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

    public void guardarPreferencia(View view){
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        SharedPreferences preferences = getSharedPreferences("PREFERENCIAS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("CADENA", editText1.getText().toString());
        editor.commit();

        Toast.makeText(this, "Dato grabado con shared ...", Toast.LENGTH_SHORT).show();
    }

    public void continuar(View view){
        Intent intent = new Intent(this, LeerPreferenciaActivity.class);
        startActivity(intent);
    }
}