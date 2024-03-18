package com.example.cake.models;

public class OrdersModel {
    private int id;
    private int idClient;
    private int idCake;
    private String size;
    private int quantity;
    private String notice;
    private String date;
    private String address;
    private int total;

    public OrdersModel(int id, int idClient, int idCake, String size, int quantity, String notice, String date, String address, int total) {
        this.id = id;
        this.idClient = idClient;
        this.idCake = idCake;
        this.size = size;
        this.quantity = quantity;
        this.notice = notice;
        this.date = date;
        this.address = address;
        this.total = total;
    }

    public OrdersModel() {

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
