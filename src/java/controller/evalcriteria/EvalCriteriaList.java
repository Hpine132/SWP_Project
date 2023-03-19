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
@WebServlet(name = "EvalCriteriaList", urlPatterns = {"/admin/evalcriterialist"})
public class EvalCriteriaList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EvalCriteriaList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EvalCriteriaList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        evalCriteriaDAO evalCriteriaDAO = new evalCriteriaDAO();
        assignmentDAO assignmentDAO = new assignmentDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;

        
        List<Assignment> listAssignmentForId = assignmentDAO.getAllAssignment();
        request.setAttribute("listAssignmentForId", listAssignmentForId);
        List<Subject> listSubject = subjectDAO.getSubjectList();
        request.setAttribute("listSubject", listSubject);
        request.setAttribute("isEvalCriteriaList", "true");

        int totalEvalCriteria = evalCriteriaDAO.getTotalEvalCriteria();

        int numberPageHome = (totalEvalCriteria % 5 == 0 ? (totalEvalCriteria / 5) : ((totalEvalCriteria / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        String sort = request.getParameter("sort");

        if (sort != null && sort.equalsIgnoreCase("ascId")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "criteria_id asc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descId")) {
             List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "criteria_id desc");
             request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descAssignmentId")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "`ass_id_cri` asc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascAssignmentId")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "`ass_id_cri` desc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascMilestoneId")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "milestone_id_cri asc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
           request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descMilestoneId")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "milestone_id_cri desc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
           request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascCriterianame")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "criteria_name asc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descCriterianame")) {
           List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "criteria_name desc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascTeameval")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "is_team_eval asc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descTeameval")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "is_team_eval desc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascEvalWeight")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "`eval_weight` asc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descEvalWeight")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "`eval_weight` desc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("ascMaxloc")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "max_loc asc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descMaxloc")) {
            List<EvalCriteria> listEvalCriteriaSortByID = evalCriteriaDAO.getSettingWithPaggingSort(page, pageSzie, "max_loc desc");
            request.setAttribute("listevalcriteria", listEvalCriteriaSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        } else {
            List<EvalCriteria> listEvalCriteria = evalCriteriaDAO.getEvalCriteriaWithPagging(page, pageSzie);
            request.setAttribute("listevalcriteria", listEvalCriteria);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        evalCriteriaDAO evalCriteriaDAO = new evalCriteriaDAO();
        assignmentDAO assignmentDAO = new assignmentDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;

        
        List<Assignment> listAssignmentForId = assignmentDAO.getAllAssignment();
        request.setAttribute("listAssignmentForId", listAssignmentForId);
        List<Subject> listSubject = subjectDAO.getSubjectList();
        request.setAttribute("listSubject", listSubject);
        request.setAttribute("isEvalCriteriaList", "true");

        int totalEvalCriteria = evalCriteriaDAO.getTotalEvalCriteria();

        int numberPageHome = (totalEvalCriteria % 5 == 0 ? (totalEvalCriteria / 5) : ((totalEvalCriteria / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);      
            List<EvalCriteria> listEvalCriteria = evalCriteriaDAO.getEvalCriteriaWithPagging(page, pageSzie);
            request.setAttribute("listevalcriteria", listEvalCriteria);
            request.getRequestDispatcher("listevalcriteria.jsp").forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
