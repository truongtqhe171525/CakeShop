package com.example.cake.controllers;

import com.example.cake.dao.OrdersDAO;
import com.example.cake.models.CakeDetailModel;
import com.example.cake.models.OrdersModel;
import com.example.cake.utils.FailOrder;
import com.example.cake.utils.ValidUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.example.cake.dao.CakesDAO;
import com.google.gson.Gson;

@WebServlet("/cakeDetail")
public class CakesDetailController extends HttpServlet {
    public final CakesDAO cakesDAO = new CakesDAO();
    public final OrdersDAO ordersDAO = new OrdersDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        CakeDetailModel cakeDetail = cakesDAO.getCakeDetailById(id);
        if(cakeDetail == null){
            response.sendRedirect("/error");
        }
        else {
            request.setAttribute("userInfor", new Gson().toJson(request.getSession().getAttribute("user")));
            request.setAttribute("cakeDetail", new Gson().toJson(cakeDetail));
            request.getRequestDispatcher("/Pages/cakeDetail.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FailOrder failOrder = new FailOrder();
        try {
            String id = request.getParameter("idCake");
            String idClient = request.getParameter("idClient");
            String idCake = request.getParameter("idCake");
            String size = request.getParameter("sizeCake");
            String quantity = request.getParameter("quantityCake");
            String notice = request.getParameter("notice");
            String date = request.getParameter("date");
            String address = request.getParameter("address");
            String total = request.getParameter("total");

            OrdersModel order = new OrdersModel();

            if(ValidUtils.isEmpty(id)) failOrder.setMessage("Something went wrong");
            else order.setId(Integer.parseInt(id));
            if(ValidUtils.isEmpty(idClient)) failOrder.setMessage("Need login to order");
            else order.setIdClient(Integer.parseInt(idClient));
            if(ValidUtils.isEmpty(idCake)) failOrder.setMessage("Something went wrong");
            else order.setIdCake(Integer.parseInt(idCake));
            if(ValidUtils.isEmpty(quantity)) failOrder.setMessage("Something went wrong");
            else order.setQuantity(Integer.parseInt(quantity));
            if(ValidUtils.isEmpty(total)) failOrder.setMessage("Something went wrong");
            else order.setTotal(Integer.parseInt(total));

            order.setSize(size);
            order.setNotice(notice);
            order.setDate(date);
            order.setAddress(address);

            if(ValidUtils.isEmpty(id) || ValidUtils.isEmpty(idCake) || ValidUtils.isEmpty(size) || ValidUtils.isEmpty(quantity)){
                failOrder.setMessage("Something went wrong");
            }

            if (!ValidUtils.isEmpty(notice) && !ValidUtils.isNotice(notice)) failOrder.setNotice("Notice is invalid");
            if (ValidUtils.isEmpty(date)) failOrder.setDate("Date is required");
            else {
                long timeNow = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                long timeOrder = 0;
                try {
                    timeOrder = sdf.parse(date).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (timeOrder < timeNow + (30 * 60 * 1000)) failOrder.setDate("Date need to be at least 30 minutes from now");
            }

            if (ValidUtils.isEmpty(address)) failOrder.setAddress("Address is required");
            else if (!ValidUtils.isAddress(address)) failOrder.setAddress("Address is invalid");

            if (failOrder.notice != null || failOrder.date != null || failOrder.address != null || failOrder.message != null) {
                CakeDetailModel cakeDetail = cakesDAO.getCakeDetailById(Integer.parseInt(idCake));
                Object userInfor = request.getSession().getAttribute("user");
                if(userInfor != null) request.setAttribute("userInfor", new Gson().toJson(userInfor));
                else request.setAttribute("userInfor", null);
                request.setAttribute("cakeDetail", new Gson().toJson(cakeDetail));
                request.setAttribute("failOrder", failOrder);
                request.setAttribute("orderData", order);
                request.getServletContext().getRequestDispatcher("/Pages/cakeDetail.jsp").forward(request, response);
            }
            else {
                System.out.println("save");
                failOrder = ordersDAO.createOrder(order);
                if(failOrder == null){
                    CakeDetailModel cakeDetail = cakesDAO.getCakeDetailById(Integer.parseInt(idCake));
                    request.setAttribute("userInfor", new Gson().toJson(request.getSession().getAttribute("user")));
                    request.setAttribute("cakeDetail", new Gson().toJson(cakeDetail));
                    request.setAttribute("saveOrder", "success");
                    request.getServletContext().getRequestDispatcher("/Pages/cakeDetail.jsp").forward(request, response);
                }
                else{
                    CakeDetailModel cakeDetail = cakesDAO.getCakeDetailById(Integer.parseInt(idCake));
                    request.setAttribute("userInfor", new Gson().toJson(request.getSession().getAttribute("user")));
                    request.setAttribute("cakeDetail", new Gson().toJson(cakeDetail));
                    request.setAttribute("failOrder", failOrder);
                    request.setAttribute("orderData", order);
                    request.getServletContext().getRequestDispatcher("/Pages/cakeDetail.jsp").forward(request, response);
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
