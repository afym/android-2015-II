package com.lab02.m02.events;

import android.widget.SeekBar;
import android.widget.TextView;

public class MovieSeekBarListener implements SeekBar.OnSeekBarChangeListener {
    private TextView seekBarResult;

    public MovieSeekBarListener(TextView seekBarResult){
        this.seekBarResult = seekBarResult;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.seekBarResult.setText("Entradas : " + progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
