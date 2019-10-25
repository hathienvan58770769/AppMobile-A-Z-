package hathienvan.firstapplication.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SinhVien sinhVien = new SinhVien();
        sinhVien.HoTen = "Nguyen Van A";
        sinhVien.DiaChi= "DaNang";
        sinhVien.NamSinh= 1999;

        Toast.makeText(this,sinhVien.HoTen,Toast.LENGTH_SHORT).show();

    }
}
