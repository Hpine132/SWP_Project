/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.user;

import controller.Google.SMTP;
import model.Validate;
import dal.userDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author nguye
 */
public class registerUser extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        userDAO us = new userDAO();
        String email = request.getParameter("email");
        if(us.getUser(email)!=null)
            response.sendRedirect("register.jsp");
        String name = request.getParameter("name");
        String pass = new Validate().generatePassword(8);
        SMTP smtp = new SMTP("smtp.mailtrap.io", "2525", "ced2e76e92d9b5", "591aabb0fe569f");
        smtp.connect();
        smtp.sendMimeMessageWithThread("Training Support System (No-Reply)", email, "[Tss] Password", pass);
        
        us.register(email, name, pass);
        request.getSession().setAttribute("account", us);
        response.sendRedirect("login.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
