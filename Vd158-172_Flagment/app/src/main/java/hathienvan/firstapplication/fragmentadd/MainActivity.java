package hathienvan.firstapplication.fragmentadd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        FragmentA fragmentA = new FragmentA();
//        FragmentB fragmentB = new FragmentB();
//        fragmentTransaction.add(R.id.franelayout, fragmentA);
//        fragmentTransaction.add(R.id.franelayout, fragmentB);
        fragmentTransaction.commit();
    }
}
