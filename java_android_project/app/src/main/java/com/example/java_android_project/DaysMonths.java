package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.loginregister.pages.MainActivity;

import java.util.Locale;

public class DaysMonths extends AppCompatActivity {

    private final String[] weekDays={
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"};
    private final String[] günler={
            "Pazartesi",
            "Salı",
            "Çarşamba",
            "Perşembe",
            "Cuma",
            "Cumartesi",
            "Pazar"};
    private final String[] months={
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };
    private final String[] aylar={
            "Ocak",
            "Şubat",
            "Mart",
            "Nisan",
            "Mayıs",
            "Haziran",
            "Temmuz",
            "Ağuston",
            "Eylül",
            "Ekim",
            "Kasım",
            "Aralık"
    };
    TextView tv1;
    TextView tv2;
    Button b1,b2,mainpage;
    Integer currentDayIndex=0;
    Integer currentMonthIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_months);
        tv1=findViewById(R.id.textView3);
        tv2=findViewById(R.id.textView4);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button3);
mainpage=findViewById(R.id.buttonMain);
mainpage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(DaysMonths.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
});

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextMonth();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextDay();
            }
        });
    }
    private void nextMonth(){
        if(currentMonthIndex==12){
            currentMonthIndex=1;
        }
        else{
            currentMonthIndex++;
        }
        if(isLanguageTurkısh()){
            tv1.setText("Yılın "+currentMonthIndex+". Ayı : "+aylar[currentMonthIndex-1]);
        }else {
            tv1.setText(currentMonthIndex.toString() + ". Month Of the Year is : " + months[currentMonthIndex - 1]);
        }
        }



    private void nextDay(){
        if(currentDayIndex==7){
            currentDayIndex=1;
        }
        else{
            currentDayIndex++;
        }
        if(isLanguageTurkısh()){
            tv2.setText("Haftanın "+currentDayIndex+". Günü : "+günler[currentDayIndex-1]);
        }else {
            tv2.setText(currentDayIndex.toString() + ". Day Of the Week is : " + weekDays[currentDayIndex - 1]);
        }

    }
    private boolean isLanguageTurkısh() {
        Locale local=getResources().getConfiguration().getLocales().get(0);
        String currentLanguage=local.getLanguage();
        return currentLanguage.equals("tr");
    }
}