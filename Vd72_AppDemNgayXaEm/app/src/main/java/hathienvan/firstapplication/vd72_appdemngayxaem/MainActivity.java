package hathienvan.firstapplication.vd72_appdemngayxaem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnTinhDate;
    EditText edtDate1, edtDate2;
    TextView txtResult;

    Calendar calendarFirst, calendarSecond;

    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        edtDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDate1();
            }
        });
        edtDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDate2();
            }
        });
        btnTinhDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ngayXaNhau = (int) (calendarSecond.getTimeInMillis() - calendarFirst.getTimeInMillis())/(1000*60*60*24);
                txtResult.setText("So Ngay Xa Nhau la : " + ngayXaNhau);
            }
        });
    }
    private void  ChooseDate1(){
        calendarFirst = Calendar.getInstance();
        int ngay = calendarFirst.get(Calendar.DATE);
        int thang = calendarFirst.get(Calendar.MONTH);
        int nam = calendarFirst.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarFirst.set(year,month,dayOfMonth);
                edtDate1.setText(simpleDateFormat.format(calendarFirst.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();

    }
    private void  ChooseDate2(){
        calendarSecond = Calendar.getInstance();
        int ngay = calendarSecond.get(Calendar.DATE);
        int thang = calendarSecond.get(Calendar.MONTH);
        int nam = calendarSecond.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarSecond.set(year,month,dayOfMonth);
                edtDate2.setText(simpleDateFormat.format(calendarSecond.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void AnhXa() {
        btnTinhDate = (Button) findViewById(R.id.btnTinhDate);
        edtDate1 = (EditText) findViewById(R.id.editTextDateFirst);
        edtDate2 = (EditText) findViewById(R.id.editTextDateSecond);
        txtResult = (TextView) findViewById(R.id.textViewResult);

    }
}
