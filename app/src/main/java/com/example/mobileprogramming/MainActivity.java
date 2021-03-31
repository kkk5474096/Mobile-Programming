package com.example.mobileprogramming;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    ArrayList<Drawable> imageList = new ArrayList<Drawable>();
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        Resources res = getResources();
        imageList.add(res.getDrawable(R.drawable.kim));
        imageList.add(res.getDrawable(R.drawable.duk));
        imageList.add(res.getDrawable(R.drawable.sun));
        imageList.add(res.getDrawable(R.drawable.iu));
        imageList.add(res.getDrawable(R.drawable.web));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testThread testThread = new testThread();
                testThread.start();
            }
        });
    }

    class testThread extends Thread {
        public void run() {
            int index = 0;
            for (int i = 0; i < 100; i++) {
                index = i % 5;
                final Drawable drawable = imageList.get(index);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageDrawable(drawable);
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }
        }
    }
}

