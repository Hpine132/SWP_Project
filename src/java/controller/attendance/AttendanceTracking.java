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
import model.AttendanceTrackingModel;
import model.ClassUser;
import model.Schedule;
import model.User;


/**
 *
 * @author User
 */
@WebServlet(name="AttendanceTracking", urlPatterns={"/admin/attendancetracking"})
public class AttendanceTracking extends HttpServlet {
   
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
            out.println("<title>Servlet AttendanceTracking</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendanceTracking at " + request.getContextPath () + "</h1>");
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
        List<model.Class> listClass= classDAO.getClassByTrainerId(user.getId());
        request.setAttribute("listClass", listClass);
        
        int class_id=0;
        String class_id_raw= request.getParameter("class_id");
        if (class_id_raw!=null){
            class_id= Integer.parseInt(class_id_raw);            
            List<ClassUser> classUser= cud.getClassUserByClassId(class_id);
            List<Schedule> listSchedule= scheduleDAO.getScheduleOfClass(class_id);
            List<AttendanceTrackingModel> listt= new ArrayList<>();
            for (int i=0; i<classUser.size(); i++){
                List<Attendance> la= new ArrayList<>();
                for (int j=0; j< listSchedule.size(); j++){
                    Attendance temp= ad.getByKey(class_id, listSchedule.get(j).getSchedule_id(), classUser.get(i).getUserId().getId());
                    la.add(temp);
                }
                listt.add(new AttendanceTrackingModel(classUser.get(i).getUserId(),la));
            }
            request.setAttribute("listSchedule", listSchedule);
            request.setAttribute("data", listt);            
        }        
        request.getRequestDispatcher("attendancetracking.jsp").forward(request, response);
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
        processRequest(request, response);
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
