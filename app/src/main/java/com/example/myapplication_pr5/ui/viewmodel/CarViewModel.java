package com.example.myapplication_pr5.ui.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication_pr5.data.model.Car;
import com.example.myapplication_pr5.data.repository.CarsRepository;

import java.util.List;


public class CarViewModel extends ViewModel {
        public LiveData<List<Car>> cars;
        private CarsRepository carsRepository = new CarsRepository();
        public CarViewModel(){
            initialization();
        }
        private void initialization(){
            cars = carsRepository.getData();
        }

}