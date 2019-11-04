package hathienvan.firstapplication.vd120_medialocalvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button btnMp4;
    VideoView vdMp4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMp4 = (Button) findViewById(R.id.buttonMp4);
        vdMp4 = (VideoView) findViewById(R.id.videoViewMp4);

        btnMp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vdMp4.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bach_lo_am_khuyet_thi_thinh));
                vdMp4.start();
                MediaController mediaController = new MediaController(MainActivity.this);
                mediaController.setMediaPlayer(vdMp4);
                vdMp4.setMediaController(mediaController);
            }
        });
    }
}
