package com.example.cake.dao;

import com.example.cake.Connect;
import com.example.cake.models.CakeDetailModel;
import com.example.cake.models.CakeImagesModel;
import com.example.cake.models.CakeSizesModel;
import com.example.cake.models.CakesModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CakesDAO {
    private Connection conn = Connect.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<CakeDetailModel> getAllCakeDetail(){
        try{
            List<CakeSizesModel> allSizes = new ArrayList<>();
            ps = conn.prepareStatement("select * from CakeSizes");
            rs = ps.executeQuery();
            while(rs.next()){
                allSizes.add(new CakeSizesModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            List<CakeImagesModel> allImages = new ArrayList<>();
            ps = conn.prepareStatement("select * from CakeImages");
            rs = ps.executeQuery();
            while(rs.next()){
                allImages.add(new CakeImagesModel(rs.getInt(1), rs.getString(2)));
            }
            List<CakeDetailModel> allCakeDetail= new ArrayList<>();
            ps = conn.prepareStatement("select * from cakes");
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);

                List<CakeImagesModel> cakeImages = new ArrayList<>();
                List<CakeSizesModel> cakeSizes = new ArrayList<>();
                allImages.forEach(image ->{
                    if(image.getIdCake() == id) cakeImages.add(image);
                });
                allSizes.forEach(size -> {
                    if(size.getIdCake() == id) cakeSizes.add(size);
                });

                allCakeDetail.add(new CakeDetailModel(id,name,description,cakeImages,cakeSizes));
            }
            return allCakeDetail;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public CakeDetailModel getCakeDetailById(int id){
        try{
            ps = conn.prepareStatement("select * from cakes where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            CakesModel cake = new CakesModel();
            if(rs == null) return null;

            while(rs.next()){
                 cake.setId(rs.getInt(1));
                 cake.setName(rs.getString(2));
                 cake.setDescription(rs.getString(3));
            }

            List<CakeSizesModel> cakeSizes = new ArrayList<>();
            ps = conn.prepareStatement("select * from CakeSizes where id_cake = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                cakeSizes.add(new CakeSizesModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            List<CakeImagesModel> cakeImages = new ArrayList<>();
            ps = conn.prepareStatement("select * from CakeImages where id_cake = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                cakeImages.add(new CakeImagesModel(rs.getInt(1), rs.getString(2)));
            }
            return new CakeDetailModel(cake.getId(),cake.getName(),cake.getDescription(),cakeImages,cakeSizes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
