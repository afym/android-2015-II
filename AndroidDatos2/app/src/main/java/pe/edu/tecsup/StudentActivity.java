package pe.edu.tecsup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

// Visitar :
// http://www.tutorialspoint.com/android/android_sqlite_database.htm

public class StudentActivity extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private Button save;
    private Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        this.name = (EditText)this.findViewById(R.id.edit_name);
        this.phone = (EditText)this.findViewById(R.id.edit_phone);
        this.save = (Button)this.findViewById(R.id.save);
        this.view = (Button)this.findViewById(R.id.view);
        this.save.setOnClickListener(new StudentSave(this, this.name, this.phone));
        this.view.setOnClickListener(new StudentView(this));
    }
}
