package hathienvan.firstapplication.vd113_114_jsonlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageButton ibtnEN , ibtnVN;
    TextView txtInfo;
    String noiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        new ReadJSON().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");

        ibtnVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadJSONLanguage("vn");
            }
        });
        ibtnEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadJSONLanguage("en");
            }
        });

    }
    private  class ReadJSON extends AsyncTask<String,Void,String>{
        StringBuilder content =  new StringBuilder();
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";

                while ((line=bufferedReader.readLine())!= null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            noiDung =s;
            ReadJSONLanguage("vn");

        }
    }
    private void   ReadJSONLanguage (String language){
        try {
            JSONObject object = new JSONObject(noiDung);
            JSONObject objectLanguage = object.getJSONObject("language");
            JSONObject objectVn = objectLanguage.getJSONObject(language);
            String ten = objectVn.getString("name");
            String diachi = objectVn.getString("address");
            String khoahoc1 = objectVn.getString("course1");
            String khoahoc2 = objectVn.getString("course2");
            String khoahoc3 = objectVn.getString("course3");

            txtInfo.setText(ten+"\n"+diachi+"\n"+khoahoc1 +"\n"+ khoahoc2+"\n"+ khoahoc3);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void AnhXa() {
        ibtnEN = (ImageButton) findViewById(R.id.imageButtonEnglish);
        ibtnVN = (ImageButton) findViewById(R.id.imageButtonVietnam);
        txtInfo = (TextView) findViewById(R.id.textViewInfo);
    }
}
