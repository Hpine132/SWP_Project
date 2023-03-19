/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.evalcriteria;

import dal.assignmentDAO;
import dal.evalCriteriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Assignment;

/**
 *
 * @author Admin
 */
@WebServlet(name="AddNewEvalcritaria", urlPatterns={"/admin/addnewevalcritaria"})
public class AddNewEvalcritaria extends HttpServlet {
   
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
            out.println("<title>Servlet AddNewEvalcritaria</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewEvalcritaria at " + request.getContextPath () + "</h1>");
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
        assignmentDAO assignmentDAO = new assignmentDAO();
        List<Assignment> assignmentList = assignmentDAO.getAllAssignment();
        request.setAttribute("assignmentList", assignmentList);
        request.getRequestDispatcher("addevalcriteria.jsp").forward(request, response);
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
       String assId_raw = request.getParameter("assid");
        int assId = Integer.parseInt(assId_raw);
        String evalweight = request.getParameter("evalweight");
        double evalweight1 = Double.parseDouble(evalweight);
        String status = request.getParameter("status");
        int status1 = Integer.parseInt(status);
        String evalname = request.getParameter("evalname");
        String desc = request.getParameter("desc");
        String maxLoc_raw = request.getParameter("maxloc");
        int maxLoc = Integer.parseInt(maxLoc_raw);
        String isTeamEval_raw = request.getParameter("teameval");
        int isTeamEval = Integer.parseInt(isTeamEval_raw);
        evalCriteriaDAO evalDAO = new evalCriteriaDAO();
        evalDAO.InsertEvalcriteria(assId, evalname, isTeamEval, evalweight1, maxLoc, status1, desc);
        request.setAttribute("sussces", "1");
        request.getRequestDispatcher("/admin/evalcriterialist").forward(request, response);
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
