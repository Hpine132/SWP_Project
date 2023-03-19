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
public class SettingListByFilter extends HttpServlet {
   
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
            out.println("<title>Servlet SettingListFilterByStatus</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingListFilterByStatus at " + request.getContextPath () + "</h1>");
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
        int statusId =-1;
        int typeId = -1;
              
        String Status_raw = request.getParameter("Status");  
        if(!Status_raw.equals("")){           
         statusId=Integer.parseInt(Status_raw);
        }
        String typeId_raw = request.getParameter("typeId");  
        if(!Status_raw.equals("")){           
         typeId=Integer.parseInt(typeId_raw);
        }
        request.setAttribute("isSettingList", "true");
        request.setAttribute("typeId", typeId_raw);
        request.setAttribute("Status", Status_raw);
        settingDAO settingDAO = new settingDAO();
        List<Setting> listSettingByFilter = settingDAO.getSettingWithFilter(typeId, statusId);
        request.setAttribute("listSettingByFilter", listSettingByFilter);
        List<Setting> listTypeId = settingDAO.getTypeSetting();        
        request.setAttribute("listSettingType", listTypeId);
        request.getRequestDispatcher("settinglist.jsp").forward(request, response);
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
