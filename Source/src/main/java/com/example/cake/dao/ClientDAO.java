package com.example.cake.dao;

import com.example.cake.Connect;
import com.example.cake.utils.FailSignin;
import com.example.cake.utils.UserOut;
import com.example.cake.utils.ValidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDAO {
    private final Connection conn = Connect.getConnection();

    public UserOut getUser(String account, String password) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE (email = ? OR phone = ?) AND password = ?");
            ps.setString(1, account);
            ps.setString(2, account);
            ps.setString(3, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new UserOut(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public FailSignin login(String account, String password){
        FailSignin failSignin = new FailSignin();
        try {
            if(ValidUtils.isPhone(account)){
                if(checkLoginByPhone(account, password)){
                    return null;
                }
                else{
                    failSignin.setMessage("Phone or password is incorrect");
                    return failSignin;
                }
            }
            else if(ValidUtils.isEmail(account)){
                if(checkLoginByEmail(account, password)){
                    return null;
                }
                else{
                    failSignin.setMessage("Email or password is incorrect");
                    return failSignin;
                }
            }
            else{
                failSignin.setMessage("Account is invalid");
                return failSignin;
            }
        }
        catch (Exception e){
            failSignin.setMessage(e.getMessage());
            return failSignin;
        }
    }
    public FailSignin register(String name, String email, String phone, String password){
        FailSignin failSignin = new FailSignin();
        try{
            if(checkEmail(email)) {
                failSignin.setEmail("Email is already exist");
                return failSignin;
            }
            if(checkPhone(phone)) {
                failSignin.setPhone("Phone is already exist");
                return failSignin;
            }

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Clients (name, email, phone, password) VALUES (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, password);
            ps.executeUpdate();
        }
        catch (Exception e){
            failSignin.setMessage(e.getMessage());
            return failSignin;
        }
        return null;
    }

    public boolean checkEmail(String email){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean checkPhone(String phone){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE phone = ?");
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean checkLoginByEmail(String email, String password){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean checkLoginByPhone(String phone, String password){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Clients WHERE phone = ? AND password = ?");
            ps.setString(1, phone);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
        catch (Exception e){
            return false;
        }
    }

}
