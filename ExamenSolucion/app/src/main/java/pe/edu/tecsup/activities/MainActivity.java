package pe.edu.tecsup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import pe.edu.tecsup.R;
import pe.edu.tecsup.adapters.NoteArrayAdapter;
import pe.edu.tecsup.events.MainOnClickListener;
import pe.edu.tecsup.model.Note;
import pe.edu.tecsup.sql.NoteDbHelper;

public class MainActivity extends AppCompatActivity {
    public static String NOTE_ID = "NOTE_ID";
    private TextView noNotes;
    private ListView notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        this.initUI();
        this.listenIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.note_add:
                Intent intent = new Intent(this, NoteFormActivity.class);
                startActivity(intent);
                return true;
        }

        return true;
    }

    private void initUI() {
        NoteDbHelper noteDbHelper = new NoteDbHelper(this);
        ArrayList<Note> notes = noteDbHelper.getNotes();

        this.notes = (ListView)this.findViewById(R.id.note_list);
        this.noNotes = (TextView)this.findViewById(R.id.text_no_notes);
        this.notes.setOnItemClickListener(new MainOnClickListener(this));

        if (notes != null && notes.size() > 0) {
            NoteArrayAdapter noteArrayAdapter = new NoteArrayAdapter(this, notes);
            this.notes.setAdapter(noteArrayAdapter);
        } else {
            this.notes.setVisibility(View.INVISIBLE);
            this.noNotes.setVisibility(View.VISIBLE);
        }
    }

    private void listenIntent() {
        if (this.getIntent() != null) {
            Intent intent = this.getIntent();
            boolean save = intent.getBooleanExtra(NoteFormActivity.SAVE_NOTE, false);

            if (save) {
                String message = this.getResources().getString(R.string.save_note).toString();
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}