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
    private String name;
    private Integer studentID;
    private String email;
    
    // Default Constructor
    Student() {
        this.name = null;
        this.studentID = 0;
        this.email = null;
    }
    
    // ----- Name Set and Get -----
    public void setName(String name) {
       this.name = name; 
    }
    public String getName() {
        return name;
    }
    
    // ----- Student ID Set and Get -----
    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }
    public int getStudentID() {
        return studentID;
    }
    
    // ----- Email Set and Get -----\
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    
    @Override
    public void fromCSV (String CSV) {
        String[] kv = CSV.split(":");
        Integer key = Integer.parseInt(kv[0]);
        
        String[] arrOfStr = kv[1].split(",");
        
        this.studentID = key;
        this.name = arrOfStr[0];
        this.email = arrOfStr[1];
    }
    
    @Override
    public String toCSV() {
        return this.name + ":" + this.studentID + "," + this.email;
    }

    @Override
    public void display() {
        System.out.println("Student ID : " + studentID + "\nStudent Name : " + name + "\n Student Email : " + email);
    }
}
