/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

/**
 *
 * @author aline
 */
public class Shift_Type {
    String id, description, startTime, endTime;
    int numberOfRequiredSkills; 
//    String requiredSkill;
    Skill requiredSkill;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getNumberOfRequiredSkills() {
        return numberOfRequiredSkills;
    }

    public void setNumberOfRequiredSkills(int numberOfRequiredSkills) {
        this.numberOfRequiredSkills = numberOfRequiredSkills;
    }

    public Skill getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(Skill requiredSkill) {
        this.requiredSkill = requiredSkill;
    }



    
}
