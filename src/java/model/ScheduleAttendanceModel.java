/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author User
 */
public class ScheduleAttendanceModel {
    private String slot;
    private String training_date;
    private Time from_time;
    private Time to_time;
    private String room;
    private String attendance;
    private String comment;

    public ScheduleAttendanceModel(String slot, String training_date, Time from_time, Time to_time, String room, String attendance, String comment) {
        this.slot = slot;
        this.training_date = training_date;
        this.from_time = from_time;
        this.to_time = to_time;
        this.room = room;
        this.attendance = attendance;
        this.comment = comment;
    }

    public ScheduleAttendanceModel() {
    }

    public String getSlot() {
        return slot;
    }

    public String getTraining_date() {
        return training_date;
    }

    public Time getFrom_time() {
        return from_time;
    }

    public Time getTo_time() {
        return to_time;
    }

    public String getRoom() {
        return room;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getComment() {
        return comment;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setTraining_date(String training_date) {
        this.training_date = training_date;
    }

    public void setFrom_time(Time from_time) {
        this.from_time = from_time;
    }

    public void setTo_time(Time to_time) {
        this.to_time = to_time;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    

   
}
