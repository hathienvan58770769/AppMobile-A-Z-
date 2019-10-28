package hathienvan.firstapplication.menu1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSettings:
                Toast.makeText(this,"You choose Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuEmail:
                Toast.makeText(this,"You choose Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuPhone:
                Toast.makeText(this,"You choose Phone", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuShare:
                Toast.makeText(this,"You choose Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSearch:
                Toast.makeText(this,"You choose Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Toast.makeText(this,"You choose Exit", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
