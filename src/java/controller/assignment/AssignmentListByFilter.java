/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.assignment;

import dal.assignmentDAO;
import dal.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Assignment;
import model.Subject;

/**
 *
 * @author Admin
 */
public class AssignmentListByFilter extends HttpServlet {
   
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
            out.println("<title>Servlet ListAssignmentByFilter</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListAssignmentByFilter at " + request.getContextPath () + "</h1>");
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
         int statusId =-1;
        int subjectId = -1;
              
        String Status_raw = request.getParameter("Status");  
        if(!Status_raw.equals("")){           
         statusId=Integer.parseInt(Status_raw);
        }
        String subjectId_raw = request.getParameter("subjectId");  
        if(!Status_raw.equals("")){           
         subjectId=Integer.parseInt(subjectId_raw);
        }
        
        request.setAttribute("subjectId", subjectId_raw);
        request.setAttribute("Status", Status_raw);
        SubjectDAO subjectDAO = new SubjectDAO();
        assignmentDAO assignmentDAO = new assignmentDAO();
        List<Assignment> listAssignmentByFilter = assignmentDAO.getAssignmentWithFilter(subjectId, statusId);
        request.setAttribute("listAssignmentByFilter", listAssignmentByFilter);
        List<Subject> listSubject = subjectDAO.getSubjectList();        
        request.setAttribute("listSubject", listSubject);
        request.setAttribute("isAssignmentList", "true");
        request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
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
