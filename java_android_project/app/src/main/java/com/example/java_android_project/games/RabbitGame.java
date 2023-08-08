package com.example.loginregister.games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginregister.R;
import com.example.loginregister.pages.MainActivity;

import java.util.Random;

public class RabbitGame extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    TextView tvScore,timer;
    ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12;
    ImageView[] imageViews;

    Integer score=0;
    Integer time=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabbit_game);
        tvScore=findViewById(R.id.textView);
        timer=findViewById(R.id.textView4);
        iv1=findViewById(R.id.imageView3);
        iv2=findViewById(R.id.imageView4);
        iv3=findViewById(R.id.imageView5);
        iv4=findViewById(R.id.imageView6);
        iv5=findViewById(R.id.imageView7);
        iv6=findViewById(R.id.imageView8);
        iv7=findViewById(R.id.imageView9);
        iv8=findViewById(R.id.imageView10);
        iv9=findViewById(R.id.imageView11);
        iv10=findViewById(R.id.imageView12);
        iv11=findViewById(R.id.imageView13);
        iv12=findViewById(R.id.imageView14);

        imageViews=new ImageView[]{iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12};

        hideImages();

        Handler handler = new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                if(time==0){
                    Intent intent=new Intent(RabbitGame.this, MainActivity.class);
                    startActivity(intent);


                    Toast.makeText(RabbitGame.this, " Score  = "+score, Toast.LENGTH_SHORT).show();
                    finish();
                }

                timer.setText(time.toString());
                time--;
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);

    }
    public void gainScore(View view){
        score++;
        tvScore.setText("Score : "+ score);
    }

    public void hideImages(){
        handler = new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView imageView:imageViews){
                    imageView.setVisibility(View.INVISIBLE);
                }
                Random random=new Random();
                int x= random.nextInt(11);
                imageViews[x].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);

    }

}