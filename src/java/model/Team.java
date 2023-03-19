/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Team implements Comparable<Team> {

    private int teamId;
    private Class classId;
    private String teamCode;
    private String topicName;
    private int status;
    private String Description;

    public Team() {
    }

    public Team(int teamId, Class classId, String teamCode, String topicName, int status, String Description) {
        this.teamId = teamId;
        this.classId = classId;
        this.teamCode = teamCode;
        this.topicName = topicName;
        this.status = status;
        this.Description = Description;
    }

    public Team(Class classId, String teamCode, String topicName, int status, String Description) {
        this.classId = classId;
        this.teamCode = teamCode;
        this.topicName = topicName;
        this.status = status;
        this.Description = Description;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Class getClassId() {
        return classId;
    }

    public void setClassId(Class classId) {
        this.classId = classId;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public int compareTo(Team o) {
        if (this.teamId == o.teamId) {
            return 0;
        } else if (this.teamId == o.teamId) {
            return 1;
        } else {
            return -1;
        }
    }

}
