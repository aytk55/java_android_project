package com.example.loginregister.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginregister.DaysMonths;
import com.example.loginregister.R;
import com.example.loginregister.Seasons;
import com.example.loginregister.games.CardMemoryGame;
import com.example.loginregister.games.NumberMemoryGame;
import com.example.loginregister.games.RabbitGame;
import com.example.loginregister.math.Math;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;
Button logout;
ImageView math;
ImageView daysmonths;
ImageView clickgame;
ImageView cardmemorygame;
ImageView numbermemorygame;
ImageView seasons;
FirebaseAuth auth;
FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        logout=findViewById(R.id.button);
        textView=findViewById(R.id.textVieww);
        auth=FirebaseAuth.getInstance();
        user= auth.getCurrentUser();
seasons=findViewById(R.id.imageView2);
        math=findViewById(R.id.imageView16);
        daysmonths=findViewById(R.id.imageView17);
        clickgame=findViewById(R.id.imageView18);
        cardmemorygame=findViewById(R.id.imageView15);
        numbermemorygame=findViewById(R.id.imageView19);



        if(user==null){
            Intent intent=new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }else {
            if(languageTurkısh()){
            textView.setText("Lütfen bir aktivite seçiniz");
        }else{
            textView.setText("Please choose an activity");
        }

        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
        seasons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Seasons.class);
                startActivity(intent);
                finish();
            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Math.class);
                startActivity(intent);
                finish();
            }
        });
        daysmonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, DaysMonths.class);
                startActivity(intent);
                finish();
            }
        });
        clickgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RabbitGame.class);
                startActivity(intent);
                finish();
            }
        });
        cardmemorygame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CardMemoryGame.class);
                startActivity(intent);
                finish();
            }
        });
        numbermemorygame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, NumberMemoryGame.class);
                startActivity(intent);
                finish();
            }
        });
    } private boolean languageTurkısh() {
        Locale currentLocale = getResources().getConfiguration().getLocales().get(0);
        String currentLanguage = currentLocale.getLanguage();
        return currentLanguage.equals("tr");
    }
}