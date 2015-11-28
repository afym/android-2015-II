package pe.edu.tecsup.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import pe.edu.tecsup.R;
import pe.edu.tecsup.events.NoteFormOnClickListener;
import pe.edu.tecsup.sql.NoteContract;

public class NoteFormActivity extends AppCompatActivity {
    public static String SAVE_NOTE = "SAVE_NOTE";
    private EditText title;
    private Spinner type;
    private EditText body;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_form);
    }

    @Override
    protected void onStart(){
        super.onStart();
        this.initUI();
        this.setTypes();
        this.initEvents();
    }

    private void initUI(){
        this.title = (EditText)this.findViewById(R.id.edit_title);
        this.type = (Spinner)this.findViewById(R.id.spinner_type);
        this.body = (EditText)this.findViewById(R.id.edit_body);
        this.save = (Button)this.findViewById(R.id.button_save);
    }

    private void initEvents(){
        this.save.setOnClickListener(new NoteFormOnClickListener(this, this.title, this.body, this.type));
    }

    private void setTypes(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, NoteContract.TYPES);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.type.setAdapter(adapter);
    }
}