package hathienvan.firstapplication.appchatjetart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    ImageButton btnBack, btnCreateAccount;
    EditText edtUsername, edtPassword, edtEmail;

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        AnhXa();

        auth = FirebaseAuth.getInstance();


        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUsername = edtUsername.getText().toString();
                String txtEmail = edtEmail.getText().toString();
                String txtPassword = edtPassword.getText().toString();

                if (TextUtils.isEmpty(txtUsername)  || TextUtils.isEmpty(txtEmail)  ||TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(SignUpActivity.this, "All filed are required !", Toast.LENGTH_SHORT).show();
                }else if (txtPassword.length()<6){
                    Toast.makeText(SignUpActivity.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                }else {
                    register(txtUsername, txtEmail, txtPassword);
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignUpLoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private  void register(final String username, String email, String  password){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = auth.getCurrentUser();
                    String userId = user.getUid();
                    reference = FirebaseDatabase.getInstance().getReference("Users").child(userId);

                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("id", userId);
                    hashMap.put("username", username);
                    hashMap.put("imageUrl", "default");
                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(SignUpActivity.this, LoginAccountActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }else {
                    Toast.makeText(SignUpActivity.this, "You Can't Register with this email or password ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        btnCreateAccount = (ImageButton) findViewById(R.id.imageButtonCreateAccount);
        btnBack = (ImageButton) findViewById(R.id.imageButtonBack);
        edtUsername = (EditText) findViewById(R.id.editTextUsername);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
    }
}
