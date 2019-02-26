package com.devapps.recyclerview_2_kharismarizqi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("IU33");
        Toast.makeText(this, getSupportActionBar().getTitle(), Toast.LENGTH_SHORT).show();
//        getSupportActionBar().hide();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.lul, new com.devapps.recyclerview_2_kharismarizqi.FragmentList()).
                commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_k, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment destinationFragment = null;
        switch (item.getItemId()) {
            case R.id.mn_fragment1:
                destinationFragment = new com.devapps.recyclerview_2_kharismarizqi.FragmentList();
                break;
            case R.id.mn_fragment2:
                destinationFragment = new com.devapps.recyclerview_2_kharismarizqi.FragmentList2();
                break;
        }

         assert destinationFragment != null;
        fm.beginTransaction().replace(R.id.lul,destinationFragment).addToBackStack("ku").commit();
        return super.onOptionsItemSelected(item);
    }
}
