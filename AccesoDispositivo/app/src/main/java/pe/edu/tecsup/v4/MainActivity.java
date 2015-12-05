package pe.edu.tecsup.v4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {
    private EditText contenido;
    private ImageButton boton;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.contenido = (EditText)this.findViewById(R.id.edit_contenido);
        this.boton = (ImageButton)this.findViewById(R.id.btn_grabar);
        this.foto = (ImageView)this.findViewById(R.id.foto);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i("BITMAP_RQ", "" + requestCode);
        Log.i("BITMAP_RC", "" + resultCode);

        if (resultCode != RESULT_CANCELED) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            this.foto.setImageBitmap(bitmap);
            this.foto.setVisibility(View.VISIBLE);
        }
    }

    public void irHaciaQR(View view){
        Intent intent = new Intent(this, QRActivty.class);
        this.startActivity(intent);
    }

    public void irHaciaLaCamara(View w) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.startActivityForResult(intent, 0);
    }

    public void irHaciaGoolge(View w){
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
