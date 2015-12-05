package pe.edu.tecsup.v4;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class GPSActivity extends AppCompatActivity implements LocationListener {
    private TextView latituteField;
    private TextView longitudeField;
    private LocationManager locationManager;
    private String provider;


    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        // Obteniendo los textos
        this.latituteField = (TextView) findViewById(R.id.TextView02);
        this.longitudeField = (TextView) findViewById(R.id.TextView04);

        // Obteniendo el admnistrador de localizacion
        this.locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        this.provider = locationManager.getBestProvider(criteria, false);
        Location location = this.locationManager.getLastKnownLocation(provider);

        // Validando la localizacion
        if (location != null) {
            Log.i("LOCAL", "PROVEEDOR :  " + provider);
            onLocationChanged(location);
        } else {
            Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(1000);

            latituteField.setText("NO DISPONBLE ...");
            longitudeField.setText("NO DISPONBLE ...");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }

    /* Remove the locationlistener updates when Activity is paused */
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        int lat = (int) (location.getLatitude());
        int lng = (int) (location.getLongitude());

        latituteField.setText(String.valueOf(lat));
        longitudeField.setText(String.valueOf(lng));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "HABILITANDO PROVEEDOR " + provider, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "NO HAY PROVEEDOR" + provider, Toast.LENGTH_SHORT).show();
    }
}
