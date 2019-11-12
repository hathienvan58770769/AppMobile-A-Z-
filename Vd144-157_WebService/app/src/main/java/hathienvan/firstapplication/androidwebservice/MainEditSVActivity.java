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

public class MainEditSVActivity extends AppCompatActivity {

    EditText edtHoten, edtNamSinh, edtDiaChi;
    Button btnUpdate, btnCancel;
    int id =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit_sv);

        Intent intent =getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("dataSinhVien");

        AnhXa();

        edtHoten.setText(sinhVien.getHoTen());
        edtNamSinh.setText(sinhVien.getNamSinh()+ "");
        edtDiaChi.setText(sinhVien.getDiaChi());


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoten.getText().toString().trim();
                String namsinh = edtNamSinh.getText().toString().trim();
                String diachi = edtDiaChi.getText().toString().trim();
                if (hoten.matches("") || namsinh.equals("")|| diachi.length() == 0){
                    Toast.makeText(MainEditSVActivity.this, "Vui long nhap du thong tin", Toast.LENGTH_SHORT).show();
                }else {
                    EditSinhVien("http://hathienvan.000webhostapp.com/update.php");
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private  void  EditSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")){
                            Toast.makeText(MainEditSVActivity.this, "Update Thanh Cong", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainEditSVActivity.this,MainActivity.class));
                        }else {
                            Toast.makeText(MainEditSVActivity.this, "Loi Them", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainEditSVActivity.this, "Xay Ra Loi, vui long thu lai", Toast.LENGTH_SHORT).show();
                Log.d("AAA","Loi\n : " + error.toString());
            }
        }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idSV",String.valueOf(id));
                params.put("hotenSV",edtHoten.getText().toString().trim());
                params.put("namsinhSV",edtNamSinh.getText().toString().trim());
                params.put("diachiSV",edtDiaChi.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void AnhXa() {
        btnCancel = (Button) findViewById(R.id.buttonCancel);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        edtHoten = (EditText) findViewById(R.id.editTextEditTen);
        edtNamSinh = (EditText) findViewById(R.id.editTextEditNamSinh);
        edtDiaChi = (EditText) findViewById(R.id.editTextEditDiaChi);
    }
}
