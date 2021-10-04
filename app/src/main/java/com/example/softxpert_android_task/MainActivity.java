package com.example.softxpert_android_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.softxpert_android_task.adapters.CarAdapter;
import com.example.softxpert_android_task.models.Car;
import com.example.softxpert_android_task.viewmodel.CarListViewModel;

import java.util.List;

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
        adapter = new CarAdapter(this, carModelList);
        recyclerView.setAdapter(adapter);


        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModel = new ViewModelProvider(this, factory).get(CarListViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<Car>>() {
            @Override
            public void onChanged(List<Car> carModels) {
                if(carModels != null) {
                    carModelList = carModels;
                    adapter.setCarsList(carModelList);
                 //   noresult.setVisibility(View.GONE);
                } else {
                  //  noresult.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.makeApiCall();
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