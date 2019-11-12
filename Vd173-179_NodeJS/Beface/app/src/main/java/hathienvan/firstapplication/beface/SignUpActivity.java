package hathienvan.firstapplication.beface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    ImageButton btnBack, btnCreateAccount;
    EditText edtUsername, edtPassword, edtEmail, edtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        AnhXa();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignUpLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        btnCreateAccount = (ImageButton) findViewById(R.id.imageButtonCreateAccount);
        btnBack = (ImageButton) findViewById(R.id.imageButtonBack);
        edtUsername = (EditText) findViewById(R.id.editTextUsernameAcount);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtPassword = (EditText) findViewById(R.id.editTextPasswordAcount);
        edtConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
    }
}
