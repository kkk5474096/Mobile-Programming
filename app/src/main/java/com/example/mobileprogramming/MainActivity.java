package com.example.mobileprogramming;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mobileprogramming.fragment.Fragment1;
import com.example.mobileprogramming.fragment.Fragment2;
import com.example.mobileprogramming.fragment.Fragment3;
import com.example.mobileprogramming.fragment.FragmentCallback;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements FragmentCallback {


    Fragment1 fragment1;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragment1 != null) {
                    fragment1.onCommandFromActivity("show", "액티비티로부터 전달됨");
                }
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();


    }

    public void onCommand(String command,String data){
        button.setText(data);

    }
}
