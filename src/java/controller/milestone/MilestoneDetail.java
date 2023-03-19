/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.milestone;

import dal.SubjectDAO;
import dal.assignmentDAO;
import dal.milestoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Assignment;
import model.Milestone;
import model.Subject;

/**
 *
 * @author nguye
 */
public class MilestoneDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        int id = Integer.parseInt(id_raw);
        milestoneDAO mileDAO = new milestoneDAO();
        Milestone milestone = mileDAO.getMilestoneById(id);
        request.setAttribute("milestoneById", milestone);
        assignmentDAO ass = new assignmentDAO();
        Assignment a = ass.getAssignmentById(milestone.getAssId());
        SubjectDAO sub = new SubjectDAO();
        request.setAttribute("isMilestoneList", "true");
        Subject s = a.getSubjectId();
        request.setAttribute("ass", s.getSubject_name());
        request.getRequestDispatcher("milestoneDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int mileId = Integer.parseInt(request.getParameter("mileId"));
        Date from_date = null, to_date = null;
        try {
            from_date = df.parse(request.getParameter("from_date"));
            to_date = df.parse(request.getParameter("to_date"));
        } catch (Exception e) {
        }
        String status_raw = request.getParameter("status");
        int status = 0;
        if (status_raw.equalsIgnoreCase("In progress")) {
            status = 1;
        }
        if (status_raw.equalsIgnoreCase("Pending")) {
            status = 0;
        }
        if (status_raw.equalsIgnoreCase("Closed")) {
            status = 2;
        }
        String assbody = request.getParameter("assBody");
        String tittle = request.getParameter("tittle");
        milestoneDAO mile = new milestoneDAO();

        mile.updateMilestone(mileId, from_date, to_date, tittle, assbody, tittle, status);
        request.setAttribute("sussces", "1");
        request.getRequestDispatcher("MilestoneList?page=1&sort=").forward(request, response);
        
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
