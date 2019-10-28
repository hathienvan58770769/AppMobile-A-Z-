package hathienvan.firstapplication.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView txtTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTime = (TextView) findViewById(R.id.textViewTime);
        //chon libs java.util
        Calendar calendar = Calendar.getInstance();

        txtTime.append(calendar.getTime() + "\n");

        txtTime.append(calendar.get(Calendar.DATE) + "\n");
        txtTime.append(calendar.get(Calendar.MONTH) + "\n");
        txtTime.append(calendar.get(Calendar.YEAR) + "\n");

        SimpleDateFormat dinhDangNgay = new SimpleDateFormat("dd/MM/yyyy");
        txtTime.append(dinhDangNgay.format(calendar.getTime())+"\n");

        txtTime.append(calendar.get(Calendar.HOUR) + "\n");
        txtTime.append(calendar.get(Calendar.HOUR_OF_DAY) + "\n");

        SimpleDateFormat dinhDangGio = new SimpleDateFormat("hh:mm:ss a");
        txtTime.append(dinhDangGio.format(calendar.getTime())+"\n");
    }

}
