package hathienvan.firstapplication.vd131_136_sqlitetodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView listViewCv;
    ArrayList<CongViec> arrCV;
    CongViecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCv = (ListView) findViewById(R.id.listViewCongViec);
        arrCV = new ArrayList<>();
        adapter = new CongViecAdapter(this, R.layout.dong_cong_viec, arrCV);
        listViewCv.setAdapter(adapter);

        //tao database GhiChu
        database = new Database(this, "ghichu.sqlite",null, 1 );
        //tao bang  CongViec
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");
        // insert database
//        database.QueryData("INSERT INTO CongViec VALUES(null, 'Lam bai tap database android ghi chu')");
        GetDataCv();

    }
    public void DialogDeleteCV (final String tencv, final int id){
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(this);
        dialogDelete.setMessage("Ban co muon xoa cv "+tencv+" ko?");
        dialogDelete.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("DELETE FROM CongViec WHERE Id = '"+id+"'");
                Toast.makeText(MainActivity.this, "Da xoa" + tencv, Toast.LENGTH_SHORT).show();
                GetDataCv();
            }
        });
        dialogDelete.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogDelete.show();
    }
    public  void DialogUpdateCV(String tenCV, final int id){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update);

        final EditText edtUpdateTenCv = (EditText) dialog.findViewById(R.id.editUpddateTenCv);
        Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        edtUpdateTenCv.setText(tenCV);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenMOI = edtUpdateTenCv.getText().toString().trim();
                database.QueryData("UPDATE CongViec SET TenCV = '"+tenMOI +"' WHERE Id = '"+id+"'");
                dialog.dismiss();
                GetDataCv();
            }
        });

        dialog.show();
    }
    private void GetDataCv(){
        //select database
        Cursor dataCongViec  = database.GetDatabase("SELECT * FROM CongViec");
        arrCV.clear();
        while (dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            arrCV.add(new CongViec(id, ten));
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add_cong_viec, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAdd){
            DialogAdd();
        }

        return super.onOptionsItemSelected(item);
    }
    private  void  DialogAdd(){
        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//bo title
        dialog.setContentView(R.layout.dialog_add);

        final EditText editAddten = (EditText) dialog.findViewById(R.id.editTextAddTenCV);
        Button btnSave = (Button) dialog.findViewById(R.id.buttonSave);
        Button btnCancel = (Button) dialog.findViewById(R.id.buttonCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tencv = editAddten.getText().toString();
                if (tencv.equals("")){
                    Toast.makeText(MainActivity.this, "Vui long nhap ten cv",Toast.LENGTH_SHORT).show();
                }else {
                    database.QueryData("INSERT INTO CongViec VALUES(null, '"+ tencv +"')");
                    Toast.makeText(MainActivity.this,"da them", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetDataCv();
                }
            }
        });
        dialog.show();
    }
}
