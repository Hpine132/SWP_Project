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
public class SettingList extends HttpServlet {

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
        settingDAO settingDAO = new settingDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;

        request.setAttribute("isSettingList", "true");
        
        List<Setting> listSettingType = settingDAO.getTypeSetting();
        request.setAttribute("listSettingType", listSettingType);
        
        int totalSetting = settingDAO.getTotalSetting();

        int numberPageHome = (totalSetting % 5 == 0 ? (totalSetting / 5) : ((totalSetting / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        String sort = request.getParameter("sort");
        
        if (sort != null && sort.equalsIgnoreCase("ascId")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_id asc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descId")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_id desc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascTittle")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_title asc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descTittle")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_title desc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascType")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "type_id asc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descType")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "type_id desc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascValue")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_value asc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descValue")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_value desc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else {
            List<Setting> listSetting = settingDAO.getSettingWithPagging(page, pageSzie);
            request.setAttribute("listSetting", listSetting);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        }

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
        settingDAO settingDAO = new settingDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;

        request.setAttribute("isSettingList", "true");
        
        int totalSetting = settingDAO.getTotalSetting();

        int numberPageHome = (totalSetting % 5 == 0 ? (totalSetting / 5) : ((totalSetting / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        String sort = request.getParameter("sort");
        
        List<Setting> listSettingType = settingDAO.getTypeSetting();
        request.setAttribute("listSettingType", listSettingType);
        
        if (sort != null && sort.equalsIgnoreCase("ascId")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_id asc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descId")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_id desc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascTittle")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_title asc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descTittle")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_title desc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascType")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "type_id asc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descType")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "type_id desc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascValue")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_value asc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descValue")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingWithPaggingSort(page, pageSzie, "setting_value desc");
            request.setAttribute("listSetting", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else {
            List<Setting> listSetting = settingDAO.getSettingWithPagging(page, pageSzie);
            request.setAttribute("listSetting", listSetting);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        }
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
