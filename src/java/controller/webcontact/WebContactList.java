/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.webcontact;

import model.WebContact;
import dal.WebContactDAO;
import java.io.IOException;
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
@WebServlet(name = "WebContactList", urlPatterns = {"/admin/webcontactlist"})
public class WebContactList extends HttpServlet {

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
        WebContactDAO c = new WebContactDAO();
        int page = 1;
        String page_raw = request.getParameter("page");
        if (page_raw != null) {
            page = Integer.parseInt(page_raw);
            request.setAttribute("page", page);
        }
        
        request.setAttribute("page", page);
        String sort = request.getParameter("sortBy");
        String sortValue = request.getParameter("sortValue");
        String search = request.getParameter("searchBy");
        String searchValue_raw = request.getParameter("searchValue");
        int searchValue = 1;
        if (searchValue_raw != null) {
            searchValue = Integer.parseInt(searchValue_raw);
        }
        List<WebContact> contacts=null;
        int pageMax=1;
        if (search != null&&!search.equals("")) {
            if (search.equals("category_id")) {
                contacts = c.getContactByCategoryId(searchValue, sort, sortValue, page);
                pageMax=c.countByCategoryId(searchValue);
            } else{
                contacts = c.getContactBySupporterId(searchValue, sort, sortValue, page);
                pageMax=c.countBySupporterId(searchValue);
            }
        } else {
            contacts = c.getContact(sort, sortValue, page);
            pageMax=c.count();
        }
        request.setAttribute("pageMax", pageMax);
        request.setAttribute("searchBy",search);
        request.setAttribute("searchValue",searchValue);
        request.setAttribute("contacts", contacts);
        request.setAttribute("sortBy", sort);
        request.setAttribute("sortValue", sortValue);
        request.getRequestDispatcher("webContactList.jsp").forward(request, response);
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
