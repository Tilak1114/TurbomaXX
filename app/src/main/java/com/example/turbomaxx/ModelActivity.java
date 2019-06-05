package com.example.turbomaxx;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ModelActivity extends AppCompatActivity implements CarModelAdapter.ItemClickInterface{
    TextView title;
    RelativeLayout wall, parentLay, rvParent;
    RecyclerView recyclerView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CarModelAdapter adapter;
    CollectionReference carModelRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        Intent intent = getIntent();
        String titlestr = intent.getStringExtra("CompanyTitle");
        String wallIdStr = intent.getStringExtra("WallId");
        String BckColor = intent.getStringExtra("BckColor");
        Integer wallId = Integer.parseInt(wallIdStr);
        carModelRef = db.collection("Cars/"+titlestr+"/Models");
        title = findViewById(R.id.compNameInList);
        wall = findViewById(R.id.wall);
        parentLay = findViewById(R.id.parentlayList);
        recyclerView = findViewById(R.id.recycler_view);
        rvParent = findViewById(R.id.parent_lay_model);
        title.setText(titlestr);
        wall.setBackgroundResource(wallId);
        parentLay.setBackgroundColor(Color.parseColor(BckColor));

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        Query query = carModelRef.orderBy("modelname");
        FirestoreRecyclerOptions<CarModel> options = new FirestoreRecyclerOptions.Builder<CarModel>()
                .setQuery(query, CarModel.class).build();
        adapter = new CarModelAdapter(options, getApplicationContext(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onBackPressed() {
        setResult(1);
        finish();
    }

    @Override
    public void onItemClick(String modelName, String avatarUrl, String engine, String power1, String power2, String torque, String fuel, String topSpeed, String acc, String drive, String gearbox) {
        Intent intent = new Intent(getApplicationContext(), FullDetailActivity.class);
        intent.putExtra("ModelNameDet", modelName);
        intent.putExtra("accdet", acc);
        intent.putExtra("gbdet", gearbox);
        intent.putExtra("drivedet", drive);
        intent.putExtra("torquedet", torque);
        intent.putExtra("fueldet", fuel);
        intent.putExtra("enginedet", engine);
        intent.putExtra("power2det", power2);
        intent.putExtra("power1det", power1);
        intent.putExtra("caravadet", avatarUrl);
        intent.putExtra("topspeeddet", topSpeed);
        startActivity(intent);
    }
}
