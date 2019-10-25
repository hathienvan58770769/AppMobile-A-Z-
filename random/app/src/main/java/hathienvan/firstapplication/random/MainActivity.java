package hathienvan.firstapplication.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText numberOne;
    EditText numberTwo;
    TextView txtResult;
    Button btnRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        //viet cide
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string1 = numberOne.getText().toString().trim();
                String string2 = numberTwo.getText().toString().trim();
                //
                if (string1.isEmpty() || string2.isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui long Nhap Du So",Toast.LENGTH_SHORT).show();

                }else {
                    //Tao Khoang Random
                    int min = Integer.parseInt(string1);
                    int max = Integer.parseInt(string2);

                    Random random = new Random();
                    int result = random.nextInt(max - min + 1) + min;
                    txtResult.setText(String.valueOf(result));
                }

            }
        });
    }
    private void AnhXa(){
        //anh xa
        txtResult = (TextView) findViewById(R.id.textView);
        numberOne = (EditText) findViewById(R.id.edit);
        numberTwo = (EditText) findViewById(R.id.editText1);
        btnRandom = (Button) findViewById(R.id.button);

    }
}

