/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class TeamMember {
    private Team teamId;
    private User userId;
    private int isLeadder;
    private int isActive;

    public TeamMember() {
    }

    public TeamMember(Team teamId, User userId, int isLeadder, int isActive) {
        this.teamId = teamId;
        this.userId = userId;
        this.isLeadder = isLeadder;
        this.isActive = isActive;
    }

    public Team getTeamId() {
        return teamId;
    }

    public User getUserId() {
        return userId;
    }

    public int getIsLeadder() {
        return isLeadder;
    }

    public int getIsActive() {
        return isActive;
    }
    
    
}
