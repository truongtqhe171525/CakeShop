package com.example.cake.controllers;

import com.example.cake.dao.ClientDAO;
import com.example.cake.utils.FailSignin;
import com.example.cake.utils.UserOut;
import com.example.cake.utils.ValidUtils;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet({"/login"})
public class LoginController extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("User") == null) {
            String errorString = null;
            if (request.getAttribute("errorString") != null) {
                errorString = (String)request.getAttribute("errorString");
            }

            request.getSession().removeAttribute("Check");
            request.setAttribute("errorString", errorString);
            request.getServletContext().getRequestDispatcher("/Pages/login.jsp").forward(request, response);
        } else {
            request.getServletContext().getRequestDispatcher("/UserManual").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        FailSignin failSignin = new FailSignin();
        ClientDAO loginDao = new ClientDAO();

        if(ValidUtils.isEmpty(account)) failSignin.setMessage("Account is required");
        else if(!ValidUtils.isPhone(account) && !ValidUtils.isEmail(account)) failSignin.setMessage("Email or Phone Number is invalid");
//        if(ValidUtils.isEmpty(password)) failSignin.setMessage("Password is required");
//        else if(!ValidUtils.isPassword(password)) failSignin.setMessage("Password is invalid");

        if(failSignin.getMessage() != null){
            request.setAttribute("failSignin", failSignin);
            request.setAttribute("account", account);
            request.getServletContext().getRequestDispatcher("/Pages/login.jsp").forward(request, response);
        }
        else{
            FailSignin result = loginDao.login(account, password);
            if(result == null){
                UserOut user = loginDao.getUser(account,password);
                Gson gson = new Gson();
                request.getSession().setAttribute("user", gson.toJson(user));
                response.sendRedirect("/home");
            }
            else{
                request.setAttribute("failSignin", result);
                request.setAttribute("account", account);
                request.getServletContext().getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            }
        }

    }
}
