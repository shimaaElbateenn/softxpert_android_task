package com.example.softxpert_android_task.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.softxpert_android_task.models.Car;
import com.example.softxpert_android_task.network.API;
import com.example.softxpert_android_task.network.JSONResponse;
import com.example.softxpert_android_task.network.RetrofitClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarListViewModel extends ViewModel {

    private MutableLiveData<List<Car>> carsList;

    public CarListViewModel(){
        carsList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Car>> getMoviesListObserver() {
        return carsList;

    }

//    public void makeApiCall() {
//        API apiService = RetrofitClient.getRetroClient().create(API.class);
//        Call<JSONResponse> call = apiService.getCarInfo();
//        call.enqueue(new Callback<JSONResponse>() {
//            @Override
//            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
//
//                JSONResponse jsonResponse = response.body();
//                carsList = new MutableLiveData<>(Arrays.asList(jsonResponse.getData()));
//
//                carsList.postValue(jsonResponse);
//                Log.e("Message: , ", "Successful");
//            }
//
//            @Override
//            public void onFailure(Call<JSONResponse> call, Throwable throwable) {
//                Log.e("Error, ", throwable.toString());
//                carsList.postValue(null);
//            }
//        });
//    }
}
