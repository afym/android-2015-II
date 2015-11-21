package pe.edu.tecsup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import pe.edu.tecsup.R;
import pe.edu.tecsup.events.MainOnClickEvent;
import pe.edu.tecsup.events.MenuOnClickEvent;
import pe.edu.tecsup.model.MenuAdapaterModel;
import pe.edu.tecsup.model.MenuStaticModel;

public class MenuActivity extends AppCompatActivity {
    private TextView welcome;
    private ListView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.init();
    }

    protected void onStart(){
        super.onStart();
        this.listenMainActivity();
    }

    // Metodo que inicia los controles
    private void init() {
        this.welcome = (TextView)this.findViewById(R.id.welcome);
        this.initListView();
    }

    // Metodo para iniciar la lista
    private void initListView() {
        // Obtengo los datos que estan en otra clase
        String[] texts = MenuStaticModel.getText();
        Integer[] icons = MenuStaticModel.getIcons();
        // Defino la lista social para mi adaptador (se carga la informacion estatica o bruta)
        MenuAdapaterModel adapterModel = new MenuAdapaterModel(this, texts, icons);
        // Obtenego mi lista que esta definida en la lista de sociales
        this.menu = (ListView) findViewById(R.id.menu);
        this.menu.setAdapter(adapterModel);
        this.menu.setOnItemClickListener(new MenuOnClickEvent(this));
    }

    // Metodo que escucha el intento de la actividad MainActivity
    private void listenMainActivity(){
        Intent intent = this.getIntent();
        String name = intent.getStringExtra(MainOnClickEvent.USER_NAME);
        String welcomeText = this.getResources().getString(R.string.menu_welcome).toString();
        welcomeText = welcomeText.replace("{name}", name);
        this.welcome.setText(welcomeText);
    }
}
