package pe.edu.tecsup.v4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

public class CompassActivity extends AppCompatActivity {

    private static SensorManager sensorService;
    private SensorEventListener mySensorEventListener;
    private Sensor sensor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Creando una vista tipo  brujula (compass) propia
        this.setContentView(R.layout.activity_compass);

        // Iniciando el sensor
        this.sensorService = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        this.sensor = sensorService.getDefaultSensor(Sensor.TYPE_ORIENTATION);


        // Evento de la brujula
        this.mySensorEventListener = new CompassListener();

        // Validando el sensor
        if (this.sensor != null) {
            this.sensorService.registerListener(mySensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(this, "NO HAY SENSOR =(", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sensor != null) {
            sensorService.unregisterListener(mySensorEventListener);
        }
    }
}
