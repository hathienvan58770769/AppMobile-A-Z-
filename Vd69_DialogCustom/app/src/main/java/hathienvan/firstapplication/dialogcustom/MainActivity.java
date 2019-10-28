package hathienvan.firstapplication.dialogcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLogin = (TextView) findViewById(R.id.txtClickLogin);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLogin();
            }
        });
    }
    private  void DialogLogin(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);

        final EditText edtUserName = (EditText) dialog.findViewById(R.id.edtUserName);
        final EditText edtPassword = (EditText) dialog.findViewById(R.id.edtPassword);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnCancel);
        Button btnDongY = (Button) dialog.findViewById(R.id.btnYes);
        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (username.equals("tien") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "Dang Nhap Thanh cong",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Dang Nhap That bai",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialog.cancel();
                dialog.dismiss();
            }
        });


        dialog.show();
    }
}
