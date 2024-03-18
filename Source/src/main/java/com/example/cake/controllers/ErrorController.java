package com.example.cake.controllers;

import com.example.cake.models.CakeDetailModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

import com.example.cake.dao.CakesDAO;
import com.google.gson.Gson;

@WebServlet("/error")
public class ErrorController extends HttpServlet {
    public final CakesDAO cakesService = new CakesDAO();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
    }

}
