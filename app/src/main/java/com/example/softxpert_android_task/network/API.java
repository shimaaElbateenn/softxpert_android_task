package com.example.softxpert_android_task.network;

import com.example.softxpert_android_task.models.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface API {

    @GET("v1/cars?page=1")
    Call<JSONResponse> getCarInfo();
}
