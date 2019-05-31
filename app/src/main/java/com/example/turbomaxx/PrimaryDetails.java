package com.example.turbomaxx;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import de.hdodenhof.circleimageview.CircleImageView;

public class PrimaryDetails extends AppCompatActivity {
    String carCompany, path;
    TextView compName, tagLine;
    CircleImageView countryLogo;
    CircleImageView sndctrl, close;
    boolean muted = false;
    VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_details);
        Intent intent = getIntent();
        videoview = findViewById(R.id.bckvideo);
        close = findViewById(R.id.close);
        sndctrl = findViewById(R.id.sndctrl);
        compName = findViewById(R.id.carCompanyTitle);
        tagLine = findViewById(R.id.carCompTagline);
        countryLogo = findViewById(R.id.countryLogo);

        carCompany = intent.getStringExtra("carName");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        switch (carCompany){
            case "Lamborghini":
                path = "android.resource://" + getPackageName() + "/" + R.raw.lambovert;
                videoview.setVideoURI(Uri.parse(path));
                videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(final MediaPlayer mp) {
                        mp.setVolume(100, 100);
                        sndctrl.setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            @Override
                            public void onClick(View v) {
                                mp.setVolume(0, 0);
                                sndctrl.setImageResource(R.drawable.muteicon);
                            }
                        });
                        mp.setLooping(true);
                    }
                });
                videoview.start();
                videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        videoview.start();
                    }
                });
                break;
            case "Aston Martin":
                path = "android.resource://" + getPackageName() + "/" + R.raw.astonvert;
                videoview.setVideoURI(Uri.parse(path));
                videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(final MediaPlayer mp) {
                        mp.setVolume(100, 100);
                        sndctrl.setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            @Override
                            public void onClick(View v) {
                                mp.setVolume(0, 0);
                                sndctrl.setImageResource(R.drawable.muteicon);
                            }
                        });
                        mp.setLooping(true);
                    }
                });
                videoview.start();
                videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        videoview.start();
                    }
                });
                break;
            case "mcLaren":
                path = "android.resource://" + getPackageName() + "/" + R.raw.mclarenvert;
                videoview.setVideoURI(Uri.parse(path));
                videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(final MediaPlayer mp) {
                        mp.setVolume(100, 100);
                        sndctrl.setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            @Override
                            public void onClick(View v) {
                                mp.setVolume(0, 0);
                                sndctrl.setImageResource(R.drawable.muteicon);
                            }
                        });
                        mp.setLooping(true);
                    }
                });
                videoview.start();
                videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        videoview.start();
                    }
                });
                break;
        }
    }
}
