package pe.edu.tecsup.events;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import pe.edu.tecsup.R;
import pe.edu.tecsup.activities.MainActivity;
import pe.edu.tecsup.activities.NoteDetailActivity;

public class MainOnClickListener implements AdapterView.OnItemClickListener {
    private Activity activity;

    public MainOnClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView noteId = (TextView)view.findViewById(R.id.note_id);
        Intent intent = new Intent(this.activity, NoteDetailActivity.class);
        intent.putExtra(MainActivity.NOTE_ID, new Integer(noteId.getText().toString()));
        this.activity.startActivity(intent);
    }
}
