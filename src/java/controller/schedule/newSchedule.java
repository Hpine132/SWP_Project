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
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 *
 * @author nguye
 */
public class newSchedule extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassDAO c = new ClassDAO();
        ClassSettingDAO cs = new ClassSettingDAO();
        request.setAttribute("classList", c.getAllClass());
        request.setAttribute("roomList", cs.getAllRoom(13));
        request.setAttribute("slotList", cs.getAllSlot(14));
        request.getRequestDispatcher("newSchedule.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Time from_time = null, to_time = null;
        ClassSettingDAO c = new ClassSettingDAO();
        scheduleDAO sche = new scheduleDAO();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date training_date = null;
        try {
            training_date = date.parse(request.getParameter("training_date"));
        } catch (Exception e) {
        }
        if (request.getParameter("slotList").equals("Slot 1")) {
            from_time = Time.valueOf("7:30:00");
            to_time = Time.valueOf("9:00:00");
        }
        if (request.getParameter("slotList").equals("Slot 2")) {
            from_time = Time.valueOf("9:10:00");
            to_time = Time.valueOf("10:40:00");
        }
        if (request.getParameter("slotList").equals("Slot 3")) {
            from_time = Time.valueOf("10:50:00");
            to_time = Time.valueOf("12:20:00");
        }
        if (request.getParameter("slotList").equals("Slot 4")) {
            from_time = Time.valueOf("12:50:00");
            to_time = Time.valueOf("14:20:00");
        }
        if (request.getParameter("slotList").equals("Slot 5")) {
            from_time = Time.valueOf("14:30:00");
            to_time = Time.valueOf("16:00:00");
        }
        if (request.getParameter("slotList").equals("Slot 6")) {
            from_time = Time.valueOf("16:10:00");
            to_time = Time.valueOf("17:40:00");
        }
        int status = 0;
        if (request.getParameter("status").equalsIgnoreCase("Taken")) {
            status = 1;
        }
        int classId = Integer.parseInt(request.getParameter("classList"));
        c.newSetting(14, "slot", (String) request.getParameter("slotList"), classId);
        c.newSetting(13, "room", (String) request.getParameter("roomList"), classId);
        int roomId = c.getClassSettings((String) request.getParameter("roomList"), classId);
        int slotId = c.getClassSettings((String) request.getParameter("slotList"), classId);
        sche.newSchedule(classId, slotId, roomId, new java.sql.Date(training_date.getTime()), from_time, to_time, status);
        String mess = "Update successful";
        request.setAttribute("mess", mess);
        request.getRequestDispatcher("ScheduleList?").forward(request, response);
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
