package com.example.myapplication_pr5.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.myapplication_pr5.data.model.Car;

@Entity(tableName = "car_table")
public class CarEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int image;
    public CarEntity(@NonNull int image, String name) {
        this.name = name;
        this.image = image;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return this.name;}
    public void setName(@NonNull String name) {this.name = name;}
    public int getImage() {return image;}
    public void setImage(int image) {this.image = image;}
    public Car toCar(){return new Car(this.image, this.name);}
}
