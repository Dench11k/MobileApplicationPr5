package com.example.myapplication_pr5.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.myapplication_pr5.data.database.RoomDataBase.CarRoomDataBase;
import com.example.myapplication_pr5.data.database.dao.CarDao;
import com.example.myapplication_pr5.data.database.entity.CarEntity;
//import com.example.myapplication_pr5.data.datasource.CarSource;
import com.example.myapplication_pr5.data.datasource.CarSource;
import com.example.myapplication_pr5.data.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarsRepository {
    private final CarDao mCarDao;
    private final LiveData<List<Car>> cars;

    private final Context context;
    CarSource carSource;
    CarRoomDataBase roomDatabase;

    public CarsRepository(Context applicationContext){
        context = applicationContext;
        roomDatabase = CarRoomDataBase.getDatabase(context);
        mCarDao = CarRoomDataBase.getDatabase(context).carDao();
        cars = Transformations.map(mCarDao.getAllCars(), entities -> entities.stream()
                .map(CarEntity::toCar).collect(Collectors.toList()));

    }
    public LiveData<List<Car>> getAllCars(){
        return cars;
    }
    public void insert(CarEntity car) {
        CarRoomDataBase.databaseWriteExecutor.execute(() -> {
            mCarDao.insert(car);
        });
    }
}
