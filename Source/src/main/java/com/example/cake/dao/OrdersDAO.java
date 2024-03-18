package com.example.cake.dao;

import com.example.cake.Connect;
import com.example.cake.models.CakesModel;
import com.example.cake.models.OrderDetailsModel;
import com.example.cake.models.OrdersModel;
import com.example.cake.utils.FailOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
    private final Connection conn = Connect.getConnection();
    public List<OrderDetailsModel> getOrderDetaisByIdClient(int icClient){
        List<OrderDetailsModel> listOrderDetails = new ArrayList<>();
        try{
            String query = "select orders.id, orders.id_client, orders.id_cake, cakes.name, cakeImages.url, orders.size, orders.quantity, orders.notice, orders.date, orders.address, orders.total from orders inner join cakes on orders.id_cake = cakes.id inner join cakeImages on orders.id_cake = cakeImages.id_cake where orders.id_client = ? order by orders.id desc";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, icClient);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listOrderDetails.add(new OrderDetailsModel(rs.getInt("id"), icClient, rs.getInt("id_cake"), rs.getString("name"), rs.getString("url"), rs.getString("size"), rs.getInt("quantity"), rs.getString("notice"), rs.getString("date"), rs.getString("address"), rs.getInt("total")));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return listOrderDetails;
    };
    
    public FailOrder createOrder (OrdersModel ordersModel){
        FailOrder failOrder = new FailOrder();
        try{
            String query = "insert into orders (id_client, id_cake, size, quantity, notice, date, address, total) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ordersModel.getIdClient());
            ps.setInt(2, ordersModel.getIdCake());
            ps.setString(3, ordersModel.getSize());
            ps.setInt(4, ordersModel.getQuantity());
            ps.setString(5, ordersModel.getNotice());
            ps.setString(6, ordersModel.getDate());
            ps.setString(7, ordersModel.getAddress());
            ps.setInt(8, ordersModel.getTotal());
            ps.executeUpdate();
            return null;
        }
        catch (Exception ex){
            ex.printStackTrace();
            failOrder.setMessage("Create order fail");
            return failOrder;
        }
    }
}
