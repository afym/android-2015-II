package com.lab02.m02.events;

import android.app.ProgressDialog;
import android.os.Handler;

public class MovieActionOne implements Runnable {
    private ProgressDialog progressDialog;
    private Handler handler;
    private static final int SECOND = 1000;
    private int progressStatus;

    public MovieActionOne(ProgressDialog progressDialog){
        this.progressDialog = progressDialog;
        this.handler = new Handler();
        this.progressStatus = 0;
    }

    @Override
    public void run() {
        while(this.progressStatus < 100) {
            this.progressStatus += 10;

            try {
                Thread.sleep(SECOND);
            } catch (Exception e) {
                // Capturar error
            }

            this.handler.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog.setProgress(progressStatus);
                }
            });
        }

        if (this.progressStatus >= 100) {
            this.progressDialog.dismiss();
        }
    }
}
