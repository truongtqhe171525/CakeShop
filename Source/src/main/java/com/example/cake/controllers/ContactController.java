package com.example.cake.controllers;

import com.example.cake.models.CakeDetailModel;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/contact")
public class ContactController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("userInfor", new Gson().toJson(request.getSession().getAttribute("user")));
        request.getRequestDispatcher("/Pages/contact.jsp").forward(request, response);
    }

}
