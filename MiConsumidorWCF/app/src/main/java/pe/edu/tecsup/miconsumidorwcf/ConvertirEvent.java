package pe.edu.tecsup.miconsumidorwcf;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ConvertirEvent implements View.OnClickListener {
    private EditText entrada;
    private EditText salida;
    private RadioGroup conversores;
    private Activity activity;

    public ConvertirEvent(Activity activity, EditText entrada, EditText salida, RadioGroup conversores) {
        this.activity = activity;
        this.entrada = entrada;
        this.salida = salida;
        this.conversores = conversores;
    }

    @Override
    public void onClick(View v) {
        Log.i("ONLICK", "OK");
        int opcion = this.conversores.getCheckedRadioButtonId();
        String operacion = "CelsiusToFahrenheit";

        switch (opcion) {
            case R.id.t1:
                operacion = "CelsiusToFahrenheit";
                break;
            case R.id.t2:
                operacion = "FahrenheitToCelsius";
                break;
            case R.id.t3:
                operacion = "CelsiusToKelvin";
                break;
        }

        Log.i("ONLICK", operacion);
        Log.i("ENTRADA", this.entrada.getText().toString());

        TemperaturaAsyncTask temp = new TemperaturaAsyncTask(this.activity, operacion, this.entrada.getText().toString());
        temp.execute();
    }
}
