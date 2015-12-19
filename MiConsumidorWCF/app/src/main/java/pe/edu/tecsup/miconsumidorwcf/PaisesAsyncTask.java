package pe.edu.tecsup.miconsumidorwcf;

import android.os.AsyncTask;
import android.util.Log;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

import java.util.List;

import pe.edu.tecsup.miconsumidorwcf.json.PaisGson;

public class PaisesAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String URL = "http://services.groupkt.com/country/get/all";

    @Override
    protected Void doInBackground(Void... params) {
        Log.i("URL", URL);
        String response =  HttpRequest.get(URL).body();
        // Parse con JSON
        Gson gson = new Gson();
        PaisGson result = gson.fromJson(response, PaisGson.class);

        List<String> mensajes = result.RestResponse.messages;

        for (String mensaje : mensajes) {
            Log.i("MENSAJE:", mensaje);
        }

        String nombreDePais02 = result.RestResponse.result.get(1).name;
        String nombreDePais03 = result.RestResponse.result.get(2).name;
        String nombreDePais04 = result.RestResponse.result.get(3).name;

        Log.i("N_PAIS_02:", nombreDePais02);
        Log.i("N_PAIS_03:", nombreDePais03);
        Log.i("N_PAIS_04:", nombreDePais04);

        return null;
    }

    @Override
    protected void onPostExecute(Void Void) {
        // TODO : Realizar algo mas
    }
}
