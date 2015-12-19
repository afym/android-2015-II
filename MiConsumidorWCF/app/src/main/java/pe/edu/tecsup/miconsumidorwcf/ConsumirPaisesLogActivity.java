package pe.edu.tecsup.miconsumidorwcf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConsumirPaisesLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumir_paises_log);

        PaisesAsyncTask paisesAsyncTask = new PaisesAsyncTask();
        paisesAsyncTask.execute();
    }
}
