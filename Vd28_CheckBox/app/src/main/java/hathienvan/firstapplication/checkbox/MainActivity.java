package hathienvan.firstapplication.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cbAndroid, cbIOS, cbJAVA;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = "Ban Da Chon Mon Hoc : \n";
                if (cbAndroid.isChecked()){
                    monHoc += cbAndroid.getText() + "\n";
                }
                if (cbIOS.isChecked()){
                    monHoc += cbIOS.getText()+ "\n";
                }
                if (cbJAVA.isChecked()){
                    monHoc += cbJAVA.getText()+ "\n";
                }
            Toast.makeText(MainActivity.this, monHoc, Toast.LENGTH_SHORT).show();

            }
        });

        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, " Ban da chon Android ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, " Ban bo chon Android ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void AnhXa(){
        cbAndroid = (CheckBox) findViewById(R.id.checkBoxAndroid);
        cbIOS = (CheckBox) findViewById(R.id.checkBoxIOS);
        cbJAVA = (CheckBox) findViewById(R.id.checkBoxJAVA);
        btn = (Button) findViewById(R.id.button);
    }
}
