package com.example.softxpert_android_task.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softxpert_android_task.R;
import com.example.softxpert_android_task.models.Car;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder>{

    private Context mContext;
    private List<Car> carList;
  //  private CarViewModel carViewModel;
    private Bitmap bitmap;


    public CarAdapter(Context mContext, List<Car> carList) {
        this.mContext = mContext;
        this.carList = carList;
        this.bitmap = bitmap;
    }

    public void setCarsList(List<Car> orderList) {
        this.carList = orderList;
        notifyDataSetChanged();
    }

//    public void setCarBitmap(Bitmap bitmap) {
//        this.bitmap = bitmap;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public CarAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_item, parent, false);
        return new CarAdapter.CarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.CarViewHolder holder, int position) {
        Car model = carList.get(position);
        holder.brandName.setText(model.getBrand());
        holder.status.setText(model.getUsed().toString());
        holder.year.setText(model.getConstractionYear());

    }

    @Override
    public int getItemCount() {
      //  Log.e("size", String.valueOf(carList.size()));
        if (this.carList != null) {
            return this.carList.size();
        }
        return 0;
    }

    void getOrderPhoto(String id) {


    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        TextView brandName;
        TextView status;
        TextView year;
        ImageView carImg;

        public CarViewHolder(View view) {
            super(view);

            brandName = view.findViewById(R.id.txt_brand);
            status = view.findViewById(R.id.txt_status);
            year = view.findViewById(R.id.txt_year);

        }

    }
}
