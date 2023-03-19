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
public class forgetPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        SMTP smtp = new SMTP("smtp.mailtrap.io", "2525", "ced2e76e92d9b5", "591aabb0fe569f");
        smtp.connect();
        userDAO u = new userDAO();
        String email = request.getParameter("email");
        User user = u.getUser(email);
        Validate v = new Validate();
        String pass = v.generatePassword(8);
        u.ChangPassword(pass, user.getId());
        smtp.sendMimeMessageWithThread("Training Support System (No-Reply)", email, "[Tss] Password Recovery", pass);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}
