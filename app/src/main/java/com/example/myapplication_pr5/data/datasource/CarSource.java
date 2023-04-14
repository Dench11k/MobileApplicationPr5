package com.example.myapplication_pr5.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.data.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarSource {
    public static LiveData<List<Car>> createList() {
        MutableLiveData<List<Car>> list = new MutableLiveData<>();
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Car tmp = new Car(R.drawable.sedan, "Lada Granta, комплектация " + i);
            cars.add(tmp);
        }
        list.setValue(cars);
        return list;
    }
}