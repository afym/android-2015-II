package com.lab02.m02.events;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;

import com.lab02.m02.R;

public class MovieOnClick implements View.OnClickListener {
    private Activity activity;

    public MovieOnClick(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_consultar:
                this.actionOne();
                break;
            case R.id.boton_comprar:
                this.actionTwo();
                break;
        }
    }

    private void actionOne() {
        ProgressDialog progressBar = new ProgressDialog(this.activity);
        progressBar.setCancelable(false);
        String message = this.activity.getResources()
                .getString(R.string.form_consultando);
        progressBar.setMessage(message);
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();

        Thread thread = new Thread(new MovieActionOne(progressBar));
        thread.start();
    }

    private void actionTwo() {
        ProgressDialog progressBar = new ProgressDialog(this.activity);
        progressBar.setCancelable(false);
        String message = this.activity.getResources()
                .getString(R.string.form_comprando);
        progressBar.setMessage(message);
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();

        Thread thread = new Thread(new MovieActionTwo(progressBar));
        thread.start();
    }
}
