package com.example.turbomaxx;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    HashMap<String, String> quotes = new HashMap<>();
    Handler handler;
    TextView quote, quoteby;
    String indiQuote, indiQuoter;

    Object quoteArr[], quoterArr[];

    Animation animationOut;
    Animation animationIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler =new Handler();

        quote = findViewById(R.id.quotetv);
        quoteby = findViewById(R.id.quotertv);

        quotes.put("One person's car is another person's scenery.", "~ Jonathan Ive");
        quotes.put("The way I drive, the way I handle a car, is an expression of my inner feelings.", "~ Lewis Hamilton");
        quotes.put("A dream without ambition is like a car without gas... you're not going anywhere.", "~ Sean Hampton");
        quotes.put("Straight roads are for fast cars, turns are for fast drivers.", "~ Colin McRae");
        quotes.put("Horsepower is how fast you hit the wall. Torque is how far you take the wall with you.", "~ Unknown");
        quotes.put("It's not a throttle-it's a detonator.", "~ Jeremy Clarkson");

        quoteArr = quotes.keySet().toArray();
        quoterArr = quotes.values().toArray();

        generateQuotes();
    }

    public void generateQuotes(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    for(int i=0; i< quotes.size(); i++){
                        indiQuote = quoteArr[i].toString();
                        indiQuoter = quoterArr[i].toString();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                animationOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_outtwosec);
                                animationIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_intwosec);
                                quote.setAnimation(animationOut);
                                quoteby.setAnimation(animationOut);
                                quote.setVisibility(View.INVISIBLE);
                                quoteby.setVisibility(View.INVISIBLE);
                                quote.setText(indiQuote);
                                quoteby.setText(indiQuoter);
                                quote.setAnimation(animationIn);
                                quoteby.setAnimation(animationIn);
                                quoteby.setVisibility(View.VISIBLE);
                                quote.setVisibility(View.VISIBLE);
                            }
                        });
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        try {
            thread.start();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
