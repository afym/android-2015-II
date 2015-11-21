package pe.edu.tecsup.model;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.tecsup.R;

public class MenuAdapaterModel extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] contenidos;
    private final Integer[] iconos;

    public MenuAdapaterModel(Activity context, String[] contenidos, Integer[] iconos) {
        super(context,  R.layout.activity_menu_items, contenidos);
        this.context = context;
        this.contenidos = contenidos;
        this.iconos = iconos;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_menu_items, null, true);
        // Elementos dentro de mi layout : activity_social_contenido
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item_text);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.item_image);
        // Modificando elementos
        txtTitle.setText(contenidos[position]);
        imageView.setImageResource(iconos[position]);

        return rowView;
    }
}