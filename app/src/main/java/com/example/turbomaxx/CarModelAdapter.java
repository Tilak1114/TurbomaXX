package com.example.turbomaxx;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class CarModelAdapter extends FirestoreRecyclerAdapter<CarModel, CarModelAdapter.CarModelHolder> {
    Context context;
    ItemClickInterface itemClickInterface;
    public CarModelAdapter(@NonNull FirestoreRecyclerOptions<CarModel> options, Context context,
                           ItemClickInterface itemClickInterface) {
        super(options);
        this.context = context;
        this.itemClickInterface = itemClickInterface;
    }

    public interface ItemClickInterface{
        void onItemClick(String modelName, String avatarUrl, String engine, String power1,
                         String power2, String torque, String fuel, String topSpeed, String acc,
                         String drive, String gearbox);
    }
    @Override
    protected void onBindViewHolder(@NonNull CarModelHolder holder, int position, @NonNull final CarModel model) {
        holder.carModelTv.setText(model.getModelname());
        holder.bodyTypeTv.setText(model.getBodyType());
        holder.fuelTypeTv.setText(model.getFuel());
        Picasso.with(context).load(model.getCarAvatar()).into(holder.avatar);
        holder.parentLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickInterface.onItemClick(model.getModelname(), model.getCarAvatar(), model.getEngine(),
                        model.getPowerSpec1(), model.getPowerSpec2(), model.getTorque(), model.getFuel(),
                        model.getTopSpeed(), model.getZerotohund(), model.getDriveType(), model.getGearbox());
            }
        });
    }

    @NonNull
    @Override
    public CarModelHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_custom_layout, viewGroup, false);
        return new CarModelHolder(v);
    }

    class CarModelHolder extends RecyclerView.ViewHolder{
        TextView carModelTv, bodyTypeTv, fuelTypeTv;
        RelativeLayout parentLay;
        CircleImageView avatar;
        public CarModelHolder(@NonNull View itemView) {
            super(itemView);
            carModelTv = (TextView) itemView.findViewById(R.id.ModelName);
            bodyTypeTv = itemView.findViewById(R.id.ModelType);
            parentLay = itemView.findViewById(R.id.parent_lay_model);
            fuelTypeTv = itemView.findViewById(R.id.fuelType);
            avatar = itemView.findViewById(R.id.modelPic);
        }
    }
}
