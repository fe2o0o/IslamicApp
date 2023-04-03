package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    String[] title;
    String[] body;
    int index ;
    int pic ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        title = i.getStringArrayExtra("title");
        body = i.getStringArrayExtra("body");
        pic = i.getIntExtra("pic",0);
        TextView one = findViewById(R.id.textView);
        one.setText(title[0]);
        TextView two = findViewById(R.id.textView2);
        two.setText(body[0]);
        Button b = findViewById(R.id.button7);
        b.setEnabled(false);
        index = 0;
        setTitle(i.getStringExtra("head"));
        if(pic == 1){
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.pic1);
        }
        new CountDownTimer(300000, 3000) {
            boolean first = true;
            @Override
            public void onTick(long l) {
                if(first){
                    first = false;
                }else {
                    next(findViewById(R.id.button));
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();



    }
    public void next(View v){

        int len = title.length;
        if(index == len-1){
            return;
        }
        Button b = findViewById(R.id.button7);
        b.setEnabled(true);
        index++;
        TextView one = findViewById(R.id.textView);
        one.setText(title[index]);
        TextView two = findViewById(R.id.textView2);
        two.setText(body[index]);
        if(index == len-1){
            b = (Button)v;
            b.setEnabled(false);
        }
        if(pic == 1){
            loadImg2(index);
        } else if (pic == 2) {
            loadImg(index);
        }


    }

    public void pre(View v){
        Button b = findViewById(R.id.button);
        b.setEnabled(true);
        index--;
        TextView one = findViewById(R.id.textView);
        one.setText(title[index]);
        TextView two = findViewById(R.id.textView2);
        two.setText(body[index]);
        if(index == 0){
            b = (Button)v;
            b.setEnabled(false);
        }
        if(pic == 1){
            loadImg2(index);
        } else if (pic == 2) {
            loadImg(index);
        }


    }
    public void loadImg(int i){
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        switch (i){
            case 0: imageView.setImageResource(R.drawable.logo);
                     break ;
            case 1: imageView.setImageResource(R.drawable.img1);
                     break ;
            case 2: imageView.setImageResource(R.drawable.img2);
                break ;
            case 3: imageView.setImageResource(R.drawable.img3);
                break ;
            case 4: imageView.setImageResource(R.drawable.logo);
                break ;
            case 5: imageView.setImageResource(R.drawable.img4);
                break ;
            case 6: imageView.setImageResource(R.drawable.img5);
                break ;
            case 7: imageView.setImageResource(R.drawable.img6);
                break ;
            case 8: imageView.setImageResource(R.drawable.img7);
                break ;
            case 9: imageView.setImageResource(R.drawable.img8);
                break ;
            case 10: imageView.setImageResource(R.drawable.img9);
                break ;
            case 11: imageView.setImageResource(R.drawable.img10);
                break ;
            case 12: imageView.setImageResource(R.drawable.img11);
                break ;
            case 13: imageView.setImageResource(R.drawable.img12);
                break ;


        }
    }
    public void loadImg2(int i){
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        switch (i){
            case 0: imageView.setImageResource(R.drawable.pic1);
                break ;
            case 1: imageView.setImageResource(R.drawable.pic2);
                break ;
            case 2: imageView.setImageResource(R.drawable.pic3);
                break ;
            case 3: imageView.setImageResource(R.drawable.pic4);
                break ;
            case 4: imageView.setImageResource(R.drawable.pic5);
                break ;
            case 5: imageView.setImageResource(R.drawable.pic6);
                break ;
            case 6: imageView.setImageResource(R.drawable.pic7);
                break ;
            case 7: imageView.setImageResource(R.drawable.pic8);
                break ;
            case 8: imageView.setImageResource(R.drawable.pic9);
                break ;
            case 9: imageView.setImageResource(R.drawable.logo);
                break ;



        }
    }

}