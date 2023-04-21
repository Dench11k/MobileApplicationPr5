package com.example.myapplication_pr5.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.data.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Car> {
    private LayoutInflater inflater;
    private int layout;
    private List<Car> items;
    public CustomListAdapter(Context context, int resource, List<Car> obj) {
        super(context, resource, obj);
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        this.items = obj;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        ImageView imageView = view.findViewById(R.id.imageView2);
        TextView nameView = view.findViewById(R.id.textView);
        imageView.setImageResource(getItem(position).getImage());
        nameView.setText(getItem(position).getNameCar());
        return view;
    }
    public void updateCars(List<Car> cars) {
        this.items = cars;
        notifyDataSetChanged();
    }
}