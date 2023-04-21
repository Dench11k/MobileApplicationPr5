package com.example.myapplication_pr5.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.data.model.Car;

import java.util.ArrayList;
import java.util.List;

public class MyCustomListAdapter extends RecyclerView.Adapter<MyCustomListAdapter.MyViewHolder> {

    private List<Car> cars;

    public MyCustomListAdapter() {
        this.cars =  new ArrayList<>();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cars, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.name.setText(car.getNameCar());
        holder.imageView.setImageResource(car.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Navigation.findNavController(view).navigate(R.id.action_blankFragment5_to_blankFragment3,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            name = itemView.findViewById(R.id.textView);
        }
    }
    public void updateBooks(List<Car> cars) {
        this.cars.clear();
        this.cars = cars;
        notifyDataSetChanged();
    }
}
