package pe.edu.tecsup;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudentSave implements View.OnClickListener {
    private Activity activity;
    private EditText name;
    private EditText phone;

    public StudentSave(Activity activity, EditText name, EditText phone){
        this.activity = activity;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public void onClick(View v) {
        Student student = new Student();
        student.setName(this.name.getText().toString());
        student.setPhone(this.phone.getText().toString());
        Log.i("NAME", student.getName());
        Log.i("PHONE", student.getPhone());
        // Insertando a la BD
        StudentHelper studentHelper = new StudentHelper(this.activity);
        studentHelper.insertStudent(student);
        Toast.makeText(this.activity, "Guardado ...", Toast.LENGTH_LONG).show();
    }
}
