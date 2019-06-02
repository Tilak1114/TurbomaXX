package com.example.turbomaxx;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class CarModelAdapter extends FirestoreRecyclerAdapter<CarModel, CarModelAdapter.CarModelHolder> {
    Context context;
    public CarModelAdapter(@NonNull FirestoreRecyclerOptions<CarModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull CarModelHolder holder, int position, @NonNull CarModel model) {
        holder.carModelTv.setText(model.getModelname());
        holder.bodyTypeTv.setText(model.getBodyType());
        holder.fuelTypeTv.setText(model.getFuel());
        Picasso.with(context).load(model.getCarAvatar()).into(holder.avatar);
    }

    @NonNull
    @Override
    public CarModelHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_custom_layout, viewGroup, false);
        return new CarModelHolder(v);
    }

    class CarModelHolder extends RecyclerView.ViewHolder{
        TextView carModelTv, bodyTypeTv, fuelTypeTv;
        CircleImageView avatar;
        public CarModelHolder(@NonNull View itemView) {
            super(itemView);
            carModelTv = (TextView) itemView.findViewById(R.id.ModelName);
            bodyTypeTv = itemView.findViewById(R.id.ModelType);
            fuelTypeTv = itemView.findViewById(R.id.fuelType);
            avatar = itemView.findViewById(R.id.modelPic);
        }
    }
}
