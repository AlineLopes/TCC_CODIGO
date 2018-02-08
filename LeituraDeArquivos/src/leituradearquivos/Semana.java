/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.util.Date;

/**
 *
 * @author aline
 */
public class Semana<Integer,String > {
    public Integer number;
    public String write_out;
    public String date;

    public Semana(Integer number, String write_out, String date) {
        this.number = number;
        this.write_out = write_out;
        this.date = date;
    }
    
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getWrite_out() {
        return write_out;
    }

    public void setWrite_out(String write_out) {
        this.write_out = write_out;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
