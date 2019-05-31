package com.example.turbomaxx;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    HashMap<String, String> quotes = new HashMap<>();
    Handler handler;
    TextView quote, quoteby, companyName;
    ImageView right, left, avatar;
    String indiQuote, indiQuoter;

    Object quoteArr[], quoterArr[];

    int imgIds[] = {R.drawable.lambologo, R.drawable.aston, R.drawable.mclaren, R.drawable.ferr, R.drawable.rr};
    String respCars[]={"Lamborghini", "Aston Martin", "mcLaren", "Ferrari", "Rolls Royce"};
    int currentImgId = R.drawable.basicavatar;
    int id = 0;

    Animation animationOut;
    Animation animationIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler =new Handler();

        quote = findViewById(R.id.quotetv);
        quoteby = findViewById(R.id.quotertv);

        right = findViewById(R.id.rightArrow);
        left = findViewById(R.id.leftArrow);
        avatar = findViewById(R.id.avatar);
        companyName = findViewById(R.id.companytv);

        Context context;
        final MediaPlayer initSound = MediaPlayer.create(getApplicationContext(), R.raw.carclick);
        final MediaPlayer initSound2 = MediaPlayer.create(getApplicationContext(), R.raw.rev_up);
        final MediaPlayer arrowSounds = MediaPlayer.create(getApplicationContext(), R.raw.nextsound);

        quotes.put("One person's car is another person's scenery.", "~ Jonathan Ive");
        quotes.put("The way I drive, the way I handle a car, is an expression of my inner feelings.", "~ Lewis Hamilton");
        quotes.put("A dream without ambition is like a car without gas... you're not going anywhere.", "~ Sean Hampton");
        quotes.put("Straight roads are for fast cars, turns are for fast drivers.", "~ Colin McRae");
        quotes.put("Horsepower is how fast you hit the wall. Torque is how far you take the wall with you.", "~ Unknown");
        quotes.put("It's not a throttle-it's a detonator.", "~ Jeremy Clarkson");

        quoteArr = quotes.keySet().toArray();
        quoterArr = quotes.values().toArray();

        avatar.setImageResource(imgIds[0]);
        companyName.setText(respCars[0]);

        generateQuotes();

        //disableLeft();

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("IdchkOut", String.valueOf(id));
                if(id<imgIds.length-1){
                    arrowSounds.start();
                    currentImgId = imgIds[id+1];
                    companyName.setText(respCars[id+1]);
                    avatar.setImageResource(currentImgId);
                    id++;
                    Log.d("Idchk", String.valueOf(id));
                }
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id>0){
                    arrowSounds.start();
                    currentImgId = imgIds[id-1];
                    companyName.setText(respCars[id-1]);
                    avatar.setImageResource(currentImgId);
                    id--;
                }
            }
        });

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initSound.start();
                initSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        initSound2.start();
                        Intent intent = new Intent(MainActivity.this, PrimaryDetails.class);
                        intent.putExtra("carName", companyName.getText().toString());
                        startActivity(intent);
                    }
                });
            }
        });

    }

    public void disableLeft(){
        if(currentImgId==R.drawable.basicavatar){
            left.setClickable(false);
        }
    }

    public void disableRight(){
        if(currentImgId==R.drawable.rr){
            right.setClickable(false);
        }
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
