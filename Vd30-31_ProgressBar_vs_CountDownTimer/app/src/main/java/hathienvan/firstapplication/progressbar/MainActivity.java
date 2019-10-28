package hathienvan.firstapplication.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDownload;
    ProgressBar pbXuly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDownload = (Button) findViewById(R.id.button);
        pbXuly = ( ProgressBar) findViewById(R.id.progressBar2);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = pbXuly.getProgress();
                        if (current >= pbXuly.getMax()){
                            current = 0;
                        }
                        pbXuly.setProgress(current + 10);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Het gio", Toast.LENGTH_SHORT).show();
                    }
                };
            countDownTimer.start();

            }
        });
    }
}
