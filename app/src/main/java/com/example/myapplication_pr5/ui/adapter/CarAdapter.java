package com.example.myapplication_pr5.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.data.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private List<Car> items;
    public CarAdapter(Context context) {
        this.items = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_blank3, parent,
                false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car cars = items.get(position);
        holder.imageView.setImageResource(cars.getImage());
        holder.nameView.setText(cars.getNameCar());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void updateCars(List<Car> cars) {
        this.items.clear();
        this.items = cars;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.imageView2);
            nameView = view.findViewById(R.id.textView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("RecyclerView","element click");
                    Toast.makeText(view.getContext(), "You click!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
