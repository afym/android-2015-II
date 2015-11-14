package pe.edu.tecsup;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaSocial extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] contenidos;
    private final Integer[] iconos;

    public ListaSocial(Activity context, String[] contenidos, Integer[] iconos) {
        super(context, R.layout.activity_social_contenido, contenidos);
        this.context = context;
        this.contenidos = contenidos;
        this.iconos = iconos;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_social_contenido, null, true);
        // Elementos dentro de mi layout : activity_social_contenido
        TextView txtTitle = (TextView) rowView.findViewById(R.id.contenido);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icono);
        // Modificando elementos
        txtTitle.setText(contenidos[position]);
        imageView.setImageResource(iconos[position]);

        return rowView;
    }
}