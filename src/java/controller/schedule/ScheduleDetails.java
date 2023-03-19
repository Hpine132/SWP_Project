/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.schedule;

import dal.ClassDAO;
import dal.ClassSettingDAO;
import dal.scheduleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.sql.Date;
import model.Schedule;

/**
 *
 * @author nguye
 */
public class ScheduleDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        scheduleDAO s = new scheduleDAO();
        ClassDAO c = new ClassDAO();
        ClassSettingDAO cs = new ClassSettingDAO();
        request.setAttribute("classList", c.getClassById(s.getClassbySId(id)));
        request.setAttribute("roomList", cs.getAllRoom(13));
        request.setAttribute("slotList", cs.getAllSlot(14));
        Schedule schedule = s.getScheduleById2(id);
        request.setAttribute("schedule", schedule);
        request.setAttribute("from_time",(Time)schedule.getFrom_time());
        request.setAttribute("to_time",(Time)schedule.getTo_time());
        request.getRequestDispatcher("scheduleDetails.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("id"));
        Date training_date=Date.valueOf(request.getParameter("training_date"));
        String status = request.getParameter("status");
        int statu=0;
        if (status.equalsIgnoreCase("taken")) {
            statu = 1;
        }
        ClassDAO c = new ClassDAO();
        int class_id = c.getClassByCode(request.getParameter("classList")).getClass_id();
        int room_id = Integer.parseInt(request.getParameter("roomList"));
        int slot_id = Integer.parseInt(request.getParameter("slotList"));
        Time from_time = Time.valueOf((String)request.getParameter("from_time"));
        Time to_time = Time.valueOf((String)request.getParameter("to_time"));
        scheduleDAO s = new scheduleDAO();
        s.updateSchedule(id, class_id, slot_id, room_id, training_date, from_time, to_time, statu);
        request.setAttribute("sussces", "1");
        request.getRequestDispatcher("ScheduleList?page=1&sort=").forward(request, response);
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
