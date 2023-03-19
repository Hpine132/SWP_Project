/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.assignment;

import dal.assignmentDAO;
import dal.settingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Assignment;
import model.Setting;

/**
 *
 * @author Admin
 */
@WebServlet(name="AssignmentDetails", urlPatterns={"/admin/assignmentdetails"})
public class AssignmentDetails extends HttpServlet {
   
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
            out.println("<title>Servlet AssignmentDetails</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AssignmentDetails at " + request.getContextPath () + "</h1>");
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
       String idAssignment_raw = request.getParameter("id");
        int id = Integer.parseInt(idAssignment_raw);
        assignmentDAO assignmentDAO = new assignmentDAO();
        Assignment assignmentById = assignmentDAO.getAssignmentById(id);
        request.setAttribute("assignmentById", assignmentById);
        request.setAttribute("isAssignmentList", "true");
        request.getRequestDispatcher("assignmentdetails.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        int id1 = Integer.parseInt(id);
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
        assignmentDAO.updateAssignment(id1, tittle, assbody, evalweight1, status1,teamWork1,onGoing1);
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
