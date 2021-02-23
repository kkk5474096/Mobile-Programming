package com.example.mobileprogramming.Sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobileprogramming.R;

public class SmsActivity extends AppCompatActivity {

    EditText edit_text, edit_time, edit_number;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edit_number = (EditText) findViewById(R.id.edit_number);
        edit_text = (EditText) findViewById(R.id.edit_text);
        edit_time = (EditText) findViewById(R.id.edit_time);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent passedIntent = getIntent();
        processCommand(passedIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(intent);
        super.onNewIntent(intent);
    }

    private void processCommand(Intent intent) {
        if (intent != null) {
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receivedDate = intent.getStringExtra("receivedDate");

            edit_number.setText(sender);
            edit_text.setText(contents);
            edit_time.setText(receivedDate);
        }

    }
}