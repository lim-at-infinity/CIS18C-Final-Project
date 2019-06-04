package studyroom;


class Student implements LSD {
    
    private Integer studentID;
    private String firstName;
    private String lastName;
    
    //Default Constructor
    Student() {
        this.studentID = 0;
        this.firstName = null;
        this.lastName = null;
    }
    
    //---- FirstName Set and Get ----
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    //----- Student ID Set and Get ----
    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }
    public int getStudentID() {
        return studentID;
    }
    
    //---- LastName Set and Get ----
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    
    @Override
    public void fromCSV (String CSV) {
        String[] kv = CSV.split(":");
        Integer key = Integer.parseInt(",");
        
        String[] arrOfStr = kv[1].split(",");
        
        this.studentID = key;
        this.firstName = arrOfStr[0];
        this.lastName = arrOfStr[1];
    }
    
    @Override
    public String toCSV() {
        return this.studentID + ":" + this.firstName + "," + this.lastName;
    }
    
    @Override
    public void display() {
        System.out.println("Student ID : " + studentID + "\nStudent First Name : " + firstName + "\n Student Last Name : " + lastName);
    }    
}
