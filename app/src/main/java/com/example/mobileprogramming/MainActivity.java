package com.example.mobileprogramming;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    Button button1;
    //    ValueHandler handler = new ValueHandler();
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueTask task = new ValueTask();
                task.execute("시작");
            }
        });
//
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    class ValueTask extends AsyncTask<String, Integer, Integer> {
        int value = 0;
        boolean running = false;
        @Override
        protected Integer doInBackground(String... strings) {
            running = true;
            while (running) {
                if (value >= 10) {
                    break;
                }
                value += 1;

                publishProgress(value);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            return value;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            textView.setText("현재값 : " + value);
        }

        @Override
        protected void onPostExecute(Integer s) {
            super.onPostExecute(s);

            Toast.makeText(getApplicationContext(), "완료됨.", Toast.LENGTH_LONG).show();
        }

    }

}