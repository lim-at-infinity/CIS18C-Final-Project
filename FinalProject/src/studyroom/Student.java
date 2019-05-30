/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyroom;

/**
 *
 * @author jteet
 */
class Student implements LSD {
    protected String name;
    protected Integer studentID;
    
    // ----- ID Get and Set -----
    public void setName(String name) {
       this.name = name; 
    }
    public String getName() {
        return name;
    }
    
    // ----- Year Get and Set -----
    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }
    public int getStudentID() {
        return studentID;
    }
    
    @Override
    public void fromCSV (String CSV) {
        String[] kv = CSV.split(":");
        Integer key = Integer.parseInt(kv[0]);
        
        String[] arrOfStr = kv[1].split(",");
        
        this.studentID = key;
        this.name = arrOfStr[0];
    }
    
    @Override
    public String toCSV() {
        return this.name + ":" + this.studentID;
    }

    @Override
    public void display() {
        System.out.println("Student ID : " + studentID + "\nStudent Name : " + name);
    }
}
