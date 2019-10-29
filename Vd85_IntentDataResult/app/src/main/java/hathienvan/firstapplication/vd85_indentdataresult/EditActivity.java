package hathienvan.firstapplication.vd85_indentdataresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText edtName;
    Button btnXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtName = (EditText) findViewById(R.id.editTextNhapTen);
        btnXacNhan = (Button) findViewById(R.id.btnXacNhan);

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameNew = edtName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("tenmoi",nameNew);
                setResult(RESULT_OK,intent);
                finish();//dong hoac ket thuc man hinh hien tai editmain
            }
        });
    }
}
