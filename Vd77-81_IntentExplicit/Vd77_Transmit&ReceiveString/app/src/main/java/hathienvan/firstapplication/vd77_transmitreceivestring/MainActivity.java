package hathienvan.firstapplication.vd77_transmitreceivestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) findViewById(R.id.buttonData);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //
//                intent.putExtra("dulieustring", "Noi dung chuoi");
//                //
//                intent.putExtra("dulieunumber", 2019);
//                //
//                String[] arrayCourse = {"Android", "PHP", "JAVA", "ASP.NET", "NodeJS"};
//                intent.putExtra("dulieumang",arrayCourse);
//                //
//                Student student = new Student("Thien Van",1999);
//                intent.putExtra("dulieudoituong",  student);
                //
                Bundle bundle = new Bundle();
                bundle.putString("chuoi","Van Map");
                bundle.putInt("so",12345);

                String[] arrayName = {"a","b","c","d"};
                bundle.putStringArray("mang",arrayName);

                Student hs = new Student("ABC",2005);
                bundle.putSerializable("doituong",hs);

                intent.putExtra("dulieubundle",bundle);

                startActivity(intent);
            }
        });
    }
}
