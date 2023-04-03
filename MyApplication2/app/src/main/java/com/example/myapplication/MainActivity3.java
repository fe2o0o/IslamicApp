package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity3 extends AppCompatActivity {
    String[] body;
    int index ;
    int pic ;
    VideoView view ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent i = getIntent();
        body = i.getStringArrayExtra("body");
        pic = i.getIntExtra("pic",0);
        TextView one = findViewById(R.id.textView3);
        one.setText(body[0]);
        Button b = findViewById(R.id.button10);
        b.setEnabled(false);
        index = 0;
        setTitle(i.getStringExtra("head"));
        view = findViewById(R.id.videoView);
        if(pic == 1){
            String path = "android.resource://"+getPackageName()+"/"+R.raw.w;
            Uri u = Uri.parse(path);
            view.setVideoURI(u);
            view.start();

        }else{
            String path = "android.resource://"+getPackageName()+"/"+R.raw.p;
            Uri u = Uri.parse(path);
            view.setVideoURI(u);
            view.start();

        }
        new CountDownTimer(300000, 5000) {
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

        int len = body.length;
        Button b = findViewById(R.id.button10);
        b.setEnabled(true);
        index++;
        TextView two = findViewById(R.id.textView3);
        two.setText(body[index]);
        if(index == len-1){
            b = (Button)v;
            b.setEnabled(false);
        }

    }
    public void pre(View v){
        Button b = findViewById(R.id.button11);
        b.setEnabled(true);
        index--;
        TextView two = findViewById(R.id.textView3);
        two.setText(body[index]);
        if(index == 0){
            b = (Button)v;
            b.setEnabled(false);
        }

    }

}