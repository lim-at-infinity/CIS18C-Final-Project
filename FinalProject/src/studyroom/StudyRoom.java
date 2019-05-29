package studyroom;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudyRoom {
    
    public static void main(String[] args) {
        
        HashMap <String,Student> s = new HashMap();
        Queue <Room> r = new LinkedList<Room>();
        HashMap <String, Book> b = new HashMap();
        
        loadStudent(s);
        loadRoom(r);
        loadBooks(b);
        
        
        saveStudent(s); 
        saveRoom(r);
        saveBooks(b);
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
                    s.put(blank.getName(),blank);
                }
            } catch (IOException ex) {
                System.out.println("STUDENT Binary Files are NOT supported");
            }
        } catch (FileNotFoundException ex) {} 
    }
    
    // ===== Load Student Queue =====
    
    private static void loadRoom (Queue<Room> r) {
        File  databaseRooms = new File("databaseRooms.txt");
        FileReader read = null;
        
        // File Exceptions
        try {
            read = new FileReader(databaseRooms);
            BufferedReader br = new BufferedReader(read);
            
            String line = null;
            try {
                while((line = br.readLine()) != null) {
                    Room blank  = new Room();
                    blank.fromCSV(line);
                    r.add(blank);
                }
            } catch (IOException ex) {
                System.out.println("ROOMS Binary Files are NOT supported");
            }
        } catch (FileNotFoundException ex) {} 
    }
    
    private static void loadBooks (HashMap <String,Book> b) {
        File  databaseBooks = new File("databaseBooks.txt");
        FileReader read = null;
        
        // File Exceptions
        try {
            read = new FileReader(databaseBooks);
            BufferedReader br = new BufferedReader(read);
            
            String line = null;
            try {
                while((line = br.readLine()) != null) {
                    Book blank  = new Book();
                    blank.fromCSV(line);
                    b.put(blank.getTitle(),blank);
                }
            } catch (IOException ex) {
                System.out.println("BOOKS Binary Files are NOT supported");
            }
        } catch (FileNotFoundException ex) {} 
    }
    
    
    // ===== Save Student Database (HashMap) =====
    
    private static void saveStudent(HashMap <String,Student> s) {       // Saves HashMaps
        // ===== FILE CREATION =====
        FileReader read = null;
        File databaseStudent = new File("databaseStudent.txt");
        
        // ===== FILE SAVE FOR STUDENT DATABASE ===== 
        try {
            read = new FileReader(databaseStudent);
            try {
                System.out.println("Saving to databaseStudent.txt file\n");       // Tells user the program is saving the Student Database
                FileWriter writer = null;                                           // Creates new File Writer
                writer = new FileWriter("databaseStudent.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<String> it = s.keySet().iterator(); it.hasNext();) {
                    String curr = it.next();
                    out.write(s.get(curr).toCSV());                                 // Each iteration of student is being saved
                }
                out.close();                                                        // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- STUDENT FILE ERROR --- \n");
            }
        } catch (FileNotFoundException ex) {                                        // IF the file doesn't exist...
            try {
                System.out.println("Created new file called databaseStudent.txt\n");  // Tells user the program has NOW created the new Student Database
                FileWriter writer = null;                                           // Creates new File Writer
                writer = new FileWriter("databaseStudent.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<String> it = s.keySet().iterator(); it.hasNext();) {
                    String curr = it.next();
                    out.write(s.get(curr).toCSV());                                 // Each iteration of student is being saved
                }
                out.close();                                                        // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- STUDENT FILE ERROR --- \n");
            }
        }
    }
    
    
    // ===== Save Room Database (Queue) =====
    
    private static void saveRoom(Queue <Room> r){       // Saves Queues
        // ===== FILE CREATION =====
        FileReader read = null;
        File databaseRooms = new File("databaseRooms.txt");
        
        // ===== FILE SAVE FOR ROOMS DATABASE =====
        try {
            read = new FileReader(databaseRooms);
            try {
                System.out.println("Saving to databaseRooms.txt file\n");         // Tells user the program is saving the Room Database
                FileWriter writer = null;                                           // Creates new File Writer
                writer = new FileWriter("databaseRooms.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (int i = 0; i < r.toArray().length; i++) {
                    out.write(r.toArray()[i].toString());                           // Each iteration of Room is being saved
                }
                out.close();                                                        // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- ROOMS FILE ERROR --- \n");
            }
        } catch (FileNotFoundException ex) {                                        // IF the file doesn't exist...
            try {
                System.out.println("Created new file called databaseRooms.txt\n");  // Tells user the program has NOW created the new Student Database
                FileWriter writer = null;                                           // Creates new File Writer
                writer = new FileWriter("databaseRooms.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (int i = 0; i < r.toArray().length; i++) {
                    out.write(r.toArray()[i].toString());                           // Each iteration of Room is being saved
                }
                out.close();                                                        // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- ROOMS FILE ERROR --- \n");
            }
        }
    }
    
    // ===== Save Books Database (HashMap) =====
    
    private static void saveBooks(HashMap <String,Book> b) {       // Saves HashMaps
        // ===== FILE CREATION =====
        FileReader read = null;
        File databaseBooks = new File("databaseBooks.txt");
        
        // ===== FILE SAVE FOR BOOKS DATABASE ===== 
        try {
            read = new FileReader(databaseBooks);
            try {
                System.out.println("Saving to databaseBooks.txt file\n");       // Tells user the program is saving the Student Database
                FileWriter writer = null;                                           // Creates new File Writer
                writer = new FileWriter("databaseBooks.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<String> it = b.keySet().iterator(); it.hasNext();) {
                    String curr = it.next();
                    out.write(b.get(curr).toCSV());                                 // Each iteration of student is being saved
                }
                out.close();                                                        // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- BOOKS FILE ERROR --- \n");
            }
        } catch (FileNotFoundException ex) {                                        // IF the file doesn't exist...
            try {
                System.out.println("Created new file called databaseBooks.txt\n");  // Tells user the program has NOW created the new Student Database
                FileWriter writer = null;                                           // Creates new File Writer
                writer = new FileWriter("databaseBooks.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<String> it = b.keySet().iterator(); it.hasNext();) {
                    String curr = it.next();
                    out.write(b.get(curr).toCSV());                                 // Each iteration of student is being saved
                }
                out.close();                                                        // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- BOOKS FILE ERROR --- \n");
            }
        }
    }
}
