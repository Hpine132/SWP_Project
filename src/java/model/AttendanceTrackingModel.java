/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author User
 */
public class AttendanceTrackingModel {

    private User trainee;
    private List<Attendance> list;
    private int absentPersent;

    public void setAbsentPersent(int absentPersent) {
        this.absentPersent = absentPersent;
    }

    public int getAbsentPersent() {
        return absentPersent;
    }

    public AttendanceTrackingModel(User trainee, List<Attendance> list) {
        this.trainee = trainee;
        this.list = list;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).getStatus().equals("absent")) {
                    count++;
                }
            }
        }
        if (list.size() == 0) {
            this.absentPersent = 0;
        } else {
            this.absentPersent = (int) (count * 100 / list.size());
        }
    }

    public AttendanceTrackingModel() {
    }

    public User getTrainee() {
        return trainee;
    }

    public List<Attendance> getList() {
        return list;
    }

    public void setTrainee(User trainee) {
        this.trainee = trainee;
    }

    public void setList(List<Attendance> list) {
        this.list = list;
    }

}
