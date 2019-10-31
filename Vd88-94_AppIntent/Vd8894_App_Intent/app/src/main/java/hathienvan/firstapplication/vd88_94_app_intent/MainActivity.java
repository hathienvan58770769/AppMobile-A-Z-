package hathienvan.firstapplication.vd88_94_app_intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> arrayImgName;
    ImageView imgGoc, imgNhan;
    int REQUEST_CODE_IMAGES = 123;
    String tenHinhGoc="";
    TextView txtDiem;
    int total =100;
    SharedPreferences luuDiemSo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgGoc = (ImageView) findViewById(R.id.imageView);
        imgNhan =(ImageView) findViewById(R.id.imageView2);
        txtDiem =(TextView) findViewById(R.id.textView2);

        luuDiemSo = getSharedPreferences("DiemSoGame",MODE_PRIVATE);

        //getdiem
        total = luuDiemSo.getInt("diem",100);

        txtDiem.setText(total + "");

        String[] arrTenHinh = getResources().getStringArray(R.array.list_name);
        arrayImgName = new ArrayList<>(Arrays.asList(arrTenHinh));
        //Xao tron mang
        Collections.shuffle(arrayImgName);
        tenHinhGoc = arrayImgName.get(5);
        int idImg = getResources().getIdentifier(arrayImgName.get(5),"drawable",getPackageName());

        imgGoc.setImageResource(idImg);

        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(MainActivity.this, Main2Activity.class),REQUEST_CODE_IMAGES);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_IMAGES && resultCode == RESULT_OK && data != null){

            String tenHinhNhan = data.getStringExtra("tenhinhdachon");
            int idHinhNhan = getResources().getIdentifier(tenHinhNhan,"drawable",getPackageName());
            imgNhan.setImageResource(idHinhNhan);
            if (tenHinhGoc.equals(tenHinhNhan)){
                Toast.makeText(this,"Chinh Xac  \n Bi cong 10 diem", Toast.LENGTH_SHORT).show();
                // cong diem
                total += 10;
                LuuDiem();
                // doi hinh goc
                new CountDownTimer(2000,100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Collections.shuffle(arrayImgName);
                        tenHinhGoc = arrayImgName.get(5);
                        int idImg = getResources().getIdentifier(arrayImgName.get(5),"drawable",getPackageName());

                        imgGoc.setImageResource(idImg);

                    }
                }.start();
            }else {
                Toast.makeText(this,"Sai Roi \n Bi tru 5 diem", Toast.LENGTH_SHORT).show();
                total-=5;
                LuuDiem();
            }
            txtDiem.setText(total + "");
        }

        //kiem tra ma hinh t2 ko chon hinh
        if (requestCode == REQUEST_CODE_IMAGES && resultCode == RESULT_CANCELED){
            Toast.makeText(this,"Ban chua chon hinh, muon xem lai a ? \n Bi tru 15 diem", Toast.LENGTH_SHORT).show();
                total -=15;
                txtDiem.setText(total + "");
                LuuDiem();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.load, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuReload){
            Collections.shuffle(arrayImgName);
            tenHinhGoc = arrayImgName.get(5);
            int idImg = getResources().getIdentifier(arrayImgName.get(5),"drawable",getPackageName());

            imgGoc.setImageResource(idImg);

        }
        return super.onOptionsItemSelected(item);
    }
    private  void LuuDiem(){
        SharedPreferences.Editor editor = luuDiemSo.edit();
        editor.putInt("diem",total);
        editor.commit();
    }
}
