package com.example.cake.utils;

public class FailSignin {
    public String name;
    public String email;
    public String phone;
    public String password;
    public String comfirmPassword;
    public String message;

    public FailSignin(){};

    public FailSignin(String name,String email,String phone,String password, String comfirmPassword){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.comfirmPassword = comfirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
