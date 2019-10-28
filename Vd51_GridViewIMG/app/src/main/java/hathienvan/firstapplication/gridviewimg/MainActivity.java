package hathienvan.firstapplication.gridviewimg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvImg;
    ArrayList<Img> imgArrayList;
    ImgAdapter imgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        imgAdapter = new ImgAdapter(this, R.layout.layout_img,imgArrayList);
        gvImg.setAdapter(imgAdapter);
    }

    private void AnhXa() {
        gvImg = (GridView) findViewById(R.id.gridViewImg);
        imgArrayList = new ArrayList<>();
        imgArrayList.add(new Img("Img1", R.drawable.bido));
        imgArrayList.add(new Img("Img2", R.drawable.chanh));
        imgArrayList.add(new Img("Img3", R.drawable.chuoi));
        imgArrayList.add(new Img("Img4", R.drawable.nho));
        imgArrayList.add(new Img("Img5", R.drawable.tao));
        imgArrayList.add(new Img("Img6", R.drawable.thom));
    }
}
