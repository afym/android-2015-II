package pe.edu.tecsup.miconsumidorwcf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ConversorActivity extends AppCompatActivity {
    private EditText entrada;
    private EditText salida;
    private Button convertir;
    private RadioGroup conversores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);
        this.initUI();
        ConvertirEvent e = new ConvertirEvent(this, this.entrada, this.salida, this.conversores);
        this.convertir.setOnClickListener(e);
    }

    private void initUI()
    {
        this.entrada = (EditText)this.findViewById(R.id.entrada);
        this.salida = (EditText)this.findViewById(R.id.salida);
        this.convertir = (Button)this.findViewById(R.id.convertir);
        this.conversores = (RadioGroup)this.findViewById(R.id.conversores);
    }
}