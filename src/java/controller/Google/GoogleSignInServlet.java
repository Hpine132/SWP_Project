/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Google;

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
public class GoogleSignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String accessToken = GoogleSupport.getToken(code);
        GoogleDTO user = GoogleSupport.getUserInfo(accessToken);
        String email = user.getEmail();
        String name = user.getName();
        String id = user.getId();
        userDAO us = new userDAO();
        if(us.getUser(email) == null)
            us.register(email, name, id);
        User u = us.Login(email, id);
        request.getSession().setAttribute("account", u);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
