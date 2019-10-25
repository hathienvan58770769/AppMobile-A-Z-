package hathienvan.firstapplication.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButtonSang, radioButtonTrua, radioButtonToi;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.Radiogroup);
        btn = (Button) findViewById(R.id.button);
        radioButtonSang = (RadioButton) findViewById(R.id.radioButtonSang);
        radioButtonTrua = (RadioButton) findViewById(R.id.radioButtonTrua);
        radioButtonToi = (RadioButton) findViewById(R.id.radioButtonToi);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonSang:
                        Toast.makeText(MainActivity.this, " Ban da chon sang",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonTrua:
                        Toast.makeText(MainActivity.this, " Ban da chon trua",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonToi:
                        Toast.makeText(MainActivity.this, " Ban da chon toi",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonSang.isChecked()){
                    Toast.makeText(MainActivity.this, radioButtonSang.getText(),Toast.LENGTH_SHORT).show();
                }
                if (radioButtonTrua.isChecked()){
                    Toast.makeText(MainActivity.this, radioButtonTrua.getText(),Toast.LENGTH_SHORT).show();
                }
                if (radioButtonToi.isChecked()){
                    Toast.makeText(MainActivity.this, radioButtonToi.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
