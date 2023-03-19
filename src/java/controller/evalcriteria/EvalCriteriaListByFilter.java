/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.evalcriteria;

import dal.assignmentDAO;
import dal.evalCriteriaDAO;
import dal.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Assignment;
import model.EvalCriteria;
import model.Subject;

/**
 *
 * @author Admin
 */
@WebServlet(name="EvalCriteriaListByFilter", urlPatterns={"/admin/listaevalcriterialbyfilter"})
public class EvalCriteriaListByFilter extends HttpServlet {
   
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
            out.println("<title>Servlet EvalCriteriaListByFilter</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EvalCriteriaListByFilter at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        int assignmentId = -1;
        String subjectId_raw = request.getParameter("subjectId");        
        String Status_raw = request.getParameter("Status");  
        if(!Status_raw.equalsIgnoreCase("No")){           
         statusId=Integer.parseInt(Status_raw);
        }
        String Assignment_raw = request.getParameter("assid");  
        if(!Assignment_raw.equalsIgnoreCase("No")){           
         assignmentId=Integer.parseInt(Assignment_raw);
        }
        
         
        request.setAttribute("assid", Assignment_raw);
        request.setAttribute("Status", Status_raw);
        SubjectDAO subjectDAO = new SubjectDAO();
        evalCriteriaDAO evalCriteriaDAO = new evalCriteriaDAO();      
        List<EvalCriteria> listEvalCriteriaFilter = evalCriteriaDAO.getEvalCriteriaWithFilter(assignmentId ,statusId);
        request.setAttribute("listEvalCriteriaFilter", listEvalCriteriaFilter);
        
        assignmentDAO assignmentDAO = new assignmentDAO();
        List<Assignment> listAssignmentForId = assignmentDAO.getAllAssignment();
        request.setAttribute("listAssignmentForId", listAssignmentForId);
        
        List<Subject> listSubject = subjectDAO.getSubjectList();        
        request.setAttribute("listSubject", listSubject);
        request.setAttribute("isEvalCriteriaList", "true");
        request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
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
