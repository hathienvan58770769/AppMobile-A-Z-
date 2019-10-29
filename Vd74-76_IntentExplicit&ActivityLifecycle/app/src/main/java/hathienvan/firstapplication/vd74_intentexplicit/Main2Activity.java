package hathienvan.firstapplication.vd74_intentexplicit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {
    Button btnMain2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnMain2 = (Button) findViewById(R.id.button2);

        btnMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.d("AAA","onCreate Main2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA","onStart Main2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA","onRestart Main2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA","onResume Main2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA","onPause Main2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA","onStop Main2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA","onDestroy Main2");
    }
}
