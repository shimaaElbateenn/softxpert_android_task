package com.example.softxpert_android_task.network;

import com.example.softxpert_android_task.models.Car;

public class JSONResponse {
    private Car[] data;

    public Car[] getData() {
        return data;
    }

    public void setData(Car[] data) {
        this.data = data;
    }
}
