package hathienvan.firstapplication.beface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SignUpLoginActivity extends AppCompatActivity {

    ImageButton btnLogin, btnSignUp, btnSignInFB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_login);

        AnhXa();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpLoginActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpLoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    private void AnhXa() {
        btnLogin = (ImageButton) findViewById(R.id.imageButtonLoginUsername);
        btnSignUp = (ImageButton) findViewById(R.id.imageButtonSignUp);
        btnSignInFB = (ImageButton) findViewById(R.id.imageButtonSignInFb);

    }
}
