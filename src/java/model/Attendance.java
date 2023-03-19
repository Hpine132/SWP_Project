/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Attendance {
    private Class class_id;
    private User trainee_id;
    private Schedule schedule_id;
    private String status;
    private String comment;

    public Attendance() {
    }

    public Attendance(Class class_id, User trainee_id, Schedule schedule_id, String status, String comment) {
        this.class_id = class_id;
        this.trainee_id = trainee_id;
        this.schedule_id = schedule_id;
        this.status = status;
        this.comment = comment;
    }

    public Class getClass_id() {
        return class_id;
    }

    public User getTrainee_id() {
        return trainee_id;
    }

    public Schedule getSchedule_id() {
        return schedule_id;
    }

    public String getStatus() {
        return status;
    }

    public String getComment() {
        return comment;
    }

    public void setClass_id(Class class_id) {
        this.class_id = class_id;
    }

    public void setTrainee_id(User trainee_id) {
        this.trainee_id = trainee_id;
    }

    public void setSchedule_id(Schedule schedule_id) {
        this.schedule_id = schedule_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
