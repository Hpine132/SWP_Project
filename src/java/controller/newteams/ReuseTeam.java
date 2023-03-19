/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.newteams;

import dal.SubmitDAO;
import dal.TeamDAO;
import dal.TeamMemberDAO;
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
import model.Milestone;
import model.Team;
import model.TeamMember;

/**
 *
 * @author Admin
 */
@WebServlet(name="ReuseTeam", urlPatterns={"/trainer/reuseteam"})
public class ReuseTeam extends HttpServlet {
   
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
            out.println("<title>Servlet ReuseTeam</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReuseTeam at " + request.getContextPath () + "</h1>");
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
        List<Team> listTeam = (List<Team>) session.getAttribute("ListTeamRe");
        String milestoneId_raw = (String) session.getAttribute("milestone");
        int milestoneId = Integer.parseInt(milestoneId_raw);
        SubmitDAO submitDAO = new SubmitDAO();
        submitDAO.insertTeamAndMilestone(listTeam, milestoneId);
        request.getRequestDispatcher("sussces.jsp").forward(request, response);
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
        
        String milesId_raw = request.getParameter("milestoneid");
        int milesId = Integer.parseInt(milesId_raw);
        SubmitDAO subDAO = new SubmitDAO();
        List<Team> listTeam = subDAO.getTeamByMilesStoneId(milesId);
        
        TeamMemberDAO teamMemberDAO = new TeamMemberDAO();
        List<TeamMember> listTeamMember = new ArrayList<>();       
        for(int i=0;i<listTeam.size();i++){
            List<TeamMember> listTeamMemberIngroup = teamMemberDAO.getTeamMemBerByTeamId(listTeam.get(i).getTeamId());
            listTeamMember.addAll(listTeamMemberIngroup);
        }
        List<Milestone>  listMilestoneSubmit = subDAO.getMilestoneSubmit();
        request.setAttribute("listMilestoneSubmit", listMilestoneSubmit);
        HttpSession session = request.getSession();
        request.setAttribute("selected", "reuse");
        request.setAttribute("chose", milesId);
        session.setAttribute("ListTeamRe", listTeam);
        session.setAttribute("listTeamMembeRe", listTeamMember);
        request.getRequestDispatcher("newteams.jsp").forward(request, response);
        
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
