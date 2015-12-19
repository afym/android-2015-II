package pe.edu.tecsup.miconsumidorwcf;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

public class TemperaturaAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String HOST = "http://192.168.11.145:23522/";
    private static final String CONTRATO = "Temperatura.svc";
    private String temperatura;
    private String operacion;
    private Activity activity;
    private String  finalResult;

    public TemperaturaAsyncTask(Activity activity, String operacion, String temperatura) {
        this.activity = activity;
        this.operacion = operacion;
        this.temperatura = temperatura;
    }

    @Override
    protected Void doInBackground(Void... params) {
        String url = HOST + CONTRATO + "/" + this.operacion + "/" + this.temperatura;
        Log.i("URL", url);
        String response =  HttpRequest.get(url).body();
        Log.i("BODY:", response);
        // Parse con JSON
        Gson gson = new Gson();
        TemperaturaJSON result = gson.fromJson(response, TemperaturaJSON.class);
        double converion = result.CelsiusToFahrenheitResult;
        this.finalResult = converion + "";
        Log.i("RESULT :", finalResult);

        return null;
    }

    @Override
    protected void onPostExecute(Void Void) {
        EditText resultadoEdit = (EditText)this.activity.findViewById(R.id.salida);
        resultadoEdit.setText(this.finalResult);
    }
}
