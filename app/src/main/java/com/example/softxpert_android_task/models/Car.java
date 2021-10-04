package com.example.softxpert_android_task.models;

public class Car {
    private String name;
    private String image;
    private String status;
    private String Construction;

    public Car(String name, String image, String status, String construction) {
        this.name = name;
        this.image = image;
        this.status = status;
        Construction = construction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setConstruction(String construction) {
        Construction = construction;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getStatus() {
        return status;
    }

    public String getConstruction() {
        return Construction;
    }
}
