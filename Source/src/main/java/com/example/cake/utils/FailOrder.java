package com.example.cake.utils;

public class FailOrder {
    public String notice;
    public String address;
    public String date;
    public String message;
    public FailOrder(){};
    public FailOrder(String notice, String address, String date, String message) {
        this.notice = notice;
        this.address = address;
        this.date = date;
        this.message = message;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
