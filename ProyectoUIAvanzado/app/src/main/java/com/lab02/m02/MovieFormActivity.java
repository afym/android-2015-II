package com.lab02.m02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.lab02.m02.collections.MoviesCollection;
import com.lab02.m02.events.MovieOnClick;
import com.lab02.m02.events.MovieSeekBarListener;
import com.lab02.m02.events.MovieSpinnerListener;

public class MovieFormActivity extends AppCompatActivity {
    private Button comprar;
    private Button consultar;
    private SeekBar entradas;
    private TextView entradasResultado;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_form);

        this.buildWidgets();
        this.buildSpinner();
        this.buildSeekBar();
        this.buildButtons();
    }

    public void buildWidgets(){
        this.comprar = (Button)this.findViewById(R.id.boton_comprar);
        this.consultar = (Button)this.findViewById(R.id.boton_consultar);
        this.entradas = (SeekBar)this.findViewById(R.id.entradas_seekbar);
        this.entradasResultado = (TextView)this.findViewById(R.id.pelicula_seekbar_result);
        this.spinner = (Spinner)this.findViewById(R.id.pelicula_spinner);
    }

    public void buildSpinner(){
        int layout = android.R.layout.simple_spinner_item;
        int layoutDrow = android.R.layout.simple_spinner_dropdown_item;
        String[] movies = MoviesCollection.getData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout, movies);
        adapter.setDropDownViewResource(layoutDrow);
        this.spinner.setAdapter(adapter);
        this.spinner.setOnItemSelectedListener(new MovieSpinnerListener(this, movies));
    }

    private void buildSeekBar(){
        MovieSeekBarListener listener = new MovieSeekBarListener(this.entradasResultado);
        this.entradas.setOnSeekBarChangeListener(listener);
    }

    private void buildButtons(){
        this.comprar.setOnClickListener(new MovieOnClick(this));
        this.consultar.setOnClickListener(new MovieOnClick(this));
    }
}
