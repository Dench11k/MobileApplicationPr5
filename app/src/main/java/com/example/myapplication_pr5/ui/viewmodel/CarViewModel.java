package com.example.myapplication_pr5.ui.viewmodel;


import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication_pr5.data.database.entity.CarEntity;
import com.example.myapplication_pr5.data.datasource.CarSource;
import com.example.myapplication_pr5.data.model.Car;
import com.example.myapplication_pr5.data.repository.CarsRepository;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class CarViewModel extends AndroidViewModel {
        private final LiveData<List<Car>> cars;
        private CarsRepository carsRepository;
        private CarSource carSource;
        public CarViewModel (Application application) {
        super(application);
        carsRepository = new CarsRepository(application);
        cars =carsRepository.getAllCars();
    }
    public LiveData<List<Car>> getAllCars() { return cars; }

    public void insert(Car car) { carsRepository.insert(new CarEntity(car.getImage(), car.getNameCar())); }

}