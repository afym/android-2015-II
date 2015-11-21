package pe.edu.tecsup.events;


import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import pe.edu.tecsup.activities.AccountActivity;
import pe.edu.tecsup.activities.MainActivity;

public class MenuOnClickEvent implements AdapterView.OnItemClickListener {
    private static final int OPTION_ACCOUNT = 0;
    private static final int OPTION_PHOTO = 1;
    private static final int OPTION_LOGOUT = 2;
    private Activity activity;

    public MenuOnClickEvent(Activity activity) {
        this.activity = activity;
    }

    // Metodo que escucha el evento
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.itemMenu(position);
    }

    // Metodo que selecciona cada item
    private void itemMenu(int position){
        switch (position) {
            case OPTION_ACCOUNT:
                Intent intent1 = new Intent(this.activity, AccountActivity.class);
                this.activity.startActivity(intent1);
                break;
            case OPTION_PHOTO:
                // TODO : Aun no se define el comportamiento
                break;
            case OPTION_LOGOUT:
                Intent intent2 = new Intent(this.activity, MainActivity.class);
                this.activity.startActivity(intent2);
                break;
        }
    }
}
