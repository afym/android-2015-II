package pe.edu.tecsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    // Definiendo atributos
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Obteniendo el textview
        this.resultado = (TextView)this.findViewById(R.id.textView5);

        Intent intent = this.getIntent();
        String caja1 = intent.getStringExtra("caja1");
        String caja2 = intent.getStringExtra("caja2");

        // Convertir cadena a int
        Integer caja1Int = new Integer(caja1);
        Integer caja2Int = new Integer(caja2);

        // Operar el resultado
        int resultado = caja1Int + caja2Int;

        // Pasando el resultado a cadena
        String miresultado = (new Integer(resultado)).toString();

        this.resultado.setText(miresultado);
    }
}
