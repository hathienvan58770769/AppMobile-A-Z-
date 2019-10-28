package hathienvan.firstapplication.drawableclib;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgHinh;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHinh = (ImageView) findViewById(R.id.imageView);
        btnClick = (Button) findViewById(R.id.button);

        final ClipDrawable clipDrawable = (ClipDrawable) imgHinh.getDrawable();

        imgHinh.setImageLevel(10000);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int currentLevel = clipDrawable.getLevel();
                        if (clipDrawable.getLevel() <= 0){
                            currentLevel = 10000;
                        }
                        imgHinh.setImageLevel(currentLevel - 1000);
                        handler.postDelayed(this,500);
                    }
                },2000);

            }
        });
    }
}
