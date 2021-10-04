package com.example.softxpert_android_task.network;

import com.example.softxpert_android_task.models.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

 //   String BASE_URL = "v1/cars?page={1}";
    @GET("v1/cars?page=1")
    Call<List<Car>> getCarInfo();
}
