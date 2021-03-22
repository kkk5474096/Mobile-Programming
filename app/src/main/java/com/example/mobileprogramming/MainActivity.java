package com.example.mobileprogramming;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int status = NetworkStatus.getConnectivityStats(getApplicationContext());
                if (status == NetworkStatus.TYPE_MOBILE) {
                    textView.setText("모바일로 연결됨.");
                } else if (status == NetworkStatus.TYPE_WIFI) {
                    textView.setText("무선랜으로 연결됨.");
                } else {
                    textView.setText("연결 안됨");
                }
            }
        });
    }
}

