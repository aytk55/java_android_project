package com.example.loginregister.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginregister.R;
import com.example.loginregister.pages.MainActivity;

import java.util.Random;

public class MultiplicationExcercise extends AppCompatActivity {
TextView ch;
TextView Score;
TextView True;
TextView False;
TextView question;
EditText ans;
Button checkButton;
ImageView checkImage;
    Integer score;
    Integer doğrucevap = 0;
    Integer yanlışcevap=0;
    Integer time=30;
String s;
Integer correctans;
private Handler handler;
private Runnable runnable;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_excercise);
        Score=findViewById(R.id.score);
        ch=findViewById(R.id.chrono);
        True=findViewById(R.id.doğru);
        False=findViewById(R.id.yanlış);
        question=findViewById(R.id.soru);
        ans=findViewById(R.id.cevap);
        checkButton=findViewById(R.id.checkButton);
        checkImage=findViewById(R.id.checkImage);
startFunction();

        int i = random.nextInt(10) + 1;
        int j = random.nextInt(10) + 1;
        s = i + "X" + j;
        question.setText(s);
        correctans=i*j;


        checkButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                if (ans.getText().toString().equals(String.valueOf(correctans))) {
                    doğrucevap++;
                    checkImage.setImageResource(R.drawable.done);
                    checkImage.setVisibility(View.VISIBLE);
                } else {
                    yanlışcevap++;
                    checkImage.setImageResource(R.drawable.close);
                    checkImage.setVisibility(View.VISIBLE);
                }
                True.setText(String.valueOf(doğrucevap));
                False.setText(String.valueOf(yanlışcevap));

                Random random = new Random();
                int i = random.nextInt(10) + 1;
                int j = random.nextInt(10) + 1;
                String s = i + "X" + j;
                question.setText(s);
                correctans=i*j;

                score=doğrucevap*10-yanlışcevap*5;
                Score.setText("Score : "+score.toString());
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                       checkImage.setVisibility(View.GONE);

                    }
                },1000);









            }










        });
    }    private void chrono() {
        time--;
        ch.setText(time.toString());
    }

    private void startFunction() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (time == 0) {
                    Intent intent = new Intent(MultiplicationExcercise.this, MainActivity.class);
                    Toast.makeText(MultiplicationExcercise.this, "Score = " + score, Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                } else {
                    chrono();
                    handler.postDelayed(this, 1000);
                }
            }
        };

        handler.postDelayed(runnable, 1000);
    }
}

