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
public class Employee implements Comparable<Employee> {
    String id, name;
//    Contract contractID;
    int contractID;
    int numberOfSkills;
//    Skill[] employee_Skills;
    String[] employee_Skills;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }


    public int getNumberOfSkills() {
        return numberOfSkills;
    }

    public void setNumberOfSkills(int numberOfSkills) {
        this.numberOfSkills = numberOfSkills;
    }

    public String[] getEmployee_Skills() {
        return employee_Skills;
    }

    public void setEmployee_Skills(String[] employee_Skills) {
        this.employee_Skills = employee_Skills;
    }

    @Override
    public int compareTo(Employee e) {
        return this.getId().compareTo(e.getId());
    }


    
}
