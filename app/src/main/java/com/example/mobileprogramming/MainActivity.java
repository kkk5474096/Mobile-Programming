package com.example.mobileprogramming;

import android.os.Bundle;
import android.view.MenuItem;
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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentCallback {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onFragmentSelected(int position, Bundle bundle) {
        Fragment curFragment = null;

        if (position == 0) {
            curFragment = fragment1;
            toolbar.setTitle("첫번째 화면");
        } else if (position == 1) {
            curFragment = fragment2;
            toolbar.setTitle("두번째 화면");
        } else if (position == 2) {
            curFragment = fragment3;
            toolbar.setTitle("세번째 화면");
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
    }


    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_1) {
            Toast.makeText(this,"첫번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragmentSelected(0, null);
        } else if (id == R.id.nav_2) {
            Toast.makeText(this,"두번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragmentSelected(1, null);
        } else if (id == R.id.nav_3) {
            Toast.makeText(this,"세번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragmentSelected(2, null);
        }
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
