package com.example.turbomaxx;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class FullDetailActivity extends AppCompatActivity {
    CircleImageView detAvatar;
    TextView power1, power2, engine, fuel, torque, drive, gearbox, topspeed, acc, modelName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_detail);
        detAvatar = findViewById(R.id.detailsAvatar);
        power1 = findViewById(R.id.power1Val);
        power2 = findViewById(R.id.power2Val);
        engine = findViewById(R.id.engineNameVal);
        fuel = findViewById(R.id.fuelval);
        torque = findViewById(R.id.torqueval);
        drive = findViewById(R.id.drivetypeval);
        gearbox = findViewById(R.id.gearval);
        acc = findViewById(R.id.zerotohundval);
        topspeed = findViewById(R.id.topspeedval);
        modelName = findViewById(R.id.detailsName);
        Intent intent = getIntent();
        modelName.setText(intent.getStringExtra("ModelNameDet"));
        topspeed.setText(intent.getStringExtra("topspeeddet"));
        acc.setText(intent.getStringExtra("accdet"));
        gearbox.setText(intent.getStringExtra("gbdet"));
        drive.setText(intent.getStringExtra("drivedet"));
        torque.setText(intent.getStringExtra("torquedet"));
        fuel.setText(intent.getStringExtra("fueldet"));
        engine.setText(intent.getStringExtra("enginedet"));
        power2.setText(intent.getStringExtra("power2det"));
        power1.setText(intent.getStringExtra("power1det"));
        Picasso.with(getApplicationContext()).load(intent.getStringExtra("caravadet")).into(detAvatar);
    }
}
