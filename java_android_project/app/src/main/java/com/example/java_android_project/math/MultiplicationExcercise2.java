package com.example.loginregister.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginregister.R;
import com.example.loginregister.pages.MainActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MultiplicationExcercise2 extends AppCompatActivity {


    Handler handler=new Handler();

    Integer trueAns=0;
    Integer falseAns=0;
    TextView countDownText;
    Integer timeLeftInSeconds=30;
    Button b1,b2,b3,b4;
    TextView tv,tvD,tvF;

    Integer firstNum;
    Integer secondNum;
    Integer ans;

    Integer badAns1;
    Integer badAns2;
    Integer badAns3;
    Integer[] answers= new Integer[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_excercise2);
        countDownText = findViewById(R.id.TextTime);
        tv = findViewById(R.id.textView);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        tvD=findViewById(R.id.textView2);
        tvF=findViewById(R.id.textView3);


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                timeLeftInSeconds--;
                updateCountdownText();
                if (timeLeftInSeconds > 0) {

                    handler.postDelayed(this,1000);

                } else {
                    Intent intent=new Intent(MultiplicationExcercise2.this, MainActivity.class);
                    startActivity(intent);

                    Toast.makeText(MultiplicationExcercise2.this, "Time is up you have "+trueAns+"true answer and "+falseAns+"false answer" , Toast.LENGTH_SHORT).show();
                }
            }
        };
        handler.postDelayed(runnable,1000);

        setButtons();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate((Button) view);
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setBackgroundWhite();

                        setButtons();


                    }
                },1000);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate((Button) view);

                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setBackgroundWhite();

                        setButtons();


                    }
                },1000);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate((Button) view);
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setBackgroundWhite();

                        setButtons();


                    }
                },1000);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate((Button) view);
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setBackgroundWhite();

                        setButtons();


                    }
                },1000);
            }
        });


    }

    private void updateCountdownText() {
        countDownText.setText(timeLeftInSeconds.toString());
    }

    private void setButtons() {

        Random random=new Random();
        firstNum= random.nextInt(11);
        secondNum= random.nextInt(11);

        tv.setText(firstNum+"X"+secondNum);
        ans=firstNum*secondNum;
        badAns1=random.nextInt(100);
        badAns2=random.nextInt(100);
        badAns3=random.nextInt(100);
        answers[0]=ans;
        answers[1]=badAns1;
        answers[2]=badAns2;
        answers[3]=badAns3;

        Collections.shuffle(Arrays.asList(answers));
        if (badAns1==ans||badAns2==ans||badAns3==ans){
            badAns1=random.nextInt(100);
            badAns2=random.nextInt(100);
            badAns3=random.nextInt(100);
        } else{

            b1.setText(answers[0].toString());
            b2.setText(answers[1].toString());
            b3.setText(answers[2].toString());
            b4.setText(answers[3].toString());
        }
    }

    private void calculate(Button b) {
        if(b.getText()==ans.toString()){
            b.setBackgroundColor(Color.GREEN);
            trueAns++;
            tvD.setText(trueAns.toString());
        }
        else{
            b.setBackgroundColor(Color.RED);
            falseAns++;
            tvF.setText(falseAns.toString());
        }


    }
    private void setBackgroundWhite(){
        b1.setBackgroundColor(Color.WHITE);
        b2.setBackgroundColor(Color.WHITE);
        b3.setBackgroundColor(Color.WHITE);
        b4.setBackgroundColor(Color.WHITE);
    }


}