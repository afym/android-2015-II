package pe.edu.tecsup;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class StudentHelper extends SQLiteOpenHelper {
    private Activity activity;
    public static String DATABASE_NAME = "school2.db";
    public static int VERSION = 4;

    public StudentHelper(Activity activity){
        super(activity, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS student;");
    }

    public boolean insertStudent(Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", student.getName());
        contentValues.put("phone", student.getPhone());
        db.insert("student", null, contentValues);

        return true;
    }

    public ArrayList<Student> getStudents()
    {
        ArrayList<Student> students = new ArrayList<Student>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result =  db.rawQuery( "SELECT * FROM student", null );
        result.moveToFirst();

        while(result.isAfterLast() == false){
            Student student = new Student();
            //Log.i("A", result.getString(result.getColumnIndex("name")).toString());
            //Log.i("B", result.getString(result.getColumnIndex("phone")).toString());
            student.setName(result.getString(result.getColumnIndex("name")));
            student.setPhone(result.getString(result.getColumnIndex("phone")));
            students.add(student);
            result.moveToNext();
        }

        return students;
    }
}
