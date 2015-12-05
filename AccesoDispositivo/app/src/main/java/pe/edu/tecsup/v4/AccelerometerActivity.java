package pe.edu.tecsup.v4;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private boolean color = false;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        this.view = findViewById(R.id.textView);
        this.view.setBackgroundColor(Color.GREEN);

        this.sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        Toast.makeText(this, "Parando el servicio", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Validando el sensor
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // Llamando el metodo del acelerometro
            getAccelerometer(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Ejes en los que se mueve el celular
        float x = values[0];
        float y = values[1];
        float z = values[2];

        // Redondeando a entero:
        int x1 = Math.round(x * 100);
        int y1 = Math.round(y * 100);
        int z1 = Math.round(z * 100);

        int total = x1 + y1 + z1;

        // Obteniendo la mascara
        String hexColor = String.format("#%06X", (0xFFFFFF & total));

        // Parseando el color para android
        int color = Color.parseColor(hexColor);

        Log.i("XYZ", "" + x1 + " - " + y1 + " - "+ z1 + " - " + "-" + hexColor + " - " + color);

        // Armando un arreglo de colores de acuerdo a los ejes coordenados
        this.view.setBackgroundColor(color);
    }
}
