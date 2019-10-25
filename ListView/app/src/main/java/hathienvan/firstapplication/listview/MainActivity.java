package hathienvan.firstapplication.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList;
    ListView lvMonHoc;
    Button btnThem, btnCapNhap;
    EditText edtMonhoc;
    int vitri = -1;
    private void AnhXa(){
        lvMonHoc = (ListView) findViewById(R.id.listView);
        btnThem = (Button) findViewById(R.id.button);
        edtMonhoc = (EditText) findViewById(R.id.editText);
        btnCapNhap = (Button) findViewById(R.id.button2);

    }
    private void ListView(){
        AnhXa();
        arrayList = new ArrayList<>();
        arrayList.add("Android");
        arrayList.add("PHP");
        arrayList.add("IOS");
        arrayList.add("ASP.NET");

        final ArrayAdapter adapter = new
                ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1, arrayList);
        lvMonHoc.setAdapter(adapter);
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position:tra ve vi tri click tren lisst view
                Toast.makeText(MainActivity.this,arrayList.get(position), Toast.LENGTH_SHORT).show();

            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Long click: " + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = edtMonhoc.getText().toString();
                arrayList.add(monHoc);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtMonhoc.setText(arrayList.get(position));
                vitri = position;
            }
        });
        btnCapNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.set(vitri, edtMonhoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView();

    }
}
