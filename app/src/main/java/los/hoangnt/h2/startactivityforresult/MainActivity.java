package los.hoangnt.h2.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private TextView txtPlsLogin;
    public static final int LOGIN_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addEvent();
        addControl();

    }

    private void addEvent() {
        btnLogin = this.findViewById(R.id.btnLogin);
        txtPlsLogin = this.findViewById(R.id.txtPlsLogin);
    }

    private void addControl() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()) {
            case R.id.btnLogin:
                processLogin();
                break;
        }
    }

    private void processLogin() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, LOGIN_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOGIN_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                //display success
                btnLogin.setVisibility(View.INVISIBLE);
                txtPlsLogin.setText("Login Successful!");
            } else {
                //display fail
                txtPlsLogin.setText("Login Fail!");
            }
        }
    }
}
