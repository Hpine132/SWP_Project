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
import jakarta.servlet.annotation.WebServlet;
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
@WebServlet(name = "AssignmentList", urlPatterns = {"/admin/assignmentlist"})
public class AssignmentList_1 extends HttpServlet {

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
            out.println("<title>Servlet AssignmentList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AssignmentList at " + request.getContextPath() + "</h1>");
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
        
        
        List<Subject> listSubject = subjectDAO.getSubjectList();
        request.setAttribute("listSubject", listSubject);
        request.setAttribute("isAssignmentList", "true");

        int totalAssignment = assignmentDAO.getTotalAssignment();

        int numberPageHome = (totalAssignment % 5 == 0 ? (totalAssignment / 5) : ((totalAssignment / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        String sort = request.getParameter("sort");

        if (sort != null && sort.equalsIgnoreCase("ascId")) {
            List<Assignment> listAssignmentSortByID = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "ass_id asc");
            request.setAttribute("listAssignment", listAssignmentSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descId")) {
            List<Assignment> listAssignmentSortByID = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "ass_id desc");
            request.setAttribute("listAssignment", listAssignmentSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascSubjectId")) {
            List<Assignment> listAssignmentSortBySubjectId = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "`subject_id_ass` asc");
            request.setAttribute("listAssignment", listAssignmentSortBySubjectId);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descSubjectId")) {
            List<Assignment> listAssignmentSortBySubjectId = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "`subject_id_ass` desc");
            request.setAttribute("listAssignment", listAssignmentSortBySubjectId);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascTittle")) {
           List<Assignment> listAssignmentSortByTittle = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "tittle asc");
            request.setAttribute("listAssignment", listAssignmentSortByTittle);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descTittle")) {
            List<Assignment> listAssignmentSortByTittle = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "tittle desc");
            request.setAttribute("listAssignment", listAssignmentSortByTittle);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascAssBody")) {
            List<Assignment> listAssignmentSortByTittle = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "`ass_body` asc");
            request.setAttribute("listAssignment", listAssignmentSortByTittle);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descAssBody")) {
             List<Assignment> listAssignmentSortByTittle = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "`ass_body` desc");
            request.setAttribute("listAssignment", listAssignmentSortByTittle);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascEvalWeight")) {
            List<Assignment> listAssignmentSortByTittle = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "`eval_weight` asc");
            request.setAttribute("listAssignment", listAssignmentSortByTittle);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descEvalWeight")) {
             List<Assignment> listAssignmentSortByTittle = assignmentDAO.getSettingWithPaggingSort(page, pageSzie, "`eval_weight` desc");
            request.setAttribute("listAssignment", listAssignmentSortByTittle);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        } else {
            List<Assignment> listAssignment = assignmentDAO.getSettingWithPagging(page, pageSzie);
            request.setAttribute("listAssignment", listAssignment);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
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

        List<Subject> listSubject = subjectDAO.getSubjectList();
        request.setAttribute("listSubject", listSubject);
        request.setAttribute("isAssignmentList", "true");
        request.setAttribute("isAssignmentList", "true");

        int totalAssignment = assignmentDAO.getTotalAssignment();

        int numberPageHome = (totalAssignment % 5 == 0 ? (totalAssignment / 5) : ((totalAssignment / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        String sort = request.getParameter("sort");
      
            List<Assignment> listAssignment = assignmentDAO.getSettingWithPagging(page, pageSzie);
            request.setAttribute("listAssignment", listAssignment);
            request.getRequestDispatcher("assignmentlist.jsp").forward(request, response);
        
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
