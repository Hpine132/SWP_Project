/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.assignment;

import dal.SubjectDAO;
import dal.assignmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Subject;

/**
 *
 * @author Admin
 */
@WebServlet(name="AddNewAssignment", urlPatterns={"/admin/addnewassignment"})
public class AddNewAssignment extends HttpServlet {
   
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
            out.println("<title>Servlet AddNewAssignment</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewAssignment at " + request.getContextPath () + "</h1>");
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
        SubjectDAO subjectDAO = new SubjectDAO();
        List<Subject> listSubject = subjectDAO.getSubjectList();
        request.setAttribute("listsubject", listSubject);
        request.getRequestDispatcher("addassignment.jsp").forward(request, response);
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
        String subjectId_raw = request.getParameter("subjectid");
        int subjectId = Integer.parseInt(subjectId_raw);
        String evalweight = request.getParameter("evalweight");
        double evalweight1 = Double.parseDouble(evalweight);
        String status = request.getParameter("status");
        int status1 = Integer.parseInt(status);
        String assbody = request.getParameter("assbody");
        String tittle = request.getParameter("tittle");
        String teamWork = request.getParameter("teamwork");
        int teamWork1 = Integer.parseInt(teamWork);
        String onGoing = request.getParameter("ongoing");
        int onGoing1 = Integer.parseInt(onGoing);
        assignmentDAO assignmentDAO = new assignmentDAO();
        assignmentDAO.InsertAssignment(subjectId, tittle, assbody, evalweight1,teamWork1,onGoing1,status1);
        request.setAttribute("sussces", "1");
        request.getRequestDispatcher("/admin/assignmentlist").forward(request, response);
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
