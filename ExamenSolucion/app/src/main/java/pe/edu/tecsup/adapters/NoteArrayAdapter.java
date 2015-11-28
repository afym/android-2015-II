package pe.edu.tecsup.adapters;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pe.edu.tecsup.R;
import pe.edu.tecsup.model.Note;

public class NoteArrayAdapter extends ArrayAdapter<Note> {
    private  Activity activity;
    private  ArrayList<Note> notes;

    public NoteArrayAdapter(Activity activity, ArrayList<Note> notes) {
        super(activity, R.layout.activity_main_note_list, notes);
        this.activity = activity;
        this.notes = notes;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View row = inflater.inflate(R.layout.activity_main_note_list, null, true);
        // Seteando el id oculto
        TextView id = (TextView)row.findViewById(R.id.note_id);
        id.setText(new Integer(notes.get(position).getId()).toString());
        // Elementos dentro de mi layout : activity_social_contenido
        TextView title = (TextView) row.findViewById(R.id.note_title);
        View color = (View) row.findViewById(R.id.note_color);
        // Modificando elementos
        title.setText(notes.get(position).getTitle());
        // Agregando colores
        int colorResource = 0;
        Log.i("COLOR", notes.get(position).getType());
        switch (notes.get(position).getType()){
            case "0":
                colorResource = R.color.colorAlert;
                break;

            case "1":
                colorResource = R.color.colorInfo;
                break;

            case "2":
                colorResource = R.color.colorWarning;
                break;
        }

        color.setBackgroundColor(ContextCompat.getColor(this.activity, colorResource));

        return row;
    }
}
