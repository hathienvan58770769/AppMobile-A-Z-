package hathienvan.firstapplication.vd85_indentdataresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView txtName;
    Button btnEdit;
    int REQUES_CODE_EDIT = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (TextView) findViewById(R.id.txtTD);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EditActivity.class);

                startActivityForResult(intent,REQUES_CODE_EDIT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUES_CODE_EDIT && resultCode == RESULT_OK && data != null){
            String name = data.getStringExtra("tenmoi");
            txtName.setText(name);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
