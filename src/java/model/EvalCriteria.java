/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class EvalCriteria {
    private int criteria_id;
    private Assignment ass_id;
    private Milestone milestone_id;
    private String criteria_name;
    private int is_team_eval;
    private double eval_weight;
    private int max_loc;
    private int status;
    private String description;

    public EvalCriteria() {
    }

    public EvalCriteria(int criteria_id, Assignment ass_id, Milestone milestone_id, String criteria_name, int is_team_eval, double eval_weight, int max_loc, int status, String description) {
        this.criteria_id = criteria_id;
        this.ass_id = ass_id;
        this.milestone_id = milestone_id;
        this.criteria_name = criteria_name;
        this.is_team_eval = is_team_eval;
        this.eval_weight = eval_weight;
        this.max_loc = max_loc;
        this.status = status;
        this.description = description;
    }

    public int getCriteria_id() {
        return criteria_id;
    }

    public void setCriteria_id(int criteria_id) {
        this.criteria_id = criteria_id;
    }


    public String getCriteria_name() {
        return criteria_name;
    }

    public void setCriteria_name(String criteria_name) {
        this.criteria_name = criteria_name;
    }

    public int getIs_team_eval() {
        return is_team_eval;
    }

    public void setIs_team_eval(int is_team_eval) {
        this.is_team_eval = is_team_eval;
    }

    public double getEval_weight() {
        return eval_weight;
    }

    public void setEval_weight(double eval_weight) {
        this.eval_weight = eval_weight;
    }

    public int getMax_loc() {
        return max_loc;
    }

    public void setMax_loc(int max_loc) {
        this.max_loc = max_loc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Assignment getAss_id() {
        return ass_id;
    }

    public void setAss_id(Assignment ass_id) {
        this.ass_id = ass_id;
    }

    public Milestone getMilestone_id() {
        return milestone_id;
    }

    public void setMilestone_id(Milestone milestone_id) {
        this.milestone_id = milestone_id;
    }
    
    
}
