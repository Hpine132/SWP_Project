/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.milestone;

import dal.milestoneDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Milestone;

/**
 *
 * @author nguye
 */
public class MilestoneList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        milestoneDAO mileDAO = new milestoneDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;
        request.setAttribute("isMilestoneList", "true");

        int total = mileDAO.getTotalMilestone();

        int numberPageHome = (total % 5 == 0 ? (total / 5) : ((total / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        String sort = request.getParameter("sort");

        if (sort != null && sort.equalsIgnoreCase("ascId")) {
            List<Milestone> listMilestoneSortByID = mileDAO.getSettingWithPaggingSort(page, pageSzie, "milestone_id asc");
            request.getSession().setAttribute("listMilestone", listMilestoneSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("milestoneList.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descId")) {
            List<Milestone> listMilestoneSortByID = mileDAO.getSettingWithPaggingSort(page, pageSzie, "milestone_id desc");
            request.getSession().setAttribute("listMilestone", listMilestoneSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("milestoneList.jsp").forward(request, response);
        } else {
            List<Milestone> list = mileDAO.getSettingWithPagging(page, pageSzie);
            request.getSession().setAttribute("listMilestone", list);
            request.getRequestDispatcher("milestoneList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        milestoneDAO mileDAO = new milestoneDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;
        request.setAttribute("isMilestoneList", "true");

        int total = mileDAO.getTotalMilestone();

        int numberPageHome = (total % 5 == 0 ? (total / 5) : ((total / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        String sort = request.getParameter("sort");
        request.setAttribute("sussces", "1");
        List<Milestone> list = mileDAO.getSettingWithPagging(page, pageSzie);
        request.setAttribute("listMilestone", list);
        request.getRequestDispatcher("milestoneList.jsp").forward(request, response);
        
    }
}
