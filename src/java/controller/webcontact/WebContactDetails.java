/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.webcontact;

import model.WebContact;
import dal.WebContactDAO;
import dal.settingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author User
 */
@WebServlet(name="WebContactDetails", urlPatterns={"/admin/webcontactdetails"})
public class WebContactDetails extends HttpServlet {
   
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
            out.println("<title>Servlet WebContactDetails</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WebContactDetails at " + request.getContextPath () + "</h1>");
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
        String id_raw=request.getParameter("contact_id");
        int id=0;
        if (id_raw != null) {
            id = Integer.parseInt(id_raw);
        }
        WebContactDAO c= new WebContactDAO();
        WebContact contact= c.getContactById(id);
        settingDAO sd= new settingDAO();
        request.setAttribute("contact", contact);
        ArrayList<Integer> categoryIds= sd.getCategoryIds();
//        ArrayList<Integer> categoryIds= new ArrayList<>();
//        categoryIds.add(1);
//        categoryIds.add(2);
//        categoryIds.add(3);        
        request.setAttribute("categoryIds", categoryIds);
        
        //ArrayList<Integer> supporterIds= sd.getSuppoterIds()
        ArrayList<Integer> supporterIds= new ArrayList<>();
        supporterIds.add(1);
        supporterIds.add(2);
        supporterIds.add(3);        
        request.setAttribute("supporterIds", supporterIds);
        
        request.getRequestDispatcher("webcontactdetails.jsp").forward(request, response);
        
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
//        String id_raw= request.getParameter("idNow");
//        int id;
//        if (id_raw != null) {
//            id = Integer.parseInt(id_raw);
//        }
        WebContactDAO c= new WebContactDAO();
        String contact_id_raw= request.getParameter("contact_id");
        String category_id_raw= request.getParameter("category_id");
        String supporter_id_raw= request.getParameter("supporter_id");
        int category_id=0, supporter_id=0, contact_id=0;
        if (category_id_raw!=null){
            category_id=Integer.parseInt(category_id_raw);
        }
        if (supporter_id_raw!=null){
            supporter_id=Integer.parseInt(supporter_id_raw);
        }
        if (contact_id_raw!=null){
            contact_id=Integer.parseInt(contact_id_raw);
        }
        String contactResponse= request.getParameter("response");        
        c.updateContact(contact_id, category_id, supporter_id, contactResponse);
        request.setAttribute("mess", "Update successfully web contact");
        request.getRequestDispatcher("webcontactdetails.jsp").forward(request, response);
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
