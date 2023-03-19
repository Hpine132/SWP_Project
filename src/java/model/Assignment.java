/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Assignment {
    private int assId;
    private Subject subjectId;
    private String tittle;
    private String assBody;
    private double eval_weight;
    private int isTeamWork;
    private int isOngoing;
    private int status;

    public Assignment() {
    }

    public Assignment(int assId, Subject subjectId, String tittle, String assBody, double eval_weight,int isTeamWork, int isOngoing, int status) {
        this.assId = assId;
        this.subjectId = subjectId;
        this.tittle = tittle;
        this.assBody = assBody;
        this.eval_weight = eval_weight;
        this.isTeamWork = isTeamWork;
        this.isOngoing = isOngoing;
        this.status = status;
    }

    public int getIsTeamWork() {
        return isTeamWork;
    }

    public void setIsTeamWork(int isTeamWork) {
        this.isTeamWork = isTeamWork;
    }

    public int getAssId() {
        return assId;
    }

    public void setAssId(int assId) {
        this.assId = assId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAssBody() {
        return assBody;
    }

    public void setAssBody(String assBody) {
        this.assBody = assBody;
    }

    public double getEval_weight() {
        return eval_weight;
    }

    public void setEval_weight(double eval_weight) {
        this.eval_weight = eval_weight;
    }

    public int getIsOngoing() {
        return isOngoing;
    }

    public void setIsOngoing(int isOngoing) {
        this.isOngoing = isOngoing;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
