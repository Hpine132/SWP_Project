/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.user;

import model.Validate;
import dal.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Admin
 */
public class changePassword extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet changePassword</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changePassword at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Validate v = new Validate();
        String oldPass = v.SHA256(request.getParameter("oldPass"));
        String newPass = request.getParameter("newPass");
        String renewPass = request.getParameter("reNewPass");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        if(!user.getPass().equals(oldPass)){
            String mess = "Current password is wrong";
            request.setAttribute("mess", mess);
            request.setAttribute("oldPass", oldPass);
            request.setAttribute("newPass", newPass);
            request.setAttribute("renewPass", renewPass);
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
        else if(!newPass.equals(renewPass)){
            String mess = "Re Type New Password is wrong ";
            request.setAttribute("mess", mess);
            request.setAttribute("oldPass", request.getParameter("oldPass"));
            request.setAttribute("newPass", newPass);
            request.setAttribute("renewPass", renewPass);
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
        else if(!newPass.matches(regex)){
            String mess = "New Password minimum eight characters, at least one letter and one number";
            request.setAttribute("mess", mess);
            request.setAttribute("oldPass", request.getParameter("oldPass"));
            request.setAttribute("newPass", newPass);
            request.setAttribute("renewPass", renewPass);
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }else{
            userDAO userDAO = new userDAO();
            userDAO.ChangPassword(newPass, user.getId());
            user = userDAO.Login(user.getEmail(), newPass); 
            session.removeAttribute("account");
            request.setAttribute("sussces", "1");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
