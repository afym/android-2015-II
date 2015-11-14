package pe.edu.tecsup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.util.Log;
import android.widget.Toast;

import com.github.pierry.simpletoast.SimpleToast;


public class ControlesActivity extends AppCompatActivity {
    private RadioButton si;
    private RadioButton no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controles);

        this.si = (RadioButton)this.findViewById(R.id.si);
        this.no = (RadioButton)this.findViewById(R.id.no);
        final ControlesActivity actividad = this;

        Boolean si = this.si.isChecked();
        Boolean no = this.no.isChecked();
        Log.i("SI-CHE", si.toString());
        Log.i("NO-CHE", si.toString());
        Log.i("SI-VAL", this.si.getText().toString());
        Log.i("NO-VAL", this.no.getText().toString());

        this.si.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleToast.muted(actividad, "Una prueba");
                //Toast.makeText(actividad, "Click", Toast.LENGTH_LONG).show();
            }
        });
    }
}