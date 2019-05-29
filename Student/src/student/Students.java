/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Briana
 */
public class Students {
    private String name;
    private Integer idNumber;
    //HashMap<String, Integer> studentList = new HashMap();
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the idNumber
     */
    public Integer getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }
    
    public void displayStudent(String name, Integer idNumber){
        System.out.println("Name: " + name + "Id Number: " + idNumber);
    }  
}
