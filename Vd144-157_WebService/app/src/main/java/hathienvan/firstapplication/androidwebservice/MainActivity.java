package hathienvan.firstapplication.androidwebservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String urlDelete="http://hathienvan.000webhostapp.com/deleted.php";
    String urlGetData = "http://hathienvan.000webhostapp.com/getdatabase.php";
    ListView lvSv;
    ArrayList<SinhVien> arrayListSV;
    SinhVienAdapter sinhVienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSv = (ListView) findViewById(R.id.listViewSV);
        arrayListSV = new ArrayList<>();
        sinhVienAdapter = new SinhVienAdapter(this, R.layout.list_sinh_vien, arrayListSV);
        lvSv.setAdapter(sinhVienAdapter);

        GetData(urlGetData);

    }
    public   void  DeleteSV(final int idsv){
        RequestQueue requestQueue =Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Toast.makeText(MainActivity.this, "Xoa Thanh Cong", Toast.LENGTH_SHORT).show();
                    GetData(urlGetData);

                }else {
                    Toast.makeText(MainActivity.this,"Loi xoa" , Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Xay ra loi", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idCuaSv", String.valueOf(idsv));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_student, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuAddStudent){
            startActivity(new Intent(MainActivity.this, MainAddSVActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private  void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                arrayListSV.clear();
                for (int i =0; i < response.length();i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        arrayListSV.add(new SinhVien(
                                object.getInt("ID"),
                                object.getString("HoTen")
                                ,
                                object.getInt("NamSinh")
                                ,
                                object.getString("DiaChi")
                        ));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                sinhVienAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error+"", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);

    }
//    private void ReadJSON(String url){
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Toast.makeText(MainActivity.this, response + "", Toast.LENGTH_SHORT).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, error+"", Toast.LENGTH_SHORT).show();
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }

}
