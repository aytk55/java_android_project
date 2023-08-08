package com.example.loginregister.games;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginregister.R;
import com.example.loginregister.pages.MainActivity;

import java.util.Locale;
import java.util.Random;

public class NumberMemoryGame2 extends AppCompatActivity {

        TextView tv;
        EditText et;
        Button button;
        Button regular;
        int level = 1;

        String randomNumber = "";

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_memory_game);
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        regular=findViewById(R.id.button8);
        regular.setVisibility(View.VISIBLE);
        if(languageTurkish()){
            et.setHint("sayıyı tersten yazınız");
        }else {
            et.setHint("enter the number in reverse order");
        }

        regular.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(NumberMemoryGame2.this,NumberMemoryGame.class);
        startActivity(intent);
    }
});

        Random random = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                levelup();
                randomNumber = "";
                tv.setVisibility(View.VISIBLE);
                for (int i = 0; i < level; i++) {
                    Integer x = random.nextInt(10);
                    randomNumber = randomNumber + x.toString();
                }
                tv.setText(randomNumber);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tv.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
            }


        });
    }

    private boolean languageTurkish() {
        Locale local=getResources().getConfiguration().getLocales().get(0);
        String currentLanguage=local.getLanguage();
        return currentLanguage.equals("tr");
    }

    private void levelup () {
            String tvText = tv.getText().toString();
            String etText = et.getText().toString();
            StringBuilder reversedEtText = new StringBuilder(etText).reverse();
            if (tvText.equals(reversedEtText.toString())) {
                level++;

            } else {
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(this, "Score  : "+level, Toast.LENGTH_SHORT).show();
            finish();
        }
    }


    }

