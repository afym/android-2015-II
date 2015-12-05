package pe.edu.tecsup.v4;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

public class CompassListener implements SensorEventListener {

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float azimuth = event.values[0];
        Log.i("COMPASS_VAL : ", azimuth + "");
    }
}
