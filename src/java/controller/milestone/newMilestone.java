/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.milestone;

import dal.SubjectDAO;
import dal.assignmentDAO;
import dal.milestoneDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Subject;

/**
 *
 * @author nguye
 */
public class newMilestone extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        assignmentDAO ass = new assignmentDAO();
        SubjectDAO sub = new SubjectDAO();
        List<Subject> subject = sub.getSubjectList();
        request.setAttribute("subList", subject);
        request.getRequestDispatcher("newMilestone.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        milestoneDAO mile = new milestoneDAO();
        Date from_date = null, to_date = null;
        try {
            from_date = df.parse(request.getParameter("from_date"));
            to_date = df.parse(request.getParameter("to_date"));
        } catch (Exception e) {
        }
        int assId = Integer.parseInt(request.getParameter("assignment"));
        int classId = 1;
        String title = request.getParameter("title");
        assignmentDAO ass = new assignmentDAO();
        String assBody = ass.getAssignmentById(assId).getAssBody();
        String des = request.getParameter("description");
        int status = 0;
        if (request.getParameter("status").equalsIgnoreCase("In progress")) {
            status = 1;
        }
        if (request.getParameter("status").equalsIgnoreCase("Closed")) {
            status = 2;
        }
        mile.newMilestone(assId, classId, from_date, to_date, title, assBody, des, status);
        request.setAttribute("sussces", "1");
        request.getRequestDispatcher("MilestoneList?").forward(request, response);
    }

}
