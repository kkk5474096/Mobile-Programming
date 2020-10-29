package com.example.mobileprogramming;

import java.io.File;

import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    TextView tv_number;
    int curNum, length;
    File[] imageFiles;
    String imageFname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("핸드폰 이미지 뷰어");
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        tv_number = (TextView) findViewById(R.id.tv_number);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);

        imageFiles = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()+"/Pictures").listFiles();
        length = imageFiles.length;
        imageFname = imageFiles[0].toString();
        myPicture.imagePath=imageFname;

        tv_number.setText((curNum + 1) + "/" + length);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum == 0) {
                    curNum = imageFiles.length - 1;
                } else {
                    curNum--;
                }
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                tv_number.setText((curNum + 1) + "/" + length);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum == imageFiles.length - 1) {
                    curNum = 0;
                } else {
                    curNum++;
                }
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                tv_number.setText((curNum + 1) + "/" + length);
            }
        });

    }
}