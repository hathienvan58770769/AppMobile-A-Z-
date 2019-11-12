package hathienvan.firstapplication.appchatjetart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpLoginActivity extends AppCompatActivity {

    ImageButton btnLogin, btnSignUp, btnSignInFB;

    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_login);

        AnhXa();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null){
            Intent intent = new Intent(SignUpLoginActivity.this, SettingActivity.class);
            startActivity(intent);
            finish();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpLoginActivity.this, LoginAccountActivity.class);
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
        btnLogin = (ImageButton) findViewById(R.id.imageButtonLogin);
        btnSignUp = (ImageButton) findViewById(R.id.imageButtonSignUp);
        btnSignInFB = (ImageButton) findViewById(R.id.imageButtonSignInFB);

    }

}
