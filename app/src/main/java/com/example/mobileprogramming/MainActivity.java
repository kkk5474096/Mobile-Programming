package com.example.mobileprogramming;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView sun, duk;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sun = (ImageView) findViewById(R.id.sun);
        duk = (ImageView) findViewById(R.id.duk);

    }

    public void buttonClicked(View v) {
            index += 1;
            if (index > 1) {
                index = 0;
            }

            if (index == 0) {
                sun.setVisibility(View.VISIBLE);
                duk.setVisibility(View.INVISIBLE);
            } else if (index == 1) {
                sun.setVisibility(View.INVISIBLE);
                duk.setVisibility(View.VISIBLE);
            }
        }

    }

