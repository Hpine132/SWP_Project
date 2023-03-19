/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Class {
    private int class_id;
    private String class_code;
    private int combo_id;
    private User trainer_id;
    private Setting term_id;
    private String status;
    private String description;

    public Class() {
    }

    public int getClass_id() {
        return class_id;
    }

    public String getClass_code() {
        return class_code;
    }

    public int getCombo_id() {
        return combo_id;
    }

    public User getTrainer_id() {
        return trainer_id;
    }

    public Setting getTerm_id() {
        return term_id;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Class(int class_id, String class_code, int combo_id, User trainer_id, Setting term_id, String status, String description) {
        this.class_id = class_id;
        this.class_code = class_code;
        this.combo_id = combo_id;
        this.trainer_id = trainer_id;
        this.term_id = term_id;
        this.status = status;
        this.description = description;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public void setCombo_id(int combo_id) {
        this.combo_id = combo_id;
    }

    public void setTrainer_id(User trainer_id) {
        this.trainer_id = trainer_id;
    }

    public void setTerm_id(Setting term_id) {
        this.term_id = term_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
