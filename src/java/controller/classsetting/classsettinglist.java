/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.classsetting;

import model.ClassSetting;
import model.Setting;
import dal.ClassSettingDAO;
import dal.settingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author User
 */
@WebServlet(name = "classsettinglist", urlPatterns = {"/admin/classsettinglist"})
public class classsettinglist extends HttpServlet {

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
            out.println("<title>Servlet classsettinglist</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet classsettinglist at " + request.getContextPath() + "</h1>");
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
        ClassSettingDAO c = new ClassSettingDAO();
        int page = 1;
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
        }
        List<ClassSetting> classsetting = null;
        String searchBy = request.getParameter("searchBy");
        String searchValue = request.getParameter("searchValue");
        String filterBy = request.getParameter("filterBy");
        String filterValue = request.getParameter("filterValue");
        int filter = 0;
        if (filterBy != null && filterBy.equals("type")) {
            filter = Integer.parseInt(filterValue);
        }
        String sortBy = request.getParameter("sortBy");
        String sortValue = request.getParameter("sortValue");
        int pageMax = 1;
        if (filterBy != null && !filterBy.equals("")) {
            if (filterBy.equals("type")) {
                pageMax = c.countFilterType(page, searchBy, searchValue, filter);
                classsetting = c.getClassSettingFilterByType(page, searchBy, searchValue, sortBy, sortValue, filter);
            }
            if (filterBy.equals("status")) {
                pageMax = c.countFilterStatus(page, searchBy, searchValue, filterValue);
                classsetting = c.getClassSettingFilterByStatus(page, searchBy, searchValue, sortBy, sortValue, filterValue);
            }
        } else {
            if (searchBy != null && !searchBy.equals("")) {
                pageMax = c.countSearch(searchBy, searchValue);
                if (searchBy.equals("title")) {
                    classsetting = c.getClassSettingsByTitle(page, searchValue, sortBy, sortValue);
                } else {
                    classsetting = c.getClassSettingsByValue(page, searchValue, sortBy, sortValue);
                }
            } else {
                pageMax = c.count();
                classsetting = c.getClassSettings(page, sortBy, sortValue);
            }
        }
        int sortById = 0;
        int sortValueId = 0;
        if (sortBy != null && sortValue != null) {
            switch (sortBy) {
                case "type":
                    sortById = 1;
                    break;
                case "title":
                    sortById = 2;
                    break;
                case "value":
                    sortById = 3;
                    break;
                case "displayorder":
                    sortById = 4;
                    break;
                case "status":
                    sortById = 5;
                    break;
            }
            switch (sortValue) {
                case "asc":
                    sortValueId = 1;
                    break;
                case "desc":
                    sortValueId = 2;
                    break;
            }
        }
        settingDAO sd = new settingDAO();
        List<Setting> settingtype = null;
        settingtype = sd.getSettingByTypeId(3);
        request.setAttribute("sortById",sortById);        
        request.setAttribute("sortValueId",sortValueId);
        request.setAttribute("sortBy", sortBy);
        request.setAttribute("sortValue", sortValue);
        request.setAttribute("typeSetting", settingtype);
        request.setAttribute("searchBy", searchBy);
        request.setAttribute("searchValue", searchValue);
        request.setAttribute("filterBy", filterBy);
        request.setAttribute("filterValue", filterValue);
        request.setAttribute("page", page);
        request.setAttribute("pageMax", pageMax);
        request.setAttribute("list", classsetting);
        request.getRequestDispatcher("classsettinglist.jsp").forward(request, response);
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
