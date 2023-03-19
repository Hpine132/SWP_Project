/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class ClassUserAttendance {
    private ClassUser ClassUser;
    private Attendance Attendance;

    public ClassUserAttendance() {
    }

    public ClassUserAttendance(ClassUser ClassUser, Attendance Attendance) {
        this.ClassUser = ClassUser;
        this.Attendance = Attendance;
    }

    public ClassUser getClassUser() {
        return ClassUser;
    }

    public Attendance getAttendance() {
        return Attendance;
    }

    public void setClassUser(ClassUser ClassUser) {
        this.ClassUser = ClassUser;
    }

    public void setAttendance(Attendance Attendance) {
        this.Attendance = Attendance;
    }
    
    
}
