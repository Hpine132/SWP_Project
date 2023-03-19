/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class ClassSetting {
    private int setting_id;
    private Setting type_id;
    private String setting_title;
    private String setting_value;
    private String display_order;
    private Class class_model;
    private String status;
    private String description;

    public ClassSetting() {
    }

    public ClassSetting(int setting_id, Setting type_id, String setting_title, String setting_value, String display_order, Class class_model, String status, String description) {
        this.setting_id = setting_id;
        this.type_id = type_id;
        this.setting_title = setting_title;
        this.setting_value = setting_value;
        this.display_order = display_order;
        this.class_model = class_model;
        this.status = status;
        this.description = description;
    }

    public int getSetting_id() {
        return setting_id;
    }

    public Setting getType_id() {
        return type_id;
    }

    public String getSetting_title() {
        return setting_title;
    }

    public String getSetting_value() {
        return setting_value;
    }

    public String getDisplay_order() {
        return display_order;
    }

    public Class getClass_model() {
        return class_model;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setSetting_id(int setting_id) {
        this.setting_id = setting_id;
    }

    public void setType_id(Setting type_id) {
        this.type_id = type_id;
    }

    public void setSetting_title(String setting_title) {
        this.setting_title = setting_title;
    }

    public void setSetting_value(String setting_value) {
        this.setting_value = setting_value;
    }

    public void setDisplay_order(String display_order) {
        this.display_order = display_order;
    }

    public void setClass_model(Class class_model) {
        this.class_model = class_model;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
