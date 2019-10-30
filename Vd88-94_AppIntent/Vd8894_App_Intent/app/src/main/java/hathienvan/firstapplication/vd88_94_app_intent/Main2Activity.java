package hathienvan.firstapplication.vd88_94_app_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class Main2Activity extends AppCompatActivity {
    TableLayout myTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myTable = (TableLayout) findViewById(R.id.tableLayout);
        int row = 6;
        int col = 3;
        //tron array
        Collections.shuffle(MainActivity.arrayImgName);
        //taodong va cot
        for (int i = 1; i <= row;i++){
            TableRow tableRow = new TableRow(this);
            //tao cot
            for (int j = 1; j<=col; j++){
                final int position = col*(i-1) + j -1;
                ImageView imageView = new ImageView(this);
                Resources r = getResources();
                int px =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,70,r.getDisplayMetrics());
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px,px);


                imageView.setLayoutParams(layoutParams);
                int idImg = getResources().getIdentifier(MainActivity.arrayImgName.get(position),"drawable",getPackageName());

                imageView.setImageResource(idImg);

                //add imageview vao table row
                tableRow.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(Main2Activity.this,MainActivity.arrayImgName.get(position),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhdachon",MainActivity.arrayImgName.get(position));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
            //add table row vao table
            myTable.addView(tableRow);

        }
    }
}
