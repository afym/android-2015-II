package pe.edu.tecsup.sql;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import pe.edu.tecsup.model.Note;

public class NoteDbHelper extends SQLiteOpenHelper {

    private Activity activity;
    public static final int DATABSE_VERSION = 2;
    public static final String DATABASE_NAME = "notes.db";

    public NoteDbHelper(Activity activity) {
        super(activity, DATABASE_NAME, null, DATABSE_VERSION);
        this.activity = activity;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NoteContract.getCreateTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NoteContract.getDropTable());
        this.onCreate(db);
    }

    public Note getNote(int id) {
        SQLiteDatabase db = getWritableDatabase();

        String[] columns = new String[]{
                NoteContract.COLUMN_NAME_ENTRY_ID,
                NoteContract.COLUMN_NAME_TITLE,
                NoteContract.COLUMN_NAME_BODY,
                NoteContract.COLUMN_NAME_TYPE};

        String[] arguments = new String[]{(new Integer(id)).toString()};

        Note note = new Note();

        Cursor cursor = db.query(NoteContract.TABLE_NAME, columns,
                NoteContract.COLUMN_NAME_ENTRY_ID + "=?", arguments, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {

                note.setId(cursor.getInt(0));
                note.setTitle(cursor.getString(1));
                note.setBody(cursor.getString(2));
                note.setType(cursor.getString(3));
            } while(cursor.moveToNext());
        }

        return note;
    }

    public void addNote(Note note){
        if(note != null) {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues item = new ContentValues();
            item.put(NoteContract.COLUMN_NAME_TITLE, note.getTitle());
            item.put(NoteContract.COLUMN_NAME_BODY, note.getBody());
            item.put(NoteContract.COLUMN_NAME_TYPE, note.getType());

            db.insert(NoteContract.TABLE_NAME, null, item);
            db.close();
        }
    }

    public ArrayList<Note> getNotes(){
        ArrayList<Note> notes = new ArrayList<Note>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[]{
                NoteContract.COLUMN_NAME_ENTRY_ID,
                NoteContract.COLUMN_NAME_TITLE,
                NoteContract.COLUMN_NAME_BODY,
                NoteContract.COLUMN_NAME_TYPE};

        Cursor cursor = db.query(NoteContract.TABLE_NAME,columns,
                null, null, null, null, null, null);

        if (cursor != null) {
            for(cursor.moveToFirst(); cursor.isAfterLast() == false; cursor.moveToNext()) {
                Note note = new Note();
                note.setId(cursor.getInt(0));
                note.setTitle(cursor.getString(1));
                note.setBody(cursor.getString(2));
                note.setType(cursor.getString(3));
                notes.add(note);
            }

            cursor.close();
        }

        db.close();

        return notes;
    }
}
