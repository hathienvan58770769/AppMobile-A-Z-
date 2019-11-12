package hathienvan.firstapplication.appchatjetart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAccountActivity extends AppCompatActivity {


    EditText edtEmail, edtPassword;
    TextView txtForgotPass, txtCreateAccount;
    ImageButton btnLogin, btnBackSignup;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);

        AnhXa();
        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUsername = edtEmail.getText().toString();
                String txtPassword = edtPassword.getText().toString();

                if (TextUtils.isEmpty(txtUsername)  ||TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(LoginAccountActivity.this, "All filed are required !", Toast.LENGTH_SHORT).show();
                }else {
                    auth.signInWithEmailAndPassword(txtUsername, txtPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(LoginAccountActivity.this,SettingActivity.class );
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(LoginAccountActivity.this, "Authentication failled", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    }
                }
            });

        txtCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAccountActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        btnBackSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAccountActivity.this, SignUpLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        btnLogin = (ImageButton) findViewById(R.id.imageButtonLogin);
        btnBackSignup = (ImageButton) findViewById(R.id.imageButtonBack);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
        txtForgotPass = (TextView) findViewById(R.id.textViewForgot);
        txtCreateAccount = (TextView) findViewById(R.id.textViewCreate);
    }
}
