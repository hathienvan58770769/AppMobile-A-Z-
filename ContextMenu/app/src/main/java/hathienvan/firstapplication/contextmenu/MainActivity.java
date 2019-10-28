package hathienvan.firstapplication.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnChooseColor;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChooseColor = (Button) findViewById(R.id.buttonColor);
        layout = (ConstraintLayout) findViewById(R.id.layout);
        //dang ky view cho context menu
        registerForContextMenu(btnChooseColor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Choose Color");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.menuYellow:
                layout.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menuBlue:
                layout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.menuRed:
                layout.setBackgroundColor(Color.RED);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
