package com.example.mobileprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        Intent passedIntent = getIntent();
        processIntent(passedIntent);


    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra("names");
            if (names != null) {
                Toast.makeText(getApplicationContext(), "전달받은 이름 리스트 개수: " + names.size(), Toast.LENGTH_LONG).show();
            }

            SimpleData data =(SimpleData) intent.getParcelableExtra("data");
            if (data != null) {
                Toast.makeText(getApplicationContext(), "전달받은 SimpleData : " + data.message, Toast.LENGTH_LONG).show();
            }
        }
    }


}
