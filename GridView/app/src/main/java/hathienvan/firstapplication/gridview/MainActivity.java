package hathienvan.firstapplication.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gridViewTen;
    String[] arrayName =
            {"A","B","C","D","E","F","G","H","I","K"
                    ,"L","M","N","R","O","U","X","S",
                    "Z","J","P","Q","W","T","Y"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewTen = (GridView) findViewById(R.id.gridViewTraiCay);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayName);
        gridViewTen.setAdapter(adapter);
    }
}
