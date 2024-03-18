package com.example.cake.controllers;

import com.example.cake.dao.ClientDAO;
import com.example.cake.utils.FailSignin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import com.example.cake.utils.ValidUtils;

@WebServlet({"/signin"})
public class SigninController extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("User") == null) {
            String errorString = null;
            if (request.getAttribute("errorString") != null) {
                errorString = (String)request.getAttribute("errorString");
            }

            request.getSession().removeAttribute("Check");
            request.setAttribute("errorString", errorString);
            request.getServletContext().getRequestDispatcher("/Pages/signin.jsp").forward(request, response);
        } else {
            request.getServletContext().getRequestDispatcher("/UserManual").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String comfirmPassword = request.getParameter("comfirmPassword");

        ClientDAO loginDao = new ClientDAO();
        FailSignin failSignin = new FailSignin();

        if(ValidUtils.isEmpty(name)) failSignin.setName("Name is required");
        else if(!ValidUtils.isName(name)) failSignin.setName("Name is invalid");
        if(ValidUtils.isEmpty(email)) failSignin.setEmail("Email is required");
        else if(!ValidUtils.isEmail(email)) failSignin.setEmail("Email is invalid");
        if(ValidUtils.isEmpty(phone)) failSignin.setPhone("Phone is required");
        else if(!ValidUtils.isPhone(phone)) failSignin.setPhone("Phone is invalid");
//        if(ValidUtils.isEmpty(password)) failSignin.setPassword("Password is required");
//        else if(!ValidUtils.isPassword(password)) failSignin.setPassword(ValidUtils.checkPassword(password));
        if(ValidUtils.isEmpty(comfirmPassword)) failSignin.setComfirmPassword("Comfirm Password is required");
        else if(!password.equals(comfirmPassword)) failSignin.setComfirmPassword("Comfirm Password is not match");

        if(failSignin.getName() != null || failSignin.getEmail() != null || failSignin.getPhone() != null || failSignin.getPassword() != null || failSignin.getComfirmPassword() != null){
            request.setAttribute("failSignin", failSignin);
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("password", password);
            request.setAttribute("comfirmPassword", comfirmPassword);
            request.getServletContext().getRequestDispatcher("/Pages/signin.jsp").forward(request, response);
        } else {
            failSignin = loginDao.register(name,email,phone,password);
            if(failSignin != null && (failSignin.getEmail() != null || failSignin.getPhone() != null || failSignin.getMessage() != null)){
                request.setAttribute("failSignin", failSignin);
                request.setAttribute("name", name);
                request.setAttribute("email", email);
                request.setAttribute("phone", phone);
                request.setAttribute("password", password);
                request.setAttribute("comfirmPassword", comfirmPassword);
                request.getServletContext().getRequestDispatcher("/Pages/signin.jsp").forward(request, response);
            }
            else{
                request.getSession().setAttribute("Check", "true");
                request.getServletContext().getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            }
        }

    }
}
