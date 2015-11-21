package pe.edu.tecsup.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pe.edu.tecsup.R;
import pe.edu.tecsup.events.MainOnClickEvent;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private TextView errorMessage;
    private EditText userName;
    private EditText passwordName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();
        this.init();
    }

    protected void onStart() {
        super.onStart();
        this.addLoginEvent();
    }

    private void init() {
        this.loginButton = (Button)this.findViewById(R.id.login);
        this.errorMessage = (TextView)this.findViewById(R.id.error_message);
        this.userName = (EditText)this.findViewById(R.id.user_name);
        this.passwordName = (EditText)this.findViewById(R.id.password_name);
    }

    private void addLoginEvent(){
        this.loginButton.setOnClickListener(new MainOnClickEvent(this, this.errorMessage, this.userName, this.passwordName));
    }

}
