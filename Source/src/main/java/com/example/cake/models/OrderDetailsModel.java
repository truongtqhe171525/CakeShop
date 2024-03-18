package com.example.cake.models;

public class OrderDetailsModel {
    private int id;
    private int idClient;
    private int idCake;
    private String cakeName;
    private String url;
    private String size;
    private int quantity;
    private String notice;
    private String date;
    private String address;
    private int total;

    public OrderDetailsModel(int id, int idClient, int idCake, String cakeName, String url, String size, int quantity, String notice, String date, String address, int total) {
        this.id = id;
        this.idClient = idClient;
        this.idCake = idCake;
        this.cakeName = cakeName;
        this.url = url;
        this.size = size;
        this.quantity = quantity;
        this.notice = notice;
        this.date = date;
        this.address = address;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdCake() {
        return idCake;
    }

    public void setIdCake(int idCake) {
        this.idCake = idCake;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
