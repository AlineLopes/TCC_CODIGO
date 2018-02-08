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
public class Shift_On_Request {
//    Employee employeeID;
    String employeeID;
    String date;
//    Shift_Type shift_TypeID;
    String shift_TypeID;
    int weight;    

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getShift_TypeID() {
        return shift_TypeID;
    }

    public void setShift_TypeID(String shift_TypeID) {
        this.shift_TypeID = shift_TypeID;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
