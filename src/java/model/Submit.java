/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;


/**
 *
 * @author Admin
 */
public class Submit {
    private int submitId;
    private Class classId;
    private Team teamId;
    private User userId;
    private String sublitFileUrl;
    private Date submitTime;
    private int status;

    public Submit() {
    }

    public Submit(int submitId, Class classId, Team teamId, User userId, String sublitFileUrl, Date submitTime, int status) {
        this.submitId = submitId;
        this.classId = classId;
        this.teamId = teamId;
        this.userId = userId;
        this.sublitFileUrl = sublitFileUrl;
        this.submitTime = submitTime;
        this.status = status;
    }

    public int getSubmitId() {
        return submitId;
    }

    public void setSubmitId(int submitId) {
        this.submitId = submitId;
    }

    public Class getClassId() {
        return classId;
    }

    public void setClassId(Class classId) {
        this.classId = classId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getSublitFileUrl() {
        return sublitFileUrl;
    }

    public void setSublitFileUrl(String sublitFileUrl) {
        this.sublitFileUrl = sublitFileUrl;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
