package com.example.turbomaxx;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PrimaryDetails extends AppCompatActivity {
    String carCompany, path;
    RelativeLayout modelsBtn;
    TextView compName, tagLine;
    CircleImageView countryLogo, compLogo;
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
        modelsBtn = findViewById(R.id.viewModelsLay);
        sndctrl = findViewById(R.id.sndctrl);
        //compLogo = findViewById(R.id.carCompLogo);
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
                //Picasso.with(getApplicationContext()).load(R.drawable.lambologo).into(compLogo);
                compName.setText("Lamboghini");
                Picasso.with(getApplicationContext()).load(R.drawable.italy).into(countryLogo);
                tagLine.setText("Closer To Roads");
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
                modelsBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent modelIntent = new Intent(getApplicationContext(), ModelActivity.class);
                        modelIntent.putExtra("CompanyTitle", "Lamborghini");
                        modelIntent.putExtra("WallId", String.valueOf(R.drawable.lambowall));
                        modelIntent.putExtra("BckColor", "#140812");
                        startActivityForResult(modelIntent, 123);
                    }
                });
                break;
            case "Aston Martin":
               // Picasso.with(getApplicationContext()).load(R.drawable.aston).into(compLogo);
                compName.setText("Aston Martin");
                Picasso.with(getApplicationContext()).load(R.drawable.brit).into(countryLogo);
                tagLine.setText("Power, beauty and soul");
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
                modelsBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent modelIntent = new Intent(getApplicationContext(), ModelActivity.class);
                        modelIntent.putExtra("CompanyTitle", "Aston Martin");
                        modelIntent.putExtra("WallId", String.valueOf(R.drawable.astonwall));
                        modelIntent.putExtra("BckColor", "#0D0D0D");
                        startActivityForResult(modelIntent, 123);
                    }
                });
                break;
            case "mcLaren":
                //Picasso.with(getApplicationContext()).load(R.drawable.mclaren).into(compLogo);
                compName.setText("McLaren");
                Picasso.with(getApplicationContext()).load(R.drawable.brit).into(countryLogo);
                tagLine.setText("There is no finish line");
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
                modelsBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent modelIntent = new Intent(getApplicationContext(), ModelActivity.class);
                        modelIntent.putExtra("CompanyTitle", "McLaren");
                        modelIntent.putExtra("WallId", String.valueOf(R.drawable.mclarenwall));
                        modelIntent.putExtra("BckColor", "#000000");
                        startActivityForResult(modelIntent, 123);
                    }
                });
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123&&resultCode==1){
            finish();
        }
    }
}
