/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.attendance;

import dal.AttendanceDAO;
import dal.ClassDAO;
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
import java.util.ArrayList;
import java.util.List;
import model.Attendance;
import model.User;
import model.Class;
import model.ClassUser;
import model.Schedule;

/**
 *
 * @author User
 */
@WebServlet(name="AttendanceDetails", urlPatterns={"/admin/attendancedetails"})
public class AttendanceDetails extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AttendanceDetails</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendanceDetails at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("account");
        ClassDAO classDAO= new ClassDAO();
        scheduleDAO scheduleDAO= new scheduleDAO();
        ClassUserDAO cud= new ClassUserDAO();
        AttendanceDAO ad= new AttendanceDAO();
        List<Class> listClass= classDAO.getClassByTrainerId(user.getId());
        request.setAttribute("listClass", listClass);
        
        int class_id=0;
        Class classx= null;
        String class_id_raw= request.getParameter("class_id");
        if (class_id_raw!=null){
            class_id= Integer.parseInt(class_id_raw);            
            List<Schedule> listSchedule= scheduleDAO.getScheduleOfClass(class_id);
            request.setAttribute("listSchedule", listSchedule);
            session.removeAttribute("data");
        }
        
        int schedule_id;
        String schedule_id_raw = request.getParameter("schedule_id");
        if (schedule_id_raw!=null){
            schedule_id= Integer.parseInt(schedule_id_raw);
            Schedule schedule = scheduleDAO.getScheduleById(schedule_id);
            classx= classDAO.getClassById(schedule.getClass_id());
            List<ClassUser> listClassUser= cud.getClassUserByClassId(schedule.getClass_id());
            List<Attendance> data= new ArrayList<>();
            for (int i= 0; i< listClassUser.size(); i++){
                Attendance atten= ad.getByKey(classx.getClass_id(), schedule_id, listClassUser.get(i).getUserId().getId());
                if (atten!=null){
                    data.add(atten);
                }else{
                    data.add(new Attendance(classx, listClassUser.get(i).getUserId(),schedule,"absent",""));
                }                
            }
            List<Schedule> listSchedule= scheduleDAO.getScheduleOfClass(schedule.getClass_id());
            request.setAttribute("listSchedule", listSchedule);
            session.setAttribute("data", data);            
        }
        request.getRequestDispatcher("attendancedetails.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
