/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Date;
import model.User;

/**
 *
 * @author Admin
 */
public class ClassUser {
    private Class classId;
    private User userId;
    private int status;
    private Date dropoutDate;
    private String ongoingEval;
    private String finalEval;
    private String topicEval;

    public ClassUser() {
    }

    public ClassUser(Class classId, User userId, int status, Date dropoutDate, String ongoingEval, String finalEval, String topicEval) {
        this.classId = classId;
        this.userId = userId;
        this.status = status;
        this.dropoutDate = dropoutDate;
        this.ongoingEval = ongoingEval;
        this.finalEval = finalEval;
        this.topicEval = topicEval;
    }

    public Class getClassId() {
        return classId;
    }

    public void setClassId(Class classId) {
        this.classId = classId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDropoutDate() {
        return dropoutDate;
    }

    public void setDropoutDate(Date dropoutDate) {
        this.dropoutDate = dropoutDate;
    }

    public String getOngoingEval() {
        return ongoingEval;
    }

    public void setOngoingEval(String ongoingEval) {
        this.ongoingEval = ongoingEval;
    }

    public String getFinalEval() {
        return finalEval;
    }

    public void setFinalEval(String finalEval) {
        this.finalEval = finalEval;
    }

    public String getTopicEval() {
        return topicEval;
    }

    public void setTopicEval(String topicEval) {
        this.topicEval = topicEval;
    }
    
}
