package pe.edu.tecsup;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class StudentView implements View.OnClickListener {
    private Activity activity;

    public StudentView(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.activity, StudentDetailActivity.class);
        this.activity.startActivity(intent);
    }
}
