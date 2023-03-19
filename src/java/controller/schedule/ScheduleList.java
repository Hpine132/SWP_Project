/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.schedule;

import dal.scheduleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Schedule;

/**
 *
 * @author nguye
 */
public class ScheduleList extends HttpServlet {
   
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        scheduleDAO s = new scheduleDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;
        request.setAttribute("isScheduleList", "true");

        int total = s.getTotalSchedule();

        int numberPageHome = (total % 5 == 0 ? (total / 5) : ((total / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        String sort = request.getParameter("sort");
        if (sort != null && sort.equalsIgnoreCase("ascClass")) {
            List<Schedule> list = s.getSettingWithPaggingSort(page, pageSzie, "class_id_schedule asc");
            request.setAttribute("listSchedule", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descClass")) {
            List<Schedule> list = s.getSettingWithPaggingSort(page, pageSzie, "class_id_schedule desc");
            request.setAttribute("listSchedule", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascRoom")) {
            List<Schedule> list = s.getSettingWithPaggingSort(page, pageSzie, "room_id_schedule asc");
            request.setAttribute("listSchedule", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descRoom")) {
            List<Schedule> list = s.getSettingWithPaggingSort(page, pageSzie, "room_id_schedule desc");
            request.setAttribute("listSchedule", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("ascSlot")) {
            List<Schedule> list = s.getSettingWithPaggingSort(page, pageSzie, "slot_id_schedule asc");
            request.setAttribute("listSchedule", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descSlot")) {
            List<Schedule> list = s.getSettingWithPaggingSort(page, pageSzie, "slot_id_schedule desc");
            request.setAttribute("listSchedule", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("ascDate")) {
            List<Schedule> list = s.getSettingWithPaggingSort(page, pageSzie, "training_date asc");
            request.setAttribute("listSchedule", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descDate")) {
            List<Schedule> list = s.getSettingWithPaggingSort(page, pageSzie, "training_date desc");
            request.setAttribute("listSchedule", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else {
            List<Schedule> list = s.getSettingWithPagging(page, pageSzie);
            request.setAttribute("listSchedule", list);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        scheduleDAO s = new scheduleDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;
        request.setAttribute("isScheduleList", "true");

        int total = s.getTotalSchedule();

        int numberPageHome = (total % 5 == 0 ? (total / 5) : ((total / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        String sort = request.getParameter("sort");
        request.setAttribute("sussces", "1");
        List<Schedule> list = s.getSettingWithPagging(page, pageSzie);
        request.setAttribute("listSchedule", list);
        request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        
    }

}
