/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.attendance;

import dal.AttendanceDAO;
import dal.ClassDAO;
import dal.ClassSettingDAO;
import dal.ClassUserDAO;
import dal.scheduleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import model.Attendance;
import model.Schedule;
import model.ScheduleAttendanceModel;
import model.User;

/**
 *
 * @author User
 */
@WebServlet(name = "ScheduleAttendance", urlPatterns = {"/admin/scheduleattendance"})
public class ScheduleAttendance extends HttpServlet {

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
            out.println("<title>Servlet ScheduleAttendance</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ScheduleAttendance at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        ClassUserDAO cud = new ClassUserDAO();
        AttendanceDAO ad = new AttendanceDAO();
        List<model.Class> listClass = cud.getClassByTraineeId(user.getId());
        request.setAttribute("listClass", listClass);
        scheduleDAO scheduleDAO = new scheduleDAO();
        int class_id = 0;
        String class_id_raw = request.getParameter("class_id");
        if (class_id_raw != null) {
            class_id = Integer.parseInt(class_id_raw);
            List<Schedule> listSchedule = scheduleDAO.getScheduleOfClass(class_id);
            List<Attendance> data = new ArrayList<>();
            for (int i = 0; i < listSchedule.size(); i++) {
                Attendance x = ad.getByKey(class_id, listSchedule.get(i).getSchedule_id(), user.getId());
                data.add(x);
            }
            List<ScheduleAttendanceModel> datax = new ArrayList<>();
            ClassSettingDAO csd = new ClassSettingDAO();
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i) != null) {
                    String slot = csd.getById(data.get(i).getSchedule_id().getSlot_id()).getSetting_value();
                    String training_date = data.get(i).getSchedule_id().getTraining_date();
                    Time from_time = data.get(i).getSchedule_id().getFrom_time();
                    Time to_time = data.get(i).getSchedule_id().getTo_time();
                    String room = csd.getById(data.get(i).getSchedule_id().getRoom_id()).getSetting_value();
                    String attendance = data.get(i).getStatus();
                    String comment = data.get(i).getComment();
                    ScheduleAttendanceModel xx = new ScheduleAttendanceModel(slot, training_date, from_time, to_time, room, attendance, comment);
                    datax.add(xx);
                } else {
                    String slot = csd.getById(listSchedule.get(i).getSlot_id()).getSetting_value();
                    String training_date = listSchedule.get(i).getTraining_date();
                    Time from_time = listSchedule.get(i).getFrom_time();
                    Time to_time = listSchedule.get(i).getTo_time();
                    String room = csd.getById(listSchedule.get(i).getRoom_id()).getSetting_value();
                    String attendance = "Future";
                    String comment = "";
                    ScheduleAttendanceModel xx = new ScheduleAttendanceModel(slot, training_date, from_time, to_time, room, attendance, comment);
                    datax.add(xx);
                }

            }
            request.setAttribute("data", datax);
        }
        request.getRequestDispatcher("scheduleattendance.jsp").forward(request, response);
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
