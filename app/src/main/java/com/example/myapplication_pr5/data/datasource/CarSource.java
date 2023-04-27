package com.example.myapplication_pr5.data.datasource;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.data.model.Car;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarSource {
    File app_specific_storage_file;

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