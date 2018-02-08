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
public class Pattern {

    int id;
    int weight, numberOfShiftTypes;
    ArrayList<Etapa> etapas = new ArrayList<Etapa>();
//    Shift_Type shift_typeID;
    int shift_typeID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNumberOfShiftTypes() {
        return numberOfShiftTypes;
    }

    public void setNumberOfShiftTypes(int numberOfShiftTypes) {
        this.numberOfShiftTypes = numberOfShiftTypes;
    }

    public int getShift_typeID() {
        return shift_typeID;
    }

    public void setShift_typeID(int shift_typeID) {
        this.shift_typeID = shift_typeID;
    }

    public ArrayList<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(ArrayList<Etapa> etapas) {
        this.etapas = etapas;
    }
    
    

}
