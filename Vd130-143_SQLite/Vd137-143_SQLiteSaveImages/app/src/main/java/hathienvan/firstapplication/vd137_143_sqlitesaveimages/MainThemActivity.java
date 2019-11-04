package hathienvan.firstapplication.vd137_143_sqlitesaveimages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainThemActivity extends AppCompatActivity {

    Button btnSave, btnCancel;
    ImageButton imgCamera, imgFolder;
    ImageView imgHinh;
    EditText edtTen,edtMota;
    final int REQUEST_CODE_CAMERA =123;
    final int REQUEST_CODE_FOLDER = 456;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_them);

        AnhXa();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyen data imageView -> byte[]
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgHinh.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100, byteArray);//chat luong anh cang thap cang tot tu 1 -> 100 mac dinh 100
                byte[] hinhanh = byteArray.toByteArray();


                MainActivity.database.INSERT_DOVAT(edtTen.getText().toString().trim(),edtMota.getText().toString().trim(), hinhanh );
                Toast.makeText(MainThemActivity.this, "Da them image", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainThemActivity.this, MainActivity.class));

            }
        });

        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, REQUEST_CODE_CAMERA);
                ActivityCompat.requestPermissions
                        (MainThemActivity.this, new String[]
                                {Manifest.permission.CAMERA},REQUEST_CODE_CAMERA);

            }
        });
        imgFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent,REQUEST_CODE_FOLDER);
                ActivityCompat.requestPermissions
                        (MainThemActivity.this, new String[]
                                {Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_FOLDER);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_CAMERA:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CODE_CAMERA);
                }else {
                    Toast.makeText(this, "Ban ko cho phep mo camera", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_FOLDER:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, REQUEST_CODE_FOLDER);
                }else {
                    Toast.makeText(this, "Ban ko cho phep mo folder image", Toast.LENGTH_SHORT).show();
                }
                break;

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data !=null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgHinh.setImageBitmap(bitmap);
        }
        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data !=null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgHinh.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void AnhXa() {
        btnSave = (Button) findViewById(R.id.buttonSave);
        btnCancel = (Button) findViewById(R.id.buttonCancel);
        imgCamera = (ImageButton) findViewById(R.id.imageButtonCamera);
        imgFolder = (ImageButton) findViewById(R.id.imageButtonFolder);
        imgHinh = (ImageView) findViewById(R.id.imageViewHinhCustom);
        edtTen = (EditText) findViewById(R.id.editTextNhapTen);
        edtMota = (EditText) findViewById(R.id.editTextMota);

    }
}
