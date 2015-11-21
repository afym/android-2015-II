package pe.edu.tecsup.events;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pe.edu.tecsup.activities.MenuActivity;

public class MainOnClickEvent implements View.OnClickListener {
    public static final String USER_NAME = "user_name";
    private Activity activity;
    private EditText user;
    private EditText password;
    private TextView error;

    public MainOnClickEvent(Activity activity, TextView error, EditText user, EditText password) {
        this.user = user;
        this.password = password;
        this.activity = activity;
        this.error = error;
    }

    @Override
    public void onClick(View v) {
        if (this.login(this.user.getText().toString(), this.password.getText().toString())) {
            this.error.setVisibility(TextView.INVISIBLE);
            Intent intent = new Intent(this.activity, MenuActivity.class);
            intent.putExtra(USER_NAME, this.user.getText().toString());
            this.activity.startActivity(intent);
        } else {
            this.error.setVisibility(TextView.VISIBLE);
        }
    }

    private boolean login(String user, String password) {

        if (user.equals("root") && password.equals("123456")) {
            return true;
        }

        return false;
    }
}
