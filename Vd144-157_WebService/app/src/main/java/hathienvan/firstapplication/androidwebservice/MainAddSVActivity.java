package hathienvan.firstapplication.androidwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainAddSVActivity extends AppCompatActivity {

    EditText edtHoten, edtNamSinh, edtDiaChi;
    Button btnXacNhan, btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_sv);

        AnhXa();

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoten.getText().toString().trim();
                String namsinh = edtNamSinh.getText().toString().trim();
                String diachi = edtDiaChi.getText().toString().trim();
                if (hoten.isEmpty() || namsinh.isEmpty()|| diachi.isEmpty()){
                    Toast.makeText(MainAddSVActivity.this, "Vui long nhap du thong tin", Toast.LENGTH_SHORT).show();
                }else {
                    AddSinhVien("http://hathienvan.000webhostapp.com/insert.php");
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private  void  AddSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Toast.makeText(MainAddSVActivity.this, "Add Thanh Cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainAddSVActivity.this,MainActivity.class));
                }else {
                    Toast.makeText(MainAddSVActivity.this, "Loi Them", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainAddSVActivity.this, "Xay Ra Loi", Toast.LENGTH_SHORT).show();
                Log.d("AAA","Loi\n : " + error.toString());
            }
        }
     )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("hoten",edtHoten.getText().toString().trim());
                params.put("namsinh",edtNamSinh.getText().toString().trim());
                params.put("diachi",edtDiaChi.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void AnhXa() {
        btnHuy = (Button) findViewById(R.id.buttonCancel);
        btnXacNhan = (Button) findViewById(R.id.buttonUpdate);
        edtHoten = (EditText) findViewById(R.id.editTextEditTen);
        edtNamSinh = (EditText) findViewById(R.id.editTextEditNamSinh);
        edtDiaChi = (EditText) findViewById(R.id.editTextEditDiaChi);
    }
}
