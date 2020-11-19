package com.example.mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);

        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {

        Context context;
        Integer[] posterID = { R.drawable.mov1, R.drawable.mov2,
                R.drawable.mov3, R.drawable.mov4, R.drawable.mov5,
                R.drawable.mov6, R.drawable.mov7, R.drawable.mov8,
                R.drawable.mov9, R.drawable.mov10 };
        String[] posterName = { "반도", "아이언맨3",
                "어벤져스", "어바웃타임", "인터스텔라",
                "다크나이트 라이즈", "토르: 천둥의신", "부산행",
                "괴물", "도둑들" };

        public MyGalleryAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);
            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);

                    Toast toast = new Toast(MainActivity.this);
                    View toastView = View.inflate(MainActivity.this, R.layout.toast1, null);
                    TextView toastText = toastView.findViewById(R.id.toastText1);
                    toastText.setText(posterName[pos]);
                    toast.setView(toastView);
                    toast.show();
                    return false;
                }
            });

            return imageview;
        }
    }
}
