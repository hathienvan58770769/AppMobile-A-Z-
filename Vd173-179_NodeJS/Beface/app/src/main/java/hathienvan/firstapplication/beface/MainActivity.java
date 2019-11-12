package hathienvan.firstapplication.beface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChuyenManHinh();
    }
    //Dùng cài đặt sau 5 giây màn hình tự chuyển
    protected void ChuyenManHinh(){
        Thread loading =new Thread(){
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception e) {

                }
                finally {
                    Intent intent = new Intent(MainActivity.this, ChatDetailActivity.class);
                    startActivity(intent);
                }
            }
        };
        loading.start();
    }
    //sau khi chuyển sang màn hình chính, kết thúc màn hình chào
    protected void onPause(){
        super.onPause();
        finish();
    }
}
