package pe.edu.tecsup.events;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import pe.edu.tecsup.activities.MainActivity;
import pe.edu.tecsup.activities.NoteFormActivity;
import pe.edu.tecsup.model.Note;
import pe.edu.tecsup.sql.NoteDbHelper;

public class NoteFormOnClickListener implements View.OnClickListener {
    private Activity activity;
    private EditText title;
    private Spinner type;
    private EditText body;

    public NoteFormOnClickListener(Activity activity, EditText title, EditText body, Spinner type){
        this.activity = activity;
        this.title = title;
        this.body = body;
        this.type = type;
    }

    @Override
    public void onClick(View v) {
        Note note = new Note();
        note.setTitle(this.title.getText().toString());
        note.setBody(this.body.getText().toString());
        note.setType((new Long(this.type.getSelectedItemId())).toString());

        NoteDbHelper noteDbHelper = new NoteDbHelper(this.activity);
        noteDbHelper.addNote(note);

        Intent intent = new Intent(this.activity, MainActivity.class);
        intent.putExtra(NoteFormActivity.SAVE_NOTE, true);
        this.activity.startActivity(intent);
    }
}
