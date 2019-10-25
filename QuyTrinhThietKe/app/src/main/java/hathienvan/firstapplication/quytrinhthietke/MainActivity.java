package hathienvan.firstapplication.quytrinhthietke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtNoiDung;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        txtNoiDung = (TextView) findViewById(R.id.textView);
        btnClick = (Button) findViewById(R.id.button);
        //viet code
        txtNoiDung.setText("Lap trinh Android");
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNoiDung.setText("ok");
            }
        });

    }
}
