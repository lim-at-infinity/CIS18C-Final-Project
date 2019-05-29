package studyroom;


public class Student {
    private final String name; //Student's name
    private final int ID; //Unique ID number for this student
    private static int nextUniqueID = 0; //Keep track of next available unique ID number
    
    
    Student(String theName) {
        name = theName;     //Constructor for Student objects;
        nextUniqueID++;     //provides a name for the student,
        ID = nextUniqueID;  //and assigns the student a unique ID number
    }
    
    public String getName() { //Accessor method for reading value of private
        return name;          //instance variable, name
    }
    
    public int getID() {  //Accessor method for reading value of ID
        return ID;
    }
    
}
