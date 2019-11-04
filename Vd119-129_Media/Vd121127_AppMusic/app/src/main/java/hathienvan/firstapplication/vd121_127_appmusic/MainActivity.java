package hathienvan.firstapplication.vd121_127_appmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtNameSong, txtStart, txtEnd;
    ImageView imgAudio;
    ImageButton ibtnPlay, ibtnPause, ibtnNext, ibtnChevron;
    SeekBar sbTime;
    ArrayList<Song> listSong;
    int position = 0;
    MediaPlayer mediaPlayer;
    Animation animation ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        AddSong();

        animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate_audio);
        CreateMediaPlayer();

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    ibtnPlay.setImageResource(R.drawable.play_button);
                }else {
                    mediaPlayer.start();
                    ibtnPlay.setImageResource(R.drawable.pause_button);
                }
                SetTimeTotal();
                UpdateTimeSong();
                imgAudio.startAnimation(animation);
            }

        });

        ibtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                ibtnPlay.setImageResource(R.drawable.play_button);
                CreateMediaPlayer();
                SetTimeTotal();
            }
        });

        ibtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position ++;
                if (position> listSong.size()-1){
                    position = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                CreateMediaPlayer();
                mediaPlayer.start();
                ibtnPlay.setImageResource(R.drawable.pause_button);
                SetTimeTotal();
                UpdateTimeSong();
            }
        });

        ibtnChevron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position --;
                if (position< 0){
                    position = listSong.size() - 1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                CreateMediaPlayer();
                mediaPlayer.start();
                ibtnPlay.setImageResource(R.drawable.pause_button);
                SetTimeTotal();
                UpdateTimeSong();
            }
        });

        sbTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(sbTime.getProgress());

            }
        });

    }
    private  void  UpdateTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sinhdangms = new SimpleDateFormat("mm:ss");
                txtStart.setText(sinhdangms.format(mediaPlayer.getCurrentPosition()));
                sbTime.setProgress(mediaPlayer.getCurrentPosition());
                //kt tg song -> kt->nextsong new
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position ++;
                        if (position> listSong.size()-1){
                            position = 0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        CreateMediaPlayer();
                        mediaPlayer.start();
                        ibtnPlay.setImageResource(R.drawable.pause_button);
                        SetTimeTotal();
                        UpdateTimeSong();
                    }
                });
                handler.postDelayed(this,500);

            }
        },100);
    }
    private void SetTimeTotal(){

        SimpleDateFormat dinhdangGio = new SimpleDateFormat("mm:ss");
        txtEnd.setText(dinhdangGio.format(mediaPlayer.getDuration()));

        sbTime.setMax(mediaPlayer.getDuration());

    }
    private  void  CreateMediaPlayer(){
        mediaPlayer = MediaPlayer.create(MainActivity.this, listSong.get(position).getFileMp3());
        txtNameSong.setText(listSong.get(position).getTitle());
    }

    private void AddSong() {
        listSong = new ArrayList<>();
        listSong.add(new Song("Con gi hon chu da tung - Quan A.P", R.raw.con_gi_dau_hon_chu_da_tung_quan_ap));
        listSong.add(new Song("Em gi oi  - Jack ft K-ICM", R.raw.em_gi_oi_jack_k_icm));
        listSong.add(new Song("Het thuong can nho - Duc Phuc", R.raw.het_thuong_can_nho_duc_phuc));
        listSong.add(new Song("Gia nhu co ay chua xuat hien - Miu le", R.raw.gia_nhu_co_ay_chua_xuat_hien_miu_le));
        listSong.add(new Song("La ban khong the yeu - Lou Hoang", R.raw.la_ban_khong_the_yeu_lou_hoang));
        listSong.add(new Song("Sai lam cua anh - Dinh Dung", R.raw.sai_lam_cua_anh_dinh_dung));
        listSong.add(new Song("Simple love- Obito ft Seachains ft Davis", R.raw.simple_love_obito_seachains_davis));
        listSong.add(new Song("Troi giau troi mang di - AMEE ft ViruSs", R.raw.troi_giau_troi_mang_di_amee_viruss));
    }

    private void AnhXa() {

        txtNameSong  = (TextView) findViewById(R.id.textViewNameBH);
        txtStart     = (TextView) findViewById(R.id.textViewStart);
        txtEnd       = (TextView) findViewById(R.id.textViewEnd);
        ibtnPlay     = (ImageButton) findViewById(R.id.imageButtonPlay);
        ibtnPause    = (ImageButton) findViewById(R.id.imageButtonStop);
        ibtnChevron  = (ImageButton) findViewById(R.id.imageButtonChevron);
        ibtnNext     = (ImageButton) findViewById(R.id.imageButtonNext);
        sbTime       = (SeekBar) findViewById(R.id.seekBar);
        imgAudio     = (ImageView) findViewById(R.id.imageViewAudio);

    }
}
