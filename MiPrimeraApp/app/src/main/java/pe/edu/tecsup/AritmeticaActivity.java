package pe.edu.tecsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AritmeticaActivity extends AppCompatActivity {
    // Definiendo atributos de mi clase, para mis cajas
    private EditText caja1;
    private EditText caja2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica);
        // Obteniendo cajas
        this.caja1 = (EditText)this.findViewById(R.id.editText);
        this.caja2 = (EditText)this.findViewById(R.id.editText2);
    }

    public void operar(View view){
        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("caja1", this.caja1.getText().toString());
        intent.putExtra("caja2", this.caja2.getText().toString());
        this.startActivity(intent);
    }
}