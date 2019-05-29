package studyroom;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;



public class StudyRoom {
    
    public static void main(String[] args) {
        
        HashMap <String,Student> s = new HashMap();
        Queue <Room> r = new LinkedList<Room>();
        
        loadStudent(s);
        
        Student n1 = new Student();
        n1.setID("123ABC");
        s.put(n1.getID(), n1);
        
        Student n2 = new Student();
        n2.setID("1234ABCD");
        n2.setTitle("Joe Rogers");
        n2.setArtist("Mark Ruffalo");
        n2.setGenre("Avengers");
        n2.setYear(2019);
        n2.setPrice(0.0);
        s.put(n2.getID(), n2);
        
        saveStudent(s);
        
        
         
        
    }
    
    // ===== Load Student HashMap =====
    
    private static void loadStudent (HashMap <String,Student> s) {
        File  databaseStudent = new File("databaseStudent.txt");
        FileReader read = null;
        
        // File Exceptions
        try {
            read = new FileReader(databaseStudent);
            BufferedReader br = new BufferedReader(read);
            
            String line = null;
            try {
                while((line = br.readLine()) != null) {
                    Student blank  = new Student();
                    blank.fromCSV(line);
                    s.put(blank.getID(),blank);
                }
            } catch (IOException ex) {
                System.out.println("Binary Files are NOT supported");
            }
        } catch (FileNotFoundException ex) {}
        
    }
    
    
    // ===== Save Student Database =====
    
    private static void saveStudent(HashMap <String,Student> s) {
        // ===== FILE CREATION =====
        FileReader read = null;
        File databaseStudent = new File("databaseStudent.txt");
        
        // ===== FILE SAVE FOR STUDENT DATABASE ===== 
        try {
            read = new FileReader(databaseStudent);
            try {
                System.out.println("\nSaving to databaseStudent.txt file\n");   // Tells user the program is saving the Student Database
                FileWriter writer = null;                                       // Creates new File Writer
                writer = new FileWriter("databaseStudent.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<String> it = s.keySet().iterator(); it.hasNext();) {
                    String curr = it.next();
                    out.write(s.get(curr).toCSV());                             // Each iteration of student is being saved
                }
                out.close();                                                    // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- FILE ERROR --- \n");
            }
        } catch (FileNotFoundException ex) {                                    // IF the file doesn't exist...
            try {
                System.out.println("Created new file called databaseStudent.txt"); // Tells user the program has NOW created the new Student Database
                FileWriter writer = null;                                       // Creates new File Writer
                writer = new FileWriter("databaseStudent.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<String> it = s.keySet().iterator(); it.hasNext();) {
                    String curr = it.next();
                    out.write(s.get(curr).toCSV());                             // Each iteration of student is being saved
                }
                out.close();                                                    // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- FILE ERROR --- \n");
            }
        }
    }
    
    
    // ===== Save Student Database =====
    
    private static void saveRoom(Queue <Room> r){
        // ===== FILE CREATION =====
        FileReader read = null;
        File databaseRooms = new File("databaseRooms.txt");
        
        // ===== FILE SAVE FOR ROOMS DATABASE =====
        try {
            read = new FileReader(databaseRooms);
            try {
                System.out.println("\nSaving to databaseRooms.txt file\n");     // Tells user the program is saving the Room Database
                FileWriter writer = null;                                       // Creates new File Writer
                writer = new FileWriter("databaseRooms.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (int i = 0; i < r.toArray().length; i++) {
                    out.write(r.toArray()[i].toString());                       // Each iteration of Room is being saved
                }
                out.close();                                                    // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- FILE ERROR --- \n");
            }
        } catch (FileNotFoundException ex) {                                    // IF the file doesn't exist...
            try {
                System.out.println("Created new file called databaseStudent.txt"); // Tells user the program has NOW created the new Student Database
                FileWriter writer = null;                                       // Creates new File Writer
                writer = new FileWriter("databaseStudent.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (int i = 0; i < r.toArray().length; i++) {
                    out.write(r.toArray()[i].toString());                       // Each iteration of Room is being saved
                }
                out.close();                                                    // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- FILE ERROR --- \n");
            }
        }
    }
}
