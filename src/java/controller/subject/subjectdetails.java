/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.subject;

import dal.ClassDAO;
import dal.SubjectDAO;
import model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.User;

/**
 *
 * @author User
 */
@WebServlet(name="subjectdetails", urlPatterns={"/admin/subjectdetails"})
public class subjectdetails extends HttpServlet {
   
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
            out.println("<title>Servlet subjectdetails</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet subjectdetails at " + request.getContextPath () + "</h1>");
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
        SubjectDAO c= new SubjectDAO();
        String id_raw= request.getParameter("id");
        int id=0;
        if (id_raw!=null){
            id= Integer.parseInt(id_raw);
        }
        Subject s= c.getSubjectById(id);
        ClassDAO cd= new ClassDAO();        
        List<User>managers=cd.getUserByRole(12);
        List<User>experts=cd.getUserByRole(46);
        request.setAttribute("expert", experts);
        request.setAttribute("manager", managers);
        request.setAttribute("data", s);        
        request.getRequestDispatcher("subjectdetails.jsp").forward(request, response);
        
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
        SubjectDAO c= new SubjectDAO();        
        String id_raw= request.getParameter("subject_id");
        int id= Integer.parseInt(id_raw);
        String subject_code= request.getParameter("subject_code");
        String subject_name=request.getParameter("subject_name");
        String manager_id_raw= request.getParameter("manager_id");
        int manager_id=Integer.parseInt(manager_id_raw);
        String expert_id_raw=request.getParameter("expert_id");        
        int expert_id=Integer.parseInt(expert_id_raw);
        String status= request.getParameter("status");
        String description= request.getParameter("description");
        c.updateSubject(id, subject_code, subject_name, manager_id, expert_id, status, description);
        request.setAttribute("mess", "Update successfully");
        request.getRequestDispatcher("subjectdetails.jsp").forward(request, response);
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
