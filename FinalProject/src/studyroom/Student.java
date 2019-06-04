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
    protected int studentID;
    
     // ----- ID Get and Set -----
    public void setName(String name) {
       this.name = name; 
    }
    public String getName() {
        return name;
    }
    
    // ----- Year Get and Set -----
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public int getStudentID() {
        return studentID;
    }
    
    @Override
    public void fromCSV (String CSV) {
        String[] kv = CSV.split(":");
        String key = kv[0];
        
        String[] arrOfStr = kv[1].split(",");
        
        this.name = key;
        this.studentID = Integer.parseInt(arrOfStr[0]);
    }
    
    @Override
    public String toCSV() {
        return this.name + ":" + this.studentID;
    }

    @Override
    public void display() {
        
    }

    void setFirstName(String registerStudentFirstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setLastName(String registerStudentLastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
