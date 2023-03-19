/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class ListTeam {
    private List<ClassUser> TeamList;
    public ListTeam(List<ClassUser> TeamList) {
        this.TeamList = TeamList;
    }
 

    public List<ClassUser> getTeamList() {
        return TeamList;
    }
  

    public void setTeamList(List<ClassUser> TeamList) {
        this.TeamList = TeamList;
    }
  

}
