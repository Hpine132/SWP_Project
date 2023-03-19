/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Schedule {
    private int schedule_id;
    private int class_id;
    private int slot_id;
    private int room_id;
    private Date training_date;
    private Time from_time;
    private Time to_time;
    private int status;

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    private String class_name;
    private String slot;
    private String room;

    public Schedule() {
    }

    public Schedule(int schedule_id, Date training_date, Time from_time, Time to_time, int status, String class_name, String slot, String room) {
        this.schedule_id = schedule_id;
        this.training_date = training_date;
        this.from_time = from_time;
        this.to_time = to_time;
        this.status = status;
        this.class_name = class_name;
        this.slot = slot;
        this.room = room;
    }
    
    public Schedule(int schedule_id, int clas_id, int slot_id, int room_id, Date training_date, Time from_time, Time to_time, int status) {
        this.schedule_id = schedule_id;
        this.class_id = clas_id;
        this.slot_id = slot_id;
        this.room_id = room_id;
        this.training_date = training_date;
        this.from_time = from_time;
        this.to_time = to_time;
        this.status = status;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getTraining_date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(training_date);
    }
    
    public Date getTraining_date1() {
        return training_date;
    }

    public void setTraining_date(Date training_date) {
        this.training_date = training_date;
    }

    public Time getFrom_time() {
        return from_time;
    }

    public void setFrom_time(Time from_time) {
        this.from_time = from_time;
    }

    public Time getTo_time() {
        return to_time;
    }

    public void setTo_time(Time to_time) {
        this.to_time = to_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
