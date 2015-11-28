package pe.edu.tecsup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import pe.edu.tecsup.R;
import pe.edu.tecsup.model.Note;
import pe.edu.tecsup.sql.NoteDbHelper;

public class NoteDetailActivity extends AppCompatActivity {
    private TextView title;
    private TextView body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        this.initUI();
    }

    @Override
    protected void onStart(){
        super.onStart();
        this.initMessage();
    }

    private void initUI(){
        this.title = (TextView)this.findViewById(R.id.text_title);
        this.body = (TextView)this.findViewById(R.id.text_body);
    }

    private void initMessage(){
        if (this.getIntent() != null) {
            Intent intent = this.getIntent();
            NoteDbHelper noteDbHelper = new NoteDbHelper(this);

            int id = intent.getIntExtra(MainActivity.NOTE_ID, 0);

            if (id != 0) {
                Note note = noteDbHelper.getNote(id);
                this.title.setText(note.getTitle().toString());
                this.body.setText(note.getBody().toString());
            }
        }
    }
}
