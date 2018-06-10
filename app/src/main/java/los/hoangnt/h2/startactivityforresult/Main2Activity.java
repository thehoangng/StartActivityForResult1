package los.hoangnt.h2.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtName;
    private EditText txtPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addEvent();
        addControl();

    }

    private void addEvent() {
        txtName = this.findViewById(R.id.txtName);
        txtPassword = this.findViewById(R.id.txtPassword);
        btnLogin = this.findViewById(R.id.btnLogin);
    }

    private void addControl() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                equalNameAndPass();
                break;
        }
    }

    private void equalNameAndPass() {
        String name = txtName.getText().toString();
        String pass = txtPassword.getText().toString();

        if(name.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin123")){
            //login success
            Intent intent = new Intent();
            setResult(Activity.RESULT_OK,intent);
            finish();
        }else {
            //login fail
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED,intent);
            finish();
        }
    }
}
