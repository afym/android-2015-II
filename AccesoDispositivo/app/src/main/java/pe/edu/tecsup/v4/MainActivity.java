package pe.edu.tecsup.v4;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {
    private EditText contenido;
    private ImageButton boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.contenido = (EditText)this.findViewById(R.id.edit_contenido);
        this.boton = (ImageButton)this.findViewById(R.id.btn_grabar);
    }

    public void grabarArchivo(View view){
        // Recuperando texto del edittext
        String contenido = this.contenido.getText().toString();

        // Crear un directorio
        File folder = new File(Environment.getExternalStorageDirectory() + "/DIR2");
        boolean isFolder = folder.exists();

        if (!isFolder) {
            folder.mkdirs();
        }

        // Crear el archivo
        File file = new File(folder, "text01.txt");

        try {
            FileWriter writer = new FileWriter(file);
            writer.append(contenido);
            writer.flush();
            writer.close();
            Toast.makeText(this, "Archivo guardado!!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_LONG).show();
        }
    }

    public void irHaciaQR(View view){
        Intent intent = new Intent(this, QRActivty.class);
        this.startActivity(intent);
    }
}
