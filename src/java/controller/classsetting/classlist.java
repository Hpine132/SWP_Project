/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.classsetting;

import dal.ClassDAO;
import dal.settingDAO;
import model.Class;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Setting;
import model.User;

/**
 *
 * @author User
 */
@WebServlet(name = "classlist", urlPatterns = {"/admin/classlist"})
public class classlist extends HttpServlet {

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
            out.println("<title>Servlet classlist</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet classlist at " + request.getContextPath() + "</h1>");
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
        ClassDAO c = new ClassDAO();
        int page = 1;
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
        }
        List<Class> listClass = null;
        String searchBy = request.getParameter("searchBy");
        String searchValue = request.getParameter("searchValue");
        String filterBy = request.getParameter("filterBy");
        String filterValue = request.getParameter("filterValue");
        int filter = 0;
        if (filterBy != null && !filterBy.equals("status") && !filterBy.equals("")) {
            filter = Integer.parseInt(filterValue);
        }
        String sortBy = request.getParameter("sortBy");
        String sortValue = request.getParameter("sortValue");
        int pageMax = 1;

        if (filterBy != null && !filterBy.equals("")) {
            if (filterBy.equals("term")) {
                pageMax = c.countFilterTerm(page, searchBy, searchValue, filter);
                listClass = c.getClassFilterByTerm(page, searchBy, searchValue, sortBy, sortValue, filter);
            }
            if (filterBy.equals("trainer")) {
                pageMax = c.countFilterStatus(page, searchBy, searchValue, filterValue);
                listClass = c.getClassFilterByTrainer(page, searchBy, searchValue, sortBy, sortValue, filter);
            }
            if (filterBy.equals("status")) {
                pageMax = c.countFilterStatus(page, searchBy, searchValue, filterValue);
                listClass = c.getClassFilterByStatus(page, searchBy, searchValue, sortBy, sortValue, filterValue);
            }
        } else {
            if (searchValue != null && !searchValue.equals("")) {
                pageMax = c.countSearch(searchBy, searchValue);
                listClass = c.getClassByCode(page, searchValue, sortBy, sortValue);
            } else {
                pageMax = c.count();
                listClass = c.getClass(page, sortBy, sortValue);
            }
        }
        int sortById = 0;
        int sortValueId = 0;
        if (sortBy != null && sortValue != null) {
            switch (sortBy) {
                case "code":
                    sortById = 1;
                    break;
                case "term":
                    sortById = 2;
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
        List<Setting> terms = null;
        terms = sd.getSettingByTypeId(6);
        List<User> trainers= c.getUserByRole(11);
        request.setAttribute("trainers", trainers);
        request.setAttribute("sortById",sortById);        
        request.setAttribute("sortValueId",sortValueId);
        request.setAttribute("sortBy", sortBy);
        request.setAttribute("sortValue", sortValue);
        request.setAttribute("terms", terms);
        request.setAttribute("searchBy", searchBy);
        request.setAttribute("searchValue", searchValue);
        request.setAttribute("filterBy", filterBy);
        request.setAttribute("filterValue", filterValue);
        request.setAttribute("page", page);
        request.setAttribute("pageMax", pageMax);
        request.setAttribute("list", listClass);
        request.getRequestDispatcher("classlist.jsp").forward(request, response);
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
        ClassDAO c = new ClassDAO();
        List<Class> listClass = null;
        listClass = c.getClass(1, null, null);
        int pageMax = c.count();     
        request.setAttribute("page", 1);
        request.setAttribute("pageMax", pageMax);
        request.setAttribute("mess", "successfully");
        request.setAttribute("list", listClass);
        request.getRequestDispatcher("classlist.jsp").forward(request, response);
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
