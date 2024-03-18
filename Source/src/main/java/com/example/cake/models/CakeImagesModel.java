package com.example.cake.models;

public class CakeImagesModel {
    private int idCake;
    private String url;

    public CakeImagesModel(int idCake, String url) {
        this.idCake = idCake;
        this.url = url;
    }
    public int getIdCake() {
        return idCake;
    }
    public void setIdCake(int idCake) {
        this.idCake = idCake;
    }
    public String getUrl() {
        return url;
    }
}

