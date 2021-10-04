package com.example.softxpert_android_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.softxpert_android_task.adapters.CarAdapter;
import com.example.softxpert_android_task.models.Car;
import com.example.softxpert_android_task.network.API;
import com.example.softxpert_android_task.network.JSONResponse;
import com.example.softxpert_android_task.network.RetrofitClient;
import com.example.softxpert_android_task.viewmodel.CarListViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Car> carModelList;
    private CarAdapter adapter;
    private CarListViewModel viewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


makeApiCall();
//
//        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
//        viewModel = new ViewModelProvider(this, factory).get(CarListViewModel.class);
//        viewModel.getMoviesListObserver().observe(this, new Observer<List<Car>>() {
//            @Override
//            public void onChanged(List<Car> carModels) {
//                if(carModels != null) {
//                    carModelList = carModels;
//                    adapter.setCarsList(carModelList);
//                 //   noresult.setVisibility(View.GONE);
//                } else {
//                  //  noresult.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        viewModel.makeApiCall();
    }


    public void makeApiCall() {
        API apiService = RetrofitClient.getRetroClient().create(API.class);
        Call<JSONResponse> call = apiService.getCarInfo();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                carModelList = new ArrayList<>(Arrays.asList(jsonResponse.getData()));


                adapter = new CarAdapter(MainActivity.this, carModelList);
                recyclerView.setAdapter(adapter);

//                carsList.postValue(jsonResponse);
                Log.e("Message: , ", "Successful");
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable throwable) {
                Log.e("Error, ", throwable.toString());
              //  carModelList.postValue(null);
            }
        });
    }

//    private void getCars() {
//        Call<List<Car>> call = RetrofitClient.getInstance().getMyApi().getCarInfo();
//        call.enqueue(new Callback<List<Car>>() {
//            @Override
//            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
//                List<Car> carList = response.body();
//                    String[] oneHeroes = new String[myheroList.size()];
//
//                for (int i = 0; i < myheroList.size(); i++) {
//                    oneHeroes[i] = myheroList.get(i).getName();
//                }
//
//                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
//            }
//
//            @Override
//            public void onFailure(Call<List<Results>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
//            }
//
//        });
//    }
}