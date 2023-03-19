/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.classsetting;

import dal.ClassDAO;
import dal.settingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Class;
import model.Setting;
import model.User;

/**
 *
 * @author User
 */
@WebServlet(name="classdetails", urlPatterns={"/admin/classdetails"})
public class classdetails extends HttpServlet {
   
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
            out.println("<title>Servlet classdetails</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet classdetails at " + request.getContextPath () + "</h1>");
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
        ClassDAO cd= new ClassDAO();
        String id_raw= request.getParameter("id");
        int id=0;
        if (id_raw!=null){
            id= Integer.parseInt(id_raw);
        }
        Class c=  cd.getClassById(id);
        List<User>trainers=cd.getUserByRole(11);
        settingDAO sd= new settingDAO();
        List<Setting> terms=sd.getSettingByTypeId(6);
        request.setAttribute("term", terms);
        request.setAttribute("trainer", trainers);
        request.setAttribute("data", c);
        request.getRequestDispatcher("classdetails.jsp").forward(request, response);
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
        ClassDAO cd= new ClassDAO();
        String id_raw= request.getParameter("class_id");
        int id= Integer.parseInt(id_raw);
        String classCode= request.getParameter("class_code");
        String trainer_id_raw= request.getParameter("trainer_id");
        int trainer_id= Integer.parseInt(trainer_id_raw);
        String term_id_raw= request.getParameter("term_id");
        int term_id= Integer.parseInt(term_id_raw);
        String status= request.getParameter("status");
        String description= request.getParameter("description");
        cd.updateClass(classCode, trainer_id, term_id, status, description, id);
        request.getRequestDispatcher("classlist").forward(request, response);
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
