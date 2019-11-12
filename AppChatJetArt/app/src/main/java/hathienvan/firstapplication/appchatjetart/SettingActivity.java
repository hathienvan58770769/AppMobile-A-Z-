package hathienvan.firstapplication.appchatjetart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;
import hathienvan.firstapplication.appchatjetart.model.User;

public class SettingActivity extends AppCompatActivity {

//    CircleImageView circleImageView;
    TextView username;
    ImageButton btnLogout;

    FirebaseUser firebaseUser;
    DatabaseReference  reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        AnhXa();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SettingActivity.this, SignUpLoginActivity.class));
                finish();
            }
        });
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                User user = dataSnapshot.getValue(User.class);
                //                username.setText(user.getUsername());
//                if (user.getImageURL().equals("default")){
//                    circleImageView.setImageResource(R.drawable.oval_blue);
//                }else {
//                    Glide.with(SettingActivity.this).load(user.getImageURL()).into(circleImageView);
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void AnhXa() {
        username = (TextView) findViewById(R.id.textViewFullname);
        btnLogout = (ImageButton) findViewById(R.id.imageButtonLogout);
//        circleImageView= (CircleImageView) findViewById(R.id.circleImageVieweimageview);

    }
}
