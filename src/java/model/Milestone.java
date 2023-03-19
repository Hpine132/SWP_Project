
package model;

import java.time.LocalDateTime;
import java.util.Date;

public class Milestone {
    private int mileId;
    private int assId;
    private int classId;
    private Date from_date;
    private Date to_date;
    private String title;
    private String assBody;
    private String description;
    private String status;

    public Milestone() {
    }

    public Milestone(int mileId, int assId, int classId, Date from_date, Date to_date, String title, String assBody, String description, String status) {
        this.mileId = mileId;
        this.assId = assId;
        this.classId = classId;
        this.from_date = from_date;
        this.to_date = to_date;
        this.title = title;
        this.assBody = assBody;
        this.description = description;
        this.status = status;
    }

    public int getMileId() {
        return mileId;
    }

    public void setMileId(int mileId) {
        this.mileId = mileId;
    }

    public int getAssId() {
        return assId;
    }

    public void setAssId(int assId) {
        this.assId = assId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssBody() {
        return assBody;
    }

    public void setAssBody(String assBody) {
        this.assBody = assBody;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
