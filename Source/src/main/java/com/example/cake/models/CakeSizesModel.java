package com.example.cake.models;

public class CakeSizesModel {
    private int idCake;
    private String size;
    private int price;
    private int oldPrice;

    public CakeSizesModel(int idCake, String size, int price, int oldPrice) {
        this.idCake = idCake;
        this.size = size;
        this.price = price;
        this.oldPrice = oldPrice;
    }

    public int getIdCake() {
        return idCake;
    }
    public void setIdCake(int idCake) {
        this.idCake = idCake;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getOldPrice() {
        return oldPrice;
    }
    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }
}
