package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class signIn extends AppCompatActivity {
    EditText text;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setTitle("Islamic App");
        text = findViewById(R.id.editText1);
        pass = findViewById(R.id.Password1);
    }
    public void signIn(View v){
        String x = text.getText().toString() +","+ pass.getText().toString()+",";
        TextView y = findViewById(R.id.textView5);
        if(Check()){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else{
            y.setText("بيانات غير صحيحة");
        }



    }
    public void signUp(View v){
        Intent i = new Intent(this, signUp.class);
        startActivity(i);
    }

    private String read(){
        String outPut = "";
        try {
            InputStream inputStream = openFileInput("myfile.txt");
            if(inputStream != null){
                InputStreamReader read = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(read);
                String temp = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null){
                    stringBuilder.append(temp);
                }
                inputStream.close();
                outPut = stringBuilder.toString();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return outPut;
    }
    private boolean Check(){
        String x = read();
        String [] stored = x.split(",");
        int len = stored.length;
        for(int i = 0 ; i<len ; i = i + 2){
            if(text.getText().toString().equals(stored[i])){
                if(pass.getText().toString().equals(stored[i+1])){
                    return true;
                }
            }
        }
        return false;
    }
}