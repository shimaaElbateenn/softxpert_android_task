package com.example.softxpert_android_task.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.softxpert_android_task.models.Car;
import com.example.softxpert_android_task.network.API;
import com.example.softxpert_android_task.network.RetrofitClient;

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

    public void makeApiCall() {
        API apiService = RetrofitClient.getRetroClient().create(API.class);
        retrofit2.Call<List<Car>> call = apiService.getCarInfo();
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                carsList.postValue(response.body());
                Log.e("Hi, ", "Successful");
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                Log.e("Hi, ", "UnSuccessful");
                carsList.postValue(null);
            }
        });
    }
}
