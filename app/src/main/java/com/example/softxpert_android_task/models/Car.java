package com.example.softxpert_android_task.models;

public class Car {
    private String brand;
    private String imageUrl;
    private Boolean isUsed;
    private String constractionYear;

    public Car(String brand, String imageUrl, Boolean isUsed, String constractionYear) {
        this.brand = brand;
        this.imageUrl = imageUrl;
        this.isUsed = isUsed;
        this.constractionYear = constractionYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public String getConstractionYear() {
        return constractionYear;
    }

    public void setConstractionYear(String constractionYear) {
        this.constractionYear = constractionYear;
    }
}
