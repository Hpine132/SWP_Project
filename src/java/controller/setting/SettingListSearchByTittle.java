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
public class SettingListSearchByTittle extends HttpServlet {

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
            out.println("<title>Servlet SettingListSearchByTittle</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingListSearchByTittle at " + request.getContextPath() + "</h1>");
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
        String searchTittle = request.getParameter("searchTittle");
        request.setAttribute("searchTittle", searchTittle);
        settingDAO settingDAO = new settingDAO();
        int page = 1;
        request.setAttribute("page", page);
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        final int pageSzie = 5;
        List<Setting> listSettingType = settingDAO.getTypeSetting();
        request.setAttribute("listSettingType", listSettingType);
        int totalSetting = settingDAO.getTotalSettingListByTittle(searchTittle);
        int numberPageHome = (totalSetting % 5 == 0 ? (totalSetting / 5) : ((totalSetting / 5) + 1));
        request.setAttribute("numberPageHome", numberPageHome);

        request.setAttribute("isSettingList", "true");
        
        String sort = request.getParameter("sort");

        if (sort != null && sort.equalsIgnoreCase("ascId")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingListByTittleSort(page, pageSzie, searchTittle, "setting_id asc");
            request.setAttribute("settingtistsearchbytittle", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descId")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingListByTittleSort(page, pageSzie, searchTittle, "setting_id desc");
            request.setAttribute("settingtistsearchbytittle", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascTittle")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingListByTittleSort(page, pageSzie, searchTittle, "setting_title asc");
            request.setAttribute("settingtistsearchbytittle", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descTittle")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingListByTittleSort(page, pageSzie, searchTittle, "setting_title desc");
            request.setAttribute("settingtistsearchbytittle", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascType")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingListByTittleSort(page, pageSzie, searchTittle, "type_id asc");
            request.setAttribute("settingtistsearchbytittle", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descType")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingListByTittleSort(page, pageSzie, searchTittle, "type_id desc");
            request.setAttribute("settingtistsearchbytittle", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("ascValue")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingListByTittleSort(page, pageSzie, searchTittle, "setting_value asc");
            request.setAttribute("settingtistsearchbytittle", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else if (sort != null && sort.equalsIgnoreCase("descValue")) {
            List<Setting> listSettingSortByID = settingDAO.getSettingListByTittleSort(page, pageSzie, searchTittle, "setting_value desc");
            request.setAttribute("settingtistsearchbytittle", listSettingSortByID);
            request.setAttribute("sort", sort);
            request.getRequestDispatcher("settinglist.jsp").forward(request, response);
        } else {
            List<Setting> list = settingDAO.getSettingListByTittle(page, pageSzie, searchTittle);
            request.setAttribute("settingtistsearchbytittle", list);
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
