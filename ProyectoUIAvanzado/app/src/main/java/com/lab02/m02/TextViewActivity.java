package com.lab02.m02;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewActivity extends AppCompatActivity {
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        this.textView = (TextView)this.findViewById(R.id.another_text);
        textView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(TextViewActivity.this, "Click", Toast.LENGTH_SHORT).show();

                textView.setText("Estudia en : http://tecsup.edu.pe");

                if(textView.getLinksClickable() == true) {
                    textView.setLinkTextColor(Color.BLUE);
                }
            }
        });
    }
}
