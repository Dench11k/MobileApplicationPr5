package com.example.myapplication_pr5.data.repository;

import androidx.lifecycle.LiveData;

import com.example.myapplication_pr5.data.datasource.CarSource;
import com.example.myapplication_pr5.data.model.Car;

import java.util.List;

public class CarsRepository {
    private LiveData<List<Car>> cars;
    public CarsRepository(){
        cars = CarSource.createList();
    }
    public LiveData<List<Car>> getData(){
        return cars;
    }
}
