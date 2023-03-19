/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Setting {

    private int settingId;
    private int typeId;
    private String settingTitle;
    private String settingValue;
    private String display_order;
    private String status;
    private String description;
    private String typeName;


    
    
    public Setting() {
    }

    public Setting(int settingId, int typeId, String settingTitle, String settingValue, String display_order, String status, String description) {
        this.settingId = settingId;
        this.typeId = typeId;
        this.settingTitle = settingTitle;
        this.settingValue = settingValue;
        this.display_order = display_order;
        this.status = status;
        this.description = description;
    }
    
        public Setting(int settingId, String typeName, String settingTitle, String settingValue, String display_order, String status, String description) {
        this.settingId = settingId;
        this.typeName = typeName;
        this.settingTitle = settingTitle;
        this.settingValue = settingValue;
        this.display_order = display_order;
        this.status = status;
        this.description = description;
    }
    
    
        public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getSettingTitle() {
        return settingTitle;
    }

    public void setSettingTitle(String settingTitle) {
        this.settingTitle = settingTitle;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    public String getDisplay_order() {
        return display_order;
    }

    public void setDisplay_order(String display_order) {
        this.display_order = display_order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
