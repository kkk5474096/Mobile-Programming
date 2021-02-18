package com.example.mobileprogramming;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate() 호출됨");

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("MainActivity", "onStart() 호출됨");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("MainActivity", "onStop() 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("MainActivity", "onDestroy() 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("MainActivity", "onPause() 호출됨");

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", "소녀시대");
        editor.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("MainActivity", "onResume() 호출됨");

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if( pref != null) {
            String name = pref.getString("name" , "");

            Log.d("MainActivity", "복구된 이름 : " + name);

        }

    }
}