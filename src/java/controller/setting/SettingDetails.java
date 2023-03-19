/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.setting;

import dal.settingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Setting;

/**
 *
 * @author Admin
 */
public class SettingDetails extends HttpServlet {
   
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
            out.println("<title>Servlet SettingDetails</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingDetails at " + request.getContextPath () + "</h1>");
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
        String idSetting_raw = request.getParameter("id");
        int id = Integer.parseInt(idSetting_raw);
        settingDAO settingDAO = new settingDAO();
        Setting settingById = settingDAO.getSettingById(id);
        List<Setting> listSettingType = settingDAO.getTypeSetting();
        request.setAttribute("settingById", settingById);
        request.setAttribute("isSettingList", "true");
        request.setAttribute("listSettingType", listSettingType);
        request.getRequestDispatcher("settingdetails.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        String typeid = request.getParameter("typeId");
        String settingTittle = request.getParameter("settingtittle");
        String settingvalue = request.getParameter("settingvalue");
        String display_order = request.getParameter("display_order");
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        settingDAO settingDAO = new settingDAO();
        settingDAO.updateSetting(id,settingTittle,settingvalue,display_order,status,description);
        request.setAttribute("isSettingList", "true");
        request.setAttribute("sussces", "1");
        request.getRequestDispatcher("/admin/settinglist").forward(request, response);       
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
