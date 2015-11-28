package pe.edu.tecsup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentDetailActivity extends AppCompatActivity {
    private TextView students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        this.students = (TextView)this.findViewById(R.id.students);

        StudentHelper studentHelper = new StudentHelper(this);

        ArrayList<Student> studentsList = studentHelper.getStudents();
        String text = "";

        for (Student student : studentsList) {
            text += "Name : " + student.getName() + "Phone : " + student.getPhone() + ", ";
        }

        this.students.setText(text);
    }
}
