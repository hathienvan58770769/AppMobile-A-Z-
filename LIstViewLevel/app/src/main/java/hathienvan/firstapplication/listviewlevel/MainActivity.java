package hathienvan.firstapplication.listviewlevel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvtraiCay;
    ArrayList<TraiCay> traiCayArrayList ;
    TraiCayAdapter traiCayAdapter;

    private void AnhXa(){
        lvtraiCay = (ListView) findViewById(R.id.listViewTraiCay);
        traiCayArrayList = new ArrayList<>();

        traiCayArrayList.add(new TraiCay("Dau Tay", "Dau Tay da Lat",R.drawable.bido));
        traiCayArrayList.add(new TraiCay("Tao", "Tao da Lat",R.drawable.tao));
        traiCayArrayList.add(new TraiCay("Nho", "Nho da Lat",R.drawable.nho));
        traiCayArrayList.add(new TraiCay("Chuoi", "chuoi da Lat",R.drawable.chuoi));
        traiCayArrayList.add(new TraiCay("Dau Tay", "Dau Tay da Lat",R.drawable.chanh));
        traiCayArrayList.add(new TraiCay("Dau Tay", "Dau Tay da Lat",R.drawable.thom));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        traiCayAdapter = new TraiCayAdapter(this,R.layout.dong_trai_cay,traiCayArrayList);
        lvtraiCay.setAdapter(traiCayAdapter);
    }
}
