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
import model.EvalCriteria;

/**
 *
 * @author Admin
 */
@WebServlet(name="EvalCriterialListBySearch", urlPatterns={"/admin/evalcriteriallistbysearch"})
public class EvalCriterialListBySearch extends HttpServlet {
   
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
            out.println("<title>Servlet EvalCriterialListBySearch</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EvalCriterialListBySearch at " + request.getContextPath () + "</h1>");
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
         String searchTittle = request.getParameter("searchTittle");
        request.setAttribute("searchTittle", searchTittle);
        evalCriteriaDAO evalCriteriaDAO = new evalCriteriaDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;
        
        assignmentDAO assignmentDAO = new assignmentDAO();
        List<Assignment> listAssignmentForId = assignmentDAO.getAllAssignment();
        request.setAttribute("listAssignmentForId", listAssignmentForId);
        
        int totalEvalCriteria = evalCriteriaDAO.getTotalEvalCriteriaListByCriteriaName(searchTittle);
        int numberPageHome = (totalEvalCriteria % 5 == 0 ? (totalEvalCriteria / 5) : ((totalEvalCriteria / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        request.setAttribute("isEvalCriteriaList", "true");

        String sort = request.getParameter("sort");
            
         if (sort != null && sort.equalsIgnoreCase("ascId")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "criteria_id asc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descId")) {
              List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "criteria_id desc");
             request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descAssignmentId")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "ass_id_cri desc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascAssignmentId")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "ass_id_cri asc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascMilestoneId")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "milestone_id asc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
           request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descMilestoneId")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "milestone_id desc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
           request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascCriterianame")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "criteria_name asc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descCriterianame")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "criteria_name desc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascTeameval")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "is_team_eval asc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descTeameval")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "is_team_eval desc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascEvalWeight")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "`eval_weight` asc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descEvalWeight")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "`eval_weight` desc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("ascMaxloc")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "max_loc asc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descMaxloc")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getEvalCriteriaListByNameSort(page, pageSzie,searchTittle, "max_loc desc");
            request.setAttribute("listevalcriteriasearchbyname", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else {
            List<EvalCriteria> list = evalCriteriaDAO.getEvalCriteriaListByName(page, pageSzie, searchTittle);
            request.setAttribute("listevalcriteriasearchbyname", list);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        }
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
        processRequest(request, response);
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
