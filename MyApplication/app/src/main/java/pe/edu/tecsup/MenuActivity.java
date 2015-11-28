package pe.edu.tecsup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.spinner = (Spinner)this.findViewById(R.id.my_spinner);
        // Creando las opciones
        String[] options = new String[]{"Alta", "Media", "Baja"};
        // Creando el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Agregar adaptador al spinner
        this.spinner.setAdapter(adapter);
        // Capturar el valor del spinner
        long selected = this.spinner.getSelectedItemId();
    }

    // Agregando menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.agregar_2) {
            Toast.makeText(this, "OPCION 2", Toast.LENGTH_LONG).show();
        }

        //Toast.makeText(this, "OPT:" + id, Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
}
