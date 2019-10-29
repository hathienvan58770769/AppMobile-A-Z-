package hathienvan.firstapplication.vd77_transmitreceivestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtKetQua = (TextView) findViewById(R.id.textViewdata);
        // nhan du lieu tu intent
        Intent intent = getIntent();

//        String nd = intent.getStringExtra("dulieustring");
//
//        int number = intent.getIntExtra("dulieunumber",2000);
//
//        String[] arrayExtra = intent.getStringArrayExtra("dulieumang");
//
//        Student student = (Student) intent.getSerializableExtra("dulieudoituong");
//
        //
        Bundle bundle = intent.getBundleExtra("dulieubundle");

        if (bundle!= null){
            String chuoi = bundle.getString("chuoi");
            int so = bundle.getInt("so",123);
            String[] arrayName = bundle.getStringArray("mang");
            Student student = (Student) bundle.getSerializable("doituong");

            txtKetQua.setText("String : "+chuoi
            +"\n Number : " + so + "\n Array : " +arrayName[1]
            + "\n OOP : " + student.getFullName() +" - " + student.getYearOld());
        }




    }
}
