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
        
        // Input and Collections Creation
        HashMap <Integer,Student> s = new HashMap();
        Queue <Room> r = new LinkedList<Room>();
        HashMap <String, Book> b = new HashMap();
        Scanner input = new Scanner(System.in);
        
        // Loading up Collections
        loadStudent(s);
        loadRoom(r);
        loadBooks(b);
        
        // Call Menu
        logInMenu(input,s,r,b);
    }
    
    
    
    public static void logInMenu(Scanner input, HashMap<Integer, Student> s, Queue<Room> r, HashMap<String,Book> b) {
        Integer userOption = null;
        do {
            logInMenuInfo();
            String userOptionString = input.nextLine();
            userOption = Integer.parseInt(userOptionString);
            
            // User inputs INVALID Log In option
            if (userOption != 1 && userOption != 2 && userOption != 3) {
                userOptionInputError(input,userOption);
            }
            // Logs into Library
            else if (userOption == 1) {
                
            }
            // Registers current user as a New User
            else if (userOption == 2) {
                
            }
            // Saves and Exits the Program
            else if (userOption == 3) {
                saveAll(s,r,b);
            }
            
        } while (userOption != 3);
    }
    
    public static Integer userOptionInputError(Scanner input, Integer userOption) {
        System.out.println(" ===== INVALID ENTRY =====");
        System.out.print("  Select your option :  ");
        String userOptionString = input.nextLine();
        userOption = Integer.parseInt(userOptionString);
        return userOption;
    }
    
    public static void logInMenuInfo() {
        System.out.println("\n --- Welcome to the Wilfred J. Airey Library at Norco College ---");
        System.out.println(" --- How can we help you today? ---");
        System.out.println("1) Press '1' to Log In.");
        System.out.println("2) Press '2' to Register as a New User.");
        System.out.println("3) Press '3' to Exit the Program.");
        System.out.print("  Select your option :  ");
    }
    
    public static void saveAll(HashMap<Integer, Student> s, Queue<Room> r, HashMap<String,Book> b) {
        System.out.println(" --- Saving all Databases ---");
                
        // Saves all Collections to Text Files
        saveStudent(s);
        saveRoom(r);
        saveBooks(b);
                
        System.out.println(" --- Thank you for using our Services! ---" 
                + "\n --- We hope to see you again soon! ---");
        System.out.println(" --- Press any key to exit... ---");
        
        // Press any Button to end program
        new Scanner(System.in).nextLine();
        
        // Ends Program
        System.exit(0);
    }
    
    public static void functionLogIn(Scanner input, HashMap<Integer, Student> s, Queue<Room> r, HashMap<String,Book> b) {
        Integer userStudentID = null;
        System.out.print("\nPlease enter your Student ID to log in : ");
        String userStudentIDString = input.nextLine();
        userStudentID = Integer.parseInt(userStudentIDString);
        
        do {
            if (userStudentIDString.toLowerCase().equals("admin")) {
                // --> Go to admin menus <--
            }
            else if (userStudentIDString.toLowerCase().equals("back")) {
                return;
            }
            else if (!s.containsKey(userStudentID)){
                
            }
            
        } while (!userStudentIDString.toLowerCase().equals("back"));
    }
    
    public static void functionLogInNotRegistered(Scanner input) {
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // ===== Load Student HashMap =====
    
    private static void loadStudent (HashMap <Integer,Student> s) {  // KEY = StudentID
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
                    s.put(blank.getStudentID(),blank);
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
    
    private static void loadBooks (HashMap <String,Book> b) {   // KEY = Book Title
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
    
    private static void saveStudent(HashMap <Integer,Student> s) {       // Saves HashMaps ; KEY = StudentID
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
                
                for (Iterator<Integer> it = s.keySet().iterator(); it.hasNext();) {
                    Integer curr = it.next();
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
                
                for (Iterator<Integer> it = s.keySet().iterator(); it.hasNext();) {
                    Integer curr = it.next();
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
    
    private static void saveBooks(HashMap <String,Book> b) {       // Saves HashMaps ; KEY = Book Titlex
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
