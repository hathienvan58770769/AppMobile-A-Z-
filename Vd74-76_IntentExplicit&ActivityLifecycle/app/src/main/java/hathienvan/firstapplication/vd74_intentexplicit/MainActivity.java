package hathienvan.firstapplication.vd74_intentexplicit;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btnMain1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMain1 = (Button) findViewById(R.id.button);
        btnMain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        Log.d("AAA","onCreate Main");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA","onStart Main");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA","onRestart Main");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA","onResume Main");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA","onPause Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA","onStop Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA","onDestroy Main");
    }
}
