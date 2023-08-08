package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.loginregister.pages.MainActivity;

import java.util.Locale;

public class Seasons extends AppCompatActivity {
private int[] images={R.drawable.summer,R.drawable.winter,R.drawable.autumn,R.drawable.spring};
 private String[] texts={"Yaz","Kış","Sonbahar","Ilkbahar"};
    private String[] texts2={"Summer","Winter","Spring","Autumn"};
private int currentPos=0;
ImageView seasons;
TextView text;


Button summer,winter,fall,spring,mainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasons);
        summer=findViewById(R.id.buttonSummer);
        winter=findViewById(R.id.buttonWinter);
        fall=findViewById(R.id.buttonFall);
        spring=findViewById(R.id.button16);
        seasons=findViewById(R.id.imageView);
        text=findViewById(R.id.textView5);
        mainMenu=findViewById(R.id.buttonMainMenu);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Seasons.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        showImageWithText(currentPos);
        summer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=0;
                showImageWithText(currentPos);
             }
        });
        winter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=1;
                showImageWithText(currentPos);
            }
        });
        spring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=2;
                showImageWithText(currentPos);
            }
        });
        fall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=3;
                showImageWithText(currentPos);
            }
        });
    }
    private void showImageWithText(int currentPos){
        seasons.setImageResource(images[currentPos]);
        if(languageTurkısh()){
            text.setText(texts[currentPos]);
        }else{
            text.setText(texts2[currentPos]);
        }


    }

    private boolean languageTurkısh() {
        Locale currentLocale = getResources().getConfiguration().getLocales().get(0);
        String currentLanguage = currentLocale.getLanguage();
        return currentLanguage.equals("tr");
    }
}