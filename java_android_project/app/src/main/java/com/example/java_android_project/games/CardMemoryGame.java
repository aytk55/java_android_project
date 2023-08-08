package com.example.loginregister.games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.loginregister.pages.MainActivity;
import com.example.loginregister.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class CardMemoryGame extends AppCompatActivity {
    Integer[] cardsArray={1,2,3,4,5,6,11,12,13,14,15,16};

    int firstClicked,secondClicked;

    int firstCard,secondCard;
String time;
    int cardNumber=1;

    Chronometer chronometer;
ImageButton imageButton1,imageButton2,imageButton3,
        imageButton4,imageButton5,imageButton6,
        imageButton7,imageButton8,imageButton9,
        imageButton10,imageButton11,imageButton12;

    int image1,image2,image3,image4,image5,image6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_memory_game);

        chronometer=findViewById(R.id.chronometer);
        chronometer.setBase(chronometer.getBase());
        chronometer.start();
        imageButton1=findViewById(R.id.imageButton2);
        imageButton2=findViewById(R.id.imageButton5);
        imageButton3=findViewById(R.id.imageButton6);
        imageButton4=findViewById(R.id.imageButton7);
        imageButton5=findViewById(R.id.imageButton8);
        imageButton6=findViewById(R.id.imageButton9);
        imageButton7=findViewById(R.id.imageButton10);
        imageButton8=findViewById(R.id.imageButton11);
        imageButton9=findViewById(R.id.imageButton12);
        imageButton10=findViewById(R.id.imageButton13);
        imageButton11=findViewById(R.id.imageButton14);
        imageButton12=findViewById(R.id.imageButton15);

        imageButton1.setTag("0");
        imageButton2.setTag("1");
        imageButton3.setTag("2");
        imageButton4.setTag("3");
        imageButton5.setTag("4");
        imageButton6.setTag("5");
        imageButton7.setTag("6");
        imageButton8.setTag("7");
        imageButton9.setTag("8");
        imageButton10.setTag("9");
        imageButton11.setTag("10");
        imageButton12.setTag("11");

        FrontOfCards();

        Collections.shuffle(Arrays.asList(cardsArray));



        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton1,theCard);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton2,theCard);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton3,theCard);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton4,theCard);
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton5,theCard);
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton6,theCard);
            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton7,theCard);
            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton8,theCard);
            }
        });
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton9,theCard);
            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton10,theCard);
            }
        });
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton11,theCard);
            }
        });
        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String)view.getTag());
                doStuff(imageButton12,theCard);
            }
        });

    }

    private void doStuff(ImageButton ib, int card) {

        if(cardsArray[card]==1){
            ib.setImageResource(image1);
        }
        else if(cardsArray[card]==2){
            ib.setImageResource(image2);
        }
        else if(cardsArray[card]==3){
            ib.setImageResource(image3);
        }
        else if(cardsArray[card]==4){
            ib.setImageResource(image4);
        }
        else if(cardsArray[card]==5){
            ib.setImageResource(image5);
        }
        else if(cardsArray[card]==6){
            ib.setImageResource(image6);
        }
        if(cardsArray[card]==11){
            ib.setImageResource(image1);
        }
        else if(cardsArray[card]==12){
            ib.setImageResource(image2);
        }
        else if(cardsArray[card]==13){
            ib.setImageResource(image3);
        }
        else if(cardsArray[card]==14){
            ib.setImageResource(image4);
        }
        else if(cardsArray[card]==15){
            ib.setImageResource(image5);
        }
        else if(cardsArray[card]==16){
            ib.setImageResource(image6);
        }



        if(cardNumber==1){
        firstCard=cardsArray[card];
            if(firstCard>6){
                firstCard=firstCard-10;
             }
            cardNumber=2;
            firstClicked=card;
            ib.setEnabled(false);
        } else if (cardNumber==2) {
            secondCard=cardsArray[card];
            if(secondCard>6){
                secondCard=secondCard-10;
            }
            cardNumber=1;
            secondClicked=card;

            imageButton1.setEnabled(false);
            imageButton2.setEnabled(false);
            imageButton3.setEnabled(false);
            imageButton4.setEnabled(false);
            imageButton5.setEnabled(false);
            imageButton6.setEnabled(false);
            imageButton7.setEnabled(false);
            imageButton8.setEnabled(false);
            imageButton9.setEnabled(false);
            imageButton10.setEnabled(false);
            imageButton11.setEnabled(false);
            imageButton12.setEnabled(false);

            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();


                }
            },1000);



            
        }

    }

    private void calculate() {
if(firstCard==secondCard){
    if(firstClicked==0){
        imageButton1.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==1){
        imageButton2.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==2){
        imageButton3.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==3){
        imageButton4.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==4){
        imageButton5.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==5){
        imageButton6.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==6){
        imageButton7.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==7){
        imageButton8.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==8){
        imageButton9.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==9){
        imageButton10.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==10){
        imageButton11.setVisibility(View.INVISIBLE);
    }
    else if(firstClicked==11){
        imageButton12.setVisibility(View.INVISIBLE);
    }

    if(secondClicked==0){
        imageButton1.setVisibility(View.INVISIBLE);
    } else if(secondClicked==1){
        imageButton2.setVisibility(View.INVISIBLE);
    } else if(secondClicked==2){
        imageButton3.setVisibility(View.INVISIBLE);
    }else if(secondClicked==3){
        imageButton4.setVisibility(View.INVISIBLE);
    }else if(secondClicked==4){
        imageButton5.setVisibility(View.INVISIBLE);
    }else if(secondClicked==5){
        imageButton6.setVisibility(View.INVISIBLE);
    }else if(secondClicked==6){
        imageButton7.setVisibility(View.INVISIBLE);
    }else if(secondClicked==7){
        imageButton8.setVisibility(View.INVISIBLE);
    }else if(secondClicked==8){
        imageButton9.setVisibility(View.INVISIBLE);
    }
    else if(secondClicked==9){
        imageButton10.setVisibility(View.INVISIBLE);
    }
    else if(secondClicked==10){
        imageButton11.setVisibility(View.INVISIBLE);
    }
    else if(secondClicked==11){
        imageButton12.setVisibility(View.INVISIBLE);
    }
}
    else {
        imageButton1.setImageResource(R.drawable.c);
        imageButton2.setImageResource(R.drawable.c);
        imageButton3.setImageResource(R.drawable.c);
        imageButton4.setImageResource(R.drawable.c);
        imageButton5.setImageResource(R.drawable.c);
        imageButton6.setImageResource(R.drawable.c);
        imageButton7.setImageResource(R.drawable.c);
        imageButton8.setImageResource(R.drawable.c);
        imageButton9.setImageResource(R.drawable.c);
        imageButton10.setImageResource(R.drawable.c);
        imageButton11.setImageResource(R.drawable.c);
        imageButton12.setImageResource(R.drawable.c);
    }
    imageButton1.setEnabled(true);
    imageButton2.setEnabled(true);
    imageButton3.setEnabled(true);
    imageButton4.setEnabled(true);
    imageButton5.setEnabled(true);
    imageButton6.setEnabled(true);
    imageButton7.setEnabled(true);
    imageButton8.setEnabled(true);
    imageButton9.setEnabled(true);
    imageButton10.setEnabled(true);
    imageButton11.setEnabled(true);
    imageButton12.setEnabled(true);

    checkEnd();
}







    private void FrontOfCards() {
        image1=R.drawable.character1;
        image2=R.drawable.character2;
        image3=R.drawable.character3;
        image4=R.drawable.character4;
        image5=R.drawable.character5;
        image6=R.drawable.character6;
    }

    private void checkEnd(){
        if(imageButton1.getVisibility()==View.INVISIBLE&&
                imageButton2.getVisibility()==View.INVISIBLE&&
                imageButton3.getVisibility()==View.INVISIBLE&&
                imageButton4.getVisibility()==View.INVISIBLE&&
                imageButton5.getVisibility()==View.INVISIBLE&&
                imageButton6.getVisibility()==View.INVISIBLE&&
                imageButton7.getVisibility()==View.INVISIBLE&&
                imageButton8.getVisibility()==View.INVISIBLE&&
                imageButton9.getVisibility()==View.INVISIBLE&&
                imageButton10.getVisibility()==View.INVISIBLE&&
                imageButton11.getVisibility()==View.INVISIBLE&&
                imageButton12.getVisibility()==View.INVISIBLE) {
            Intent intent = new Intent(CardMemoryGame.this, MainActivity.class);
            startActivity(intent);

            time = chronometer.getText().toString();
            if (isLanguageTurkish()) {
                Toast.makeText(this, "Bütün resimleri: " + time + " sürede buldun", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "You found all images in: " + time + " minute", Toast.LENGTH_SHORT).show();

            }finish();
        }
    }

    private boolean isLanguageTurkish() {
        Locale local=getResources().getConfiguration().getLocales().get(0);
        String currentLanguage=local.getLanguage();
        return currentLanguage.equals("tr");
    }
}