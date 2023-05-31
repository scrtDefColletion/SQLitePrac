package com.mirea.kt.android2023.myapplication;

public class Telephone {
    private String model;
    private String serial;
    private Integer price;

    public Telephone(String model, String serial, Integer price) {
        this.model = model;
        this.serial = serial;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getSerial() {
        return serial;
    }

    public Integer getPrice() {
        return price;
    }
}
