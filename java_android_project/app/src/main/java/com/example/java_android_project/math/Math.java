package com.example.loginregister.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loginregister.R;
import com.example.loginregister.pages.MainActivity;

public class Math extends AppCompatActivity {
Button b1;
Button b2;
Button mainPage;
Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        b1=findViewById(R.id.button4);
        b2=findViewById(R.id.button9);
        b3=findViewById(R.id.button5);
        mainPage=findViewById(R.id.buttonMain);
        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Math.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Math.this, MultiplicationExcercise2.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Math.this, MultiplicationExcercise.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Math.this, MultiplicationTable.class);
                startActivity(intent);
            }
        });
    }
}