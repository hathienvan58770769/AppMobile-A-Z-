package hathienvan.firstapplication.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtEdit;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anh xa
        txtEdit = (EditText) findViewById(R.id.editText2);
        btnClick = (Button) findViewById(R.id.button2);
        //viet code
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noiDung = txtEdit.getText().toString();
                Toast.makeText(MainActivity.this, noiDung, Toast.LENGTH_LONG).show();
            }
        });
    }
}
