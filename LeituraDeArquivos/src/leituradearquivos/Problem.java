/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.util.ArrayList;

/**
 *
 * @author aline
 */
public class Problem {

    Scheduling_Period scheduling_Period;
    Skill[] skill;
    Shift_Type[] shift_Type;
    Contract[] contract;
    Pattern[] pattern;
    Employee[] employee;
    Day_Off_Week_Cover[] day_Off_Week_Cover;
    Date_Specific_Cover[] date_Specific_Cover; //FALTA IMPLEMENTAR NA LEITURA E COLOCA-LA NO CONSTRUTOR
    Day_Off_Request[] day_Off_Request;
    Day_On_Request[] day_On_Request;
    Shift_Off_Request[] shift_Off_Request;
    Shift_On_Request[] shift_On_Request;
    ArrayList vetorScheduling_Period = new ArrayList<>();

    public Problem(Scheduling_Period scheduling_Period, Skill[] skill, Shift_Type[] shift_Type, Contract[] contract, Pattern[] pattern, Employee[] employee, Day_Off_Week_Cover[] day_Off_Week_Cover, Date_Specific_Cover[] date_Specific_Cover, Day_Off_Request[] day_Off_Request, Day_On_Request[] day_On_Request, Shift_Off_Request[] shift_Off_Request, Shift_On_Request[] shift_On_Request) {
        this.scheduling_Period = scheduling_Period;
        this.skill = skill;
        this.shift_Type = shift_Type;
        this.contract = contract;
        this.pattern = pattern;
        this.employee = employee;
        this.day_Off_Week_Cover = day_Off_Week_Cover;
        this.date_Specific_Cover = date_Specific_Cover;
        this.day_Off_Request = day_Off_Request;
        this.day_On_Request = day_On_Request;
        this.shift_Off_Request = shift_Off_Request;
        this.shift_On_Request = shift_On_Request;
    }

    public Scheduling_Period getScheduling_Period() {
        return scheduling_Period;
    }

    public void setScheduling_Period(Scheduling_Period scheduling_Period) {
        this.scheduling_Period = scheduling_Period;
    }

    public Skill[] getSkill() {
        return skill;
    }

    public void setSkill(Skill[] skill) {
        this.skill = skill;
    }

    public Shift_Type[] getShift_Type() {
        return shift_Type;
    }

    public void setShift_Type(Shift_Type[] shift_Type) {
        this.shift_Type = shift_Type;
    }

    public Contract[] getContract() {
        return contract;
    }

    public void setContract(Contract[] contract) {
        this.contract = contract;
    }

    public Pattern[] getPattern() {
        return pattern;
    }

    public void setPattern(Pattern[] pattern) {
        this.pattern = pattern;
    }

    public Employee[] getEmployee() {
        return employee;
    }

    public void setEmployee(Employee[] employee) {
        this.employee = employee;
    }

    public Day_Off_Week_Cover[] getDay_Off_Week_Cover() {
        return day_Off_Week_Cover;
    }

    public void setDay_Off_Week_Cover(Day_Off_Week_Cover[] day_Off_Week_Cover) {
        this.day_Off_Week_Cover = day_Off_Week_Cover;
    }

    public Date_Specific_Cover[] getDate_Specific_Cover() {
        return date_Specific_Cover;
    }

    public void setDate_Specific_Cover(Date_Specific_Cover[] date_Specific_Cover) {
        this.date_Specific_Cover = date_Specific_Cover;
    }

    public Day_Off_Request[] getDay_Off_Request() {
        return day_Off_Request;
    }

    public void setDay_Off_Request(Day_Off_Request[] day_Off_Request) {
        this.day_Off_Request = day_Off_Request;
    }

    public Day_On_Request[] getDay_On_Request() {
        return day_On_Request;
    }

    public void setDay_On_Request(Day_On_Request[] day_On_Request) {
        this.day_On_Request = day_On_Request;
    }

    public Shift_Off_Request[] getShift_Off_Request() {
        return shift_Off_Request;
    }

    public void setShift_Off_Request(Shift_Off_Request[] shift_Off_Request) {
        this.shift_Off_Request = shift_Off_Request;
    }

    public Shift_On_Request[] getShift_On_Request() {
        return shift_On_Request;
    }

    public void setShift_On_Request(Shift_On_Request[] shift_On_Request) {
        this.shift_On_Request = shift_On_Request;
    }
    
    public ArrayList getVetorScheduling_Period() {
        return vetorScheduling_Period;
    }

    public void setVetorScheduling_Period(ArrayList vetorScheduling_Period) {
        this.vetorScheduling_Period = vetorScheduling_Period;
    }
}
