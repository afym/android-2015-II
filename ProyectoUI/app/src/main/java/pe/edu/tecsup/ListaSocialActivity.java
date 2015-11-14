package pe.edu.tecsup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListaSocialActivity extends AppCompatActivity {
    private ListView listaSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_social);
        // Ocultando la barra de acciones
        this.getSupportActionBar().hide();
        // Defino la lista social para mi adaptador
        ListaSocial adapter = new ListaSocial(this, this.obtenerContenidos(), this.obtenerIconos());
        // Obtenego mi lista que esta definida en la lista de sociales
        this.listaSocial = (ListView) findViewById(R.id.sociales);
        this.listaSocial.setAdapter(adapter);
        this.listaSocial.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaSocialActivity.this, "Hiciste click en " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Metodo que devuelve los contenidos para poder poner en las listas
    private String[] obtenerContenidos() {
        return new String[]{
                "Item numero 1",
                "Item numero 2",
                "Item numero 3"
        };
    }

    // Metodo que devuelve los iconos para poder poner en las listas
    private Integer[] obtenerIconos() {
        return new Integer[]{
                R.drawable.music_pop,
                R.drawable.music_rb,
                R.drawable.music_reggea,
        };
    }
}
