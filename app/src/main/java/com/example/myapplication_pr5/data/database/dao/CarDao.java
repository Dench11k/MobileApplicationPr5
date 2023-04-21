package com.example.myapplication_pr5.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication_pr5.data.database.entity.CarEntity;

import java.util.List;

@Dao
public interface CarDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(CarEntity car);
    @Query("DELETE FROM car_table")
    void deleteAll();
    @Query("SELECT * FROM car_table ORDER BY id")
    LiveData<List<CarEntity>> getAllCars();
}
