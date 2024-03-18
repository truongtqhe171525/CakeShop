package com.example.cake.models;

import java.util.List;
public class CakeDetailModel {
    private int id;
    private String name;
    private String description;
    private List<CakeImagesModel> cakeImages;
    private List<CakeSizesModel> cakeSizes;
    public CakeDetailModel(int id, String name, String description, List<CakeImagesModel> cakeImages, List<CakeSizesModel> cakeSizes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cakeImages = cakeImages;
        this.cakeSizes = cakeSizes;
    }

    public CakeDetailModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CakeImagesModel> getCakeImages() {
        return cakeImages;
    }

    public void setCakeImages(List<CakeImagesModel> cakeImages) {
        this.cakeImages = cakeImages;
    }

    public List<CakeSizesModel> getCakeSizes() {
        return cakeSizes;
    }

    public void setCakeSizes(List<CakeSizesModel> cakeSizes) {
        this.cakeSizes = cakeSizes;
    }
}
