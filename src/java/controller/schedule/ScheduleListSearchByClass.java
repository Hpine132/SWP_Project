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
import java.util.ArrayList;
import java.util.List;
import model.Schedule;

/**
 *
 * @author nguye
 */
public class ScheduleListSearchByClass extends HttpServlet {

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
        scheduleDAO s = new scheduleDAO();
        String searchTittles = request.getParameter("searchTittle").trim();
        request.setAttribute("searchTittle", searchTittles);
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;
        String searchTittle = "%"+searchTittles+"%";
        request.setAttribute("isScheduleList", "true");
        int total = s.getTotalScheduleListByClass(searchTittle);
        int numberPageHome = (total % 5 == 0 ? (total / 5) : ((total / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);
        
        String sort = request.getParameter("sort");
        if (sort != null && sort.equalsIgnoreCase("ascClass")) {
            List<Schedule> list = s.getScheduleListByClassSort(page, pageSzie,searchTittle, "class_id_schedule asc");
            request.setAttribute("schedulelistsearchbyclass", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descClass")) {
            List<Schedule> list = s.getScheduleListByClassSort(page, pageSzie,searchTittle, "class_id_schedule desc");
            request.setAttribute("schedulelistsearchbyclass", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descRoom")) {
            List<Schedule> list = s.getScheduleListByClassSort(page, pageSzie,searchTittle, "room_id_schedule asc");
            request.setAttribute("schedulelistsearchbyclass", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descRoom")) {
            List<Schedule> list = s.getScheduleListByClassSort(page, pageSzie,searchTittle, "room_id_schedule desc");
            request.setAttribute("schedulelistsearchbyclass", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descSlot")) {
            List<Schedule> list = s.getScheduleListByClassSort(page, pageSzie,searchTittle, "slot_id_schedule asc");
            request.setAttribute("schedulelistsearchbyclass", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descSlot")) {
            List<Schedule> list = s.getScheduleListByClassSort(page, pageSzie,searchTittle, "slot_id_schedule desc");
            request.setAttribute("schedulelistsearchbyclass", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("ascDate")) {
            List<Schedule> list = s.getScheduleListByClassSort(page, pageSzie,searchTittle, "training_date asc");
            request.setAttribute("schedulelistsearchbyclass", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else if (sort != null && sort.equalsIgnoreCase("descDate")) {
            List<Schedule> list = s.getScheduleListByClassSort(page, pageSzie,searchTittle, "training_date desc");
            request.setAttribute("schedulelistsearchbyclass", list);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
        }else {
            List<Schedule> list = s.getScheduleListByClass(page, pageSzie, searchTittle);
            request.setAttribute("schedulelistsearchbyclass", list);
            request.getRequestDispatcher("scheduleList.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
