/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.newteams;

import dal.ClassDAO;
import dal.NewTeamsDAO;
import dal.SubmitDAO;
import dal.TeamDAO;
import dal.TeamMemberDAO;
import dal.milestoneDAO;
import dal.userDAO;
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
import java.util.Random;
import model.ClassUser;
import model.ListTeam;
import model.Milestone;
import model.Team;
import model.TeamMember;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "TeamsRandom", urlPatterns = {"/trainer/teamsrandom"})
public class TeamsRandom extends HttpServlet {

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
            out.println("<title>Servlet TeamsRandom</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeamsRandom at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        NewTeamsDAO newTeamDAO = new NewTeamsDAO();
        String milestoneId_raw = (String) session.getAttribute("milestone");
        int milestoneId = Integer.parseInt(milestoneId_raw);
        
        String classId_raw = (String) session.getAttribute("classId");
        int classId = Integer.parseInt(classId_raw);
        List<ClassUser> classUserList = newTeamDAO.getAllClassUserByClassId(classId);
        request.setAttribute("numberstudentsofcalss", classUserList.size());
        String save = request.getParameter("save");
        if (save == null || save.equals("")) {
            request.getRequestDispatcher("newteams.jsp").forward(request, response);
        } else {          
            List<TeamMember> listTeammember = (List<TeamMember>) session.getAttribute("listTeamMember");
            List<Team> listTeam = (List<Team>) session.getAttribute("ListTeam");
            TeamDAO teamDAO = new TeamDAO();
            teamDAO.UpdateTeamInDatabase(listTeam);
            List<Team> listTeamWithId = teamDAO.getListTeamHaveNewId(listTeam.size());
            
            
            SubmitDAO submitDAO = new SubmitDAO();
            submitDAO.insertTeamAndMilestone(listTeamWithId, milestoneId);
            
            
            int groups = Integer.parseInt(request.getParameter("groups"));
            int teamSize = (int) Math.ceil((double) classUserList.size() / groups);
            List<TeamMember> listMemberForAddToDatabse = new ArrayList<>();
            int remain = classUserList.size() % groups;

            for (int i = 0; i < listTeammember.size(); i++) {
                int team_id = 0;
                if (i < (remain * teamSize)) {
                    team_id = (int) (i / teamSize);
                } else {
                    team_id = remain + (int) (i - remain * teamSize) / (int) (listTeammember.size() / groups);
                }

                TeamMember tm = new TeamMember(listTeamWithId.get(team_id), listTeammember.get(i).getUserId(), listTeammember.get(i).getIsLeadder(), listTeammember.get(i).getIsActive());
                listMemberForAddToDatabse.add(tm);
            }

            session.removeAttribute("listTeamMember");
            session.removeAttribute("ListTeam");
            TeamMemberDAO teamMemberDAO = new TeamMemberDAO();
            teamMemberDAO.UpdateTeamInDatabase(listMemberForAddToDatabse);
            request.getRequestDispatcher("sussces.jsp").forward(request, response);
        }
    }

    protected List<ListTeam> randomTeam(List<ClassUser> list, int NumberOfTeam) {
        //double teamSize_raw= (double)list.size()/NumberOfTeam;
        List<ListTeam> result = new ArrayList<>();
//        int teamSize = (int) Math.ceil((double) list.size() / NumberOfTeam);
        int teamAverage = (int) list.size() / NumberOfTeam;
        int remain = list.size() - teamAverage * NumberOfTeam;
        //random "remain" team have (teamAverage+1) members
        for (int i = 1; i <= remain; i++) {
            List<ClassUser> TeamMember = new ArrayList<>();
            for (int j = 1; j <= teamAverage + 1; j++) {
                // Random a number from 0-> (list.size() -1)
                double randomDouble = Math.random();
                randomDouble = randomDouble * list.size();
                int randomInt = (int) randomDouble;
                //Add member to team
                TeamMember.add(list.get(randomInt));
                //Remove member from list user in class
                list.remove(randomInt);
            }
            result.add(new ListTeam(TeamMember));
        }

        //random "n-remain" team have teamAverage members
        for (int i = 1; i <= NumberOfTeam - remain; i++) {
            List<ClassUser> TeamMember = new ArrayList<>();
            for (int j = 1; j <= teamAverage; j++) {
                // Random a number from 0-> (list.size() -1)
                double randomDouble = Math.random();
                randomDouble = randomDouble * list.size();
                int randomInt = (int) randomDouble;
                //Add member to team
                TeamMember.add(list.get(randomInt));
                //Remove member from list user in class
                list.remove(randomInt);
            }
            result.add(new ListTeam(TeamMember));
        }

        return result;
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
        HttpSession session = request.getSession();
        String numberGroup_raw = request.getParameter("numbergroup");
        int numberGroup = Integer.parseInt(numberGroup_raw);
        NewTeamsDAO newTeamDAO = new NewTeamsDAO();
        
        String classId_raw = (String) session.getAttribute("classId");
        int classId = Integer.parseInt(classId_raw);
        
        String milestoneId_raw = (String) session.getAttribute("milestone");
        int milestoneId = Integer.parseInt(milestoneId_raw);
        
        milestoneDAO milestoneDAO = new milestoneDAO();
        Milestone milestone = milestoneDAO.getMilestoneById(milestoneId);
        //import classDAO
        ClassDAO classDAO = new ClassDAO();

        List<ClassUser> classUserList = newTeamDAO.getAllClassUserByClassId(classId);
        int numberStudent = classUserList.size();
        request.setAttribute("numberstudentsofcalss", numberStudent);
        request.setAttribute("numbergroup", numberGroup);
        TeamsRandom x = new TeamsRandom();
        List<ListTeam> result = x.randomTeam(classUserList, numberGroup);
        List<Team> ListTeam = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            model.Class c = classDAO.getClassById(classId);
            if (result.get(i).getTeamList() != null) {
                Team team = new Team(i + 1, c, "G" + (i + 1), milestone.getTitle(), 1, "abcd");
                ListTeam.add(team);
            }
        }

        userDAO userDAO = new userDAO();
        Random rand = new Random();
        List<TeamMember> listTeamMember = new ArrayList<>();
        for (int i = 0; i < ListTeam.size(); i++) {
            int isLeader = rand.nextInt(result.get(i).getTeamList().size());
            for (int j = 0; j < result.get(i).getTeamList().size(); j++) {
                Team t = ListTeam.get(i);
                User u = userDAO.getUserById(result.get(i).getTeamList().get(j).getUserId().getId());
                if (isLeader == j) {
                    TeamMember tm = new TeamMember(t, u, 1, 1);
                    listTeamMember.add(tm);
                } else {
                    TeamMember tm = new TeamMember(t, u, 0, 1);
                    listTeamMember.add(tm);
                }
            }
        }
        SubmitDAO subDAO = new SubmitDAO();
        List<Milestone> listMilestoneSubmit = subDAO.getMilestoneSubmit();
        request.setAttribute("listMilestoneSubmit", listMilestoneSubmit);
       
        session.setAttribute("Assignment 2", "topicname");
        session.setAttribute("listTeamMember", listTeamMember);
        session.setAttribute("ListTeam", ListTeam);
        request.getRequestDispatcher("newteams.jsp").forward(request, response);

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
