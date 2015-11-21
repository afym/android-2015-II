package com.lab02.m02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
    }

    public void onClick1(View view){
        Toast.makeText(this, "onclick 1", Toast.LENGTH_LONG).show();
    }

    public void onClick2(View view){
        Toast.makeText(this, "onclick 2", Toast.LENGTH_LONG).show();
    }

    public void onClick3(View view){
        Toast.makeText(this, "onclick 3", Toast.LENGTH_LONG).show();
    }
}
