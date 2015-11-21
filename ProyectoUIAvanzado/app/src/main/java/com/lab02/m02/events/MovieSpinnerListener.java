package com.lab02.m02.events;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MovieSpinnerListener implements AdapterView.OnItemSelectedListener {

    private Activity activity;
    private String[] movies;

    public MovieSpinnerListener(Activity activity, String movies[]) {
        this.activity = activity;
        this.movies = movies;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.activity, "Seleccionado " + movies[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
