package com.lab02.m02.events;

import android.app.ProgressDialog;

public class MovieActionTwo implements Runnable {
    private ProgressDialog progressDialog;
    private static final int SECOND = 3000;

    public MovieActionTwo(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(SECOND);
        } catch (Exception e) {
            // Capturar error
        }

        this.progressDialog.dismiss();
    }
}
