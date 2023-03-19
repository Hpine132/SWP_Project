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
import java.util.List;
import model.Attendance;
import model.Schedule;
import model.User;

/**
 *
 * @author User
 */
@WebServlet(name="TakeAttendance", urlPatterns={"/admin/takeattendance"})
public class TakeAttendance extends HttpServlet {
   
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
            out.println("<title>Servlet TakeAttendance</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TakeAttendance at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        HttpSession session = request.getSession();
        AttendanceDAO ad= new AttendanceDAO();
        List<Attendance> data=(List<Attendance>) session.getAttribute("data");
        session.removeAttribute("data");
        for (int i=0; i<data.size();i++){
            data.get(i).setStatus(request.getParameter(data.get(i).getTrainee_id().getId()+""));
            data.get(i).setComment(request.getParameter(data.get(i).getTrainee_id().getId()+"comment"));
            if(ad.getByKey(data.get(i).getClass_id().getClass_id(), data.get(i).getSchedule_id().getSchedule_id(), data.get(i).getTrainee_id().getId())==null){
                ad.createAttendance(data.get(i));
            } else{
                ad.updateAttendance(data.get(i));
            }
        }
        User user= (User) session.getAttribute("account");
        ClassDAO classDAO= new ClassDAO();
        List<model.Class> listClass= classDAO.getClassByTrainerId(user.getId());
        request.setAttribute("listClass", listClass);        
        scheduleDAO scheduleDAO= new scheduleDAO();
        List<Schedule> listSchedule= scheduleDAO.getScheduleOfClass(data.get(0).getClass_id().getClass_id());
        request.setAttribute("listSchedule", listSchedule);
        request.getRequestDispatcher("attendancedetails.jsp").forward(request, response);
        
       
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
