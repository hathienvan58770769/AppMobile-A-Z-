package hathienvan.firstapplication.appword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtThongTin;
    Button btnXacNhan;
    EditText edtTen, edtSdt, edtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = edtTen.getText().toString();
                String email = edtEmail.getText().toString();
                String sDT = edtSdt.getText().toString();

                String textChaoBan = getResources().getString(R.string.txt_ChaoBan);
                String textEmail = getResources().getString(R.string.txt_Email);
                String textSDT = getResources().getString(R.string.txt_SDT);
                txtThongTin.setText(textChaoBan+ ": " +hoTen +
                        "\n" + textEmail + ": " + email +
                        "\n " + textSDT + ": " + sDT);
            }
        });
    }
    private void AnhXa(){
        btnXacNhan = (Button) findViewById(R.id.button);
        txtThongTin = (TextView) findViewById(R.id.textView2);
        edtTen = (EditText) findViewById(R.id.editText);
        edtEmail = (EditText) findViewById(R.id.editText2);
        edtSdt = (EditText) findViewById(R.id.editText3);
    }
}
