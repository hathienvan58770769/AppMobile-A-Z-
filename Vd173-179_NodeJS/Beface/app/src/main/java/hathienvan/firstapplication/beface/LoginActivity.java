package hathienvan.firstapplication.beface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    TextView txtForgotPass, txtCreateAccount;
    ImageButton btnLogin, btnBackSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AnhXa();

        txtCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        btnBackSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        btnLogin = (ImageButton) findViewById(R.id.imageButtonLoginUsername);
        btnBackSignup = (ImageButton) findViewById(R.id.imageButtonBackSignup);
        edtUsername = (EditText) findViewById(R.id.editTextUsernameAcount);
        edtPassword = (EditText) findViewById(R.id.editTextPasswordAcount);
        txtForgotPass = (TextView) findViewById(R.id.textViewForgotPassword);
        txtCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
    }
}
