package hathienvan.firstapplication.vd128_mediaonlinesound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnMp3, btnMp4;
    ProgressBar pbLoading;
    VideoView vdOnline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMp3 = (Button) findViewById(R.id.buttonMp3);
        btnMp4 = (Button) findViewById(R.id.buttonVideo);
        vdOnline = (VideoView) findViewById(R.id.videoViewOnline);
        pbLoading = (ProgressBar) findViewById(R.id.progressBarLoad);
        pbLoading.setVisibility(View.GONE);

        btnMp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriMp4 = Uri.parse("https://khoapham.vn/download/vuoncaovietnam.mp4");
                vdOnline.setVideoURI(uriMp4);
                vdOnline.setMediaController(new MediaController(MainActivity.this));
                vdOnline.start();
            }
        });
        btnMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlMp3 = "https://khoapham.vn/download/vietnamoi.mp3";
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(urlMp3);
                    mediaPlayer.prepareAsync();
                    //show dialog  ProgressBar
                    pbLoading.setVisibility(View.VISIBLE);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            pbLoading.setVisibility(View.GONE);
                            mp.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
