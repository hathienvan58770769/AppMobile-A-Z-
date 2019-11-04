package hathienvan.firstapplication.vd119_medialocalsound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnMp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMp3 = (Button) findViewById(R.id.buttonPlayMp3);

        btnMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.con_gi_dau_hon_chu_da_tung_quan_ap);
                mediaPlayer.start();
            }
        });
    }
}
