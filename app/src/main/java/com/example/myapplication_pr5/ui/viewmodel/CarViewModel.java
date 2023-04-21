package com.example.myapplication_pr5.ui.viewmodel;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication_pr5.data.database.entity.CarEntity;
import com.example.myapplication_pr5.data.model.Car;
import com.example.myapplication_pr5.data.repository.CarsRepository;

import java.io.Closeable;
import java.util.List;


public class CarViewModel extends AndroidViewModel {
        private LiveData<List<Car>> cars;
        private CarsRepository carsRepository;
        public CarViewModel (Application application) {
        super(application);
        carsRepository = new CarsRepository(application);
        cars =carsRepository.getAllCars();
    }
    public LiveData<List<Car>> getAllCars() { return cars; }

    public void insert(Car car) { carsRepository.insert(new CarEntity(car.getImage(), car.getNameCar())); }

}