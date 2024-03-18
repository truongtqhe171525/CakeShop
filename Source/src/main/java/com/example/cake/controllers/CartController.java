package com.example.cake.controllers;

import com.example.cake.dao.OrdersDAO;
import com.example.cake.models.CakeDetailModel;
import com.example.cake.models.OrderDetailsModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private final OrdersDAO ordersDAO = new OrdersDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userInfor = (String) request.getSession().getAttribute("user");
        if(userInfor!=null){
            JsonObject user = new Gson().fromJson(userInfor, JsonObject.class);
            int idClient = user.get("id").getAsInt();
            List<OrderDetailsModel> orderDetails = ordersDAO.getOrderDetaisByIdClient(idClient);
            request.setAttribute("userInfor", new Gson().toJson(request.getSession().getAttribute("user")));
            request.setAttribute("ordersData", new Gson().toJson(orderDetails));
            request.getRequestDispatcher("/Pages/cart.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/Pages/cart.jsp").forward(request, response);
        }
    }
}
