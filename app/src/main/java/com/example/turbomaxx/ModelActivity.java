package com.example.turbomaxx;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ModelActivity extends AppCompatActivity {
    TextView title;
    RelativeLayout wall, parentLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        Intent intent = getIntent();
        String titlestr = intent.getStringExtra("CompanyTitle");
        String wallIdStr = intent.getStringExtra("WallId");
        String BckColor = intent.getStringExtra("BckColor");
        Integer wallId = Integer.parseInt(wallIdStr);
        title = findViewById(R.id.compNameInList);
        wall = findViewById(R.id.wall);
        parentLay = findViewById(R.id.parentlayList);
        title.setText(titlestr);
        wall.setBackgroundResource(wallId);
        parentLay.setBackgroundColor(Color.parseColor(BckColor));
    }

    @Override
    public void onBackPressed() {
        setResult(1);
        finish();
    }
}
