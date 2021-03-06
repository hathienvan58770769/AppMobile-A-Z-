package hathienvan.firstapplication.vd98_animationrotate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgRotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgRotate = (ImageView) findViewById(R.id.imageView);

        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        imgRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animRotate);
            }
        });
    }
}
