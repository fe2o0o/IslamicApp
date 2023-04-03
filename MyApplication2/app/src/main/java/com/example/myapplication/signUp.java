package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class signUp extends AppCompatActivity {
    EditText text;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Islamic App");
        text = findViewById(R.id.editText2);
        pass = findViewById(R.id.Password2);
    }
    private void write(String x){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("myfile.txt", Context.MODE_APPEND));
            outputStreamWriter.write(x);
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void signUP(View v){
        String x = text.getText().toString() +","+ pass.getText().toString()+",";
        write(x);
        Intent i = new Intent(this, signIn.class);
        startActivity(i);
    }
}