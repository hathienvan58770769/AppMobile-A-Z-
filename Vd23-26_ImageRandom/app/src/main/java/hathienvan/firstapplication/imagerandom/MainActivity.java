package hathienvan.firstapplication.imagerandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ArrayList<Integer> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.myLayout);

        arrayList = new ArrayList<>();
        arrayList.add(R.drawable.img1);
        arrayList.add(R.drawable.img2);
        arrayList.add(R.drawable.img3);
        arrayList.add(R.drawable.img4);

        Random random = new Random();
        int i = random.nextInt(arrayList.size());

        linearLayout.setBackgroundResource(arrayList.get(i));


    }
}
