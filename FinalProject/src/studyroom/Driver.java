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

public class Driver {

    public static void main(String[] args) {

        // Input and Collections CREATION
        HashMap <Integer,Student> s = new HashMap();
        Queue <Room> r = new LinkedList<>();
        HashMap <String, Books> b = new HashMap();
        Scanner input = new Scanner(System.in);

        // Loading up Collections
//        loadStudent(s);
//        loadRoom(r);
//        loadBooks(b);

        // Call Menu
        logInMenu(input,s,r,b);
    }

    public static void logInMenuInfo() {
        System.out.println("\n ----- LOG IN -----");
        System.out.println(" --- Welcome to the Wilfred J. Airey Library at Norco College ---");
        System.out.println(" --- How may we help you today? ---");
        System.out.println(" --- Press #1 to Log In.");
        System.out.println(" --- Press #2 to Register as a New User.");
        System.out.println(" --- Press #3 to Exit the Program.");
        System.out.print(" --- Select your option:  ");
    }

    public static void logInMenu(Scanner input, HashMap<Integer, Student> s, Queue<Room> r, HashMap<String,Books> b) {
        Integer userOption = null;
        do {
            logInMenuInfo();
            String userOptionString = input.nextLine();
            // Check if user input is NUMERIC
            while (!isNumeric(userOptionString)){
                userOptionString = userOptionInputError(input,userOptionString);
            }
            userOption = Integer.parseInt(userOptionString);

            // User inputs INVALID Log In option
            if (userOption != 1 && userOption != 2 && userOption != 3) {
                userOptionInputError(input,userOptionString);
            }
            // Logs into Library
            else if (userOption == 1) {
                functionLogIn(input,s,r,b);
            }
            // Registers current user as a New User
            else if (userOption == 2) {
                registerStudent(input,s);
            }
            // Saves and Exits the Program
            else if (userOption == 3) {
                saveAll(s,r,b);
            }

        } while (userOption != 3);
    }

    public static boolean isNumeric(String strNum) {
        try {
            Integer digit = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String userOptionInputError(Scanner input, String userOptionString) {
        System.out.print("  Select your option :  ");
        userOptionString = input.nextLine();
        return userOptionString;
    }

    public static void saveAll(HashMap<Integer, Student> s, Queue<Room> r, HashMap<String,Books> b) {
        System.out.println(" --- Saving all Databases ---");

        // Saves all Collections to Text Files
//        saveStudent(s);
//        saveRoom(r);
//        saveBooks(b);

        System.out.println(" --- Thank you for using our Services! ---"
                + "\n --- We hope to see you again soon! ---");
        System.out.println(" --- Press any key to exit... ---");
        // Press any Button to end program
        new Scanner(System.in).nextLine();

        // Ends Program
        System.exit(0);
    }

    public static void functionLogIn(Scanner input, HashMap<Integer, Student> s, Queue<Room> r, HashMap<String,Books> b) {
        Integer userStudentID = 0;
        String userStudentIDString = "";
        do {
            System.out.println("\n --- Please enter your Student ID to log in,"
                    + " or enter 'back' to return to the Log In Menu. ---");
            System.out.print("     -- Student ID: ");
            userStudentIDString = input.nextLine();

            // Check if ID input is either a number, 'admin', or 'back
            while (!isNumeric(userStudentIDString) && !userStudentIDString.toLowerCase().equals("admin")
                    && !userStudentIDString.toLowerCase().equals("back")) {
                userStudentIDString = functionStudentIDNotNumeric(input, userStudentIDString);
            }

            // If ID is a number, parse the string as an integer
            if (isNumeric(userStudentIDString)) {
                userStudentID = Integer.parseInt(userStudentIDString);
            }

            // Admin's Log In
            if (userStudentIDString.toLowerCase().equals("admin")) {
                //adminMenu(input,s,r,b);
            }
            // Return to Log In Menu
            else if (userStudentIDString.toLowerCase().equals("back")) {
                return;
            }
            // User has NOT registered their ID into the Library
            else if (!s.containsKey(userStudentID)){
                functionLogInNotRegistered();
            }
            // Student's Log In
            else if (s.containsKey(userStudentID)) {
                studentMenu(input,s,r,b);
            }

        } while (!userStudentIDString.toLowerCase().equals("back"));
    }

    public static void functionLogInNotRegistered() {
        System.out.println(" --- Student ID has not been registered into the Library collection. ---");
        System.out.println(" --- Please return to the Log In Menu to register your Student ID. ---");
    }

    public static String functionStudentIDNotNumeric(Scanner input, String userStudentIDString) {
        System.out.println(" ===== ERROR: Student ID is NUMERIC. Please enter your NUMERIC Student ID. =====");
        System.out.print("  -- Student ID: ");
        userStudentIDString = input.nextLine();
        return userStudentIDString;
    }

    public static void registerStudent(Scanner input, HashMap<Integer,Student> s) {
        Student temp = new Student();

        // New Student ID
        System.out.println("\n --- Please Enter your 7-digit Student ID ---");
        System.out.print("     -- Student ID: ");
        String registerStudentID = input.nextLine();
        while (!isNumeric(registerStudentID)) {
            registerStudentID = functionStudentIDNotNumeric(input, registerStudentID);
        }
        // ----> IMPORTANT: Need to include an ID check, see if it already exists in Hashmap
        // ----> IMPORTANT: IF ID exists, call user to input a different ID
        temp.setStudentID(Integer.parseInt(registerStudentID));

        // New Student First Name
        System.out.println("\n --- Please Enter your First Name ---");
        System.out.print("     -- First Name: ");
        String registerStudentFirstName = input.nextLine();
        temp.setFirstName(registerStudentFirstName);

        // New Student Last Name
        System.out.println("\n --- Please Enter your Last Name ---");
        System.out.print("     -- Last Name: ");
        String registerStudentLastName = input.nextLine();
        temp.setLastName(registerStudentLastName);

        s.put(Integer.parseInt(registerStudentID), temp);
        System.out.println("\n --- New Student added to the Library Collection ---");
        System.out.println('\n');
    }

    public static void studentMenu(Scanner input, HashMap<Integer, Student> s, Queue<Room> r, HashMap<String,Books> b) {
        Integer studentOption = 0;
        //Instantiate a Study room
        Room studyRoomObj = new Room();

        //temp variables we'll need later
        String name;
        String num;
        int roomnum;

        // studentMenuInfo;


        //Main Loop
        //---Display promt ---
        System.out.print(" \n");
        System.out.println(" ===== Student's Menu =====");
        System.out.println("\n --- What would you like to do? ---");
        System.out.println("   --- Press #1 for Room Reservation Department.");
        System.out.println("   --- Press #2 for Book Department.");
        System.out.println("   --- Press #3 to return to Log In Menu");
        System.out.println("   --- Select your option:  ");

        int departmentOption = input.nextInt();

        // Go to ROOM view-AVAILABLE
        switch (departmentOption)
        {
            case 1:
                break;
            case 2:
                //HARD CODING THE BOOKS
                Books books = new Books();
                System.out.println(books.addBook(1, "The Alchemist", "189-hn3-038n", "Paulo Cohelo"));
                System.out.println(books.addBook(2, "Mary Had a Little Lamb", "37h-193a-9jj", "Mozart"));
                System.out.println(books.addBook(3, "Calculus 1", "777-777-7777", "Newton"));
                System.out.print(" \n");
                System.out.println(" ===== Book Menu =====");
                System.out.println("\n --- What would you like to do? ---");
                System.out.println("   --- Press #1 To View All Books.");
                System.out.println("   --- Press #2 TO Checkout A Book.");
                System.out.println("   --- Press #3 To Return A book");
                System.out.println("   --- Press #4 To Return to student menu.");
                System.out.println("   --- Select your option:  ");

                int bookOption = input.nextInt();

                while(bookOption != 4) {
                    switch (bookOption) {
                        case 1:
                            System.out.println(books.displayBooks());
                            break;
                        case 2:
                            System.out.println("Enter the title of the book: ");
                            String title = input.nextLine();
                            System.out.println("Enter your name:");
                            String Studentname = input.nextLine();
                            System.out.println(books.checkoutBook(title, Studentname));
                            break;
                        case 3:
                            System.out.println("Enter the name of the book you're returning:");
                            title = input.nextLine();
                            System.out.println(books.returnBook(title));
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                }
            case 3:
                break;

            default:
                System.out.println("Invalud Input");
                break;
        }
    }
}

//========================================================== ADMIN METHODS ========================================
//
//    public static void adminMenuInfo(){
//        System.out.println("\n ===== ADMIN'S MENU - MAIN =====");
//        System.out.println("\n --- Which Collection would you like to access? ---");
//        System.out.println("1) Press '1' to access Student Collection.");
//        System.out.println("2) Press '2' to access Rooms Collection.");
//        System.out.println("3) Press '3' to access Books Collection.");
//        System.out.println("4) Enter 'back' to return to Log In.");
//        System.out.print("  Select your option :  ");
//    }
//
//    public static void adminMenu(Scanner input, HashMap<Integer, Student> s, Queue<Room> r, HashMap<String,Books> b) {
//        Integer adminOption = 0;
//        adminMenuInfo();
//        String adminOptionString = input.nextLine();
//        do {
//            // Check if Option input is either a number or 'back'
//            while(!isNumeric(adminOptionString) && !adminOptionString.toLowerCase().equals("back")) {
//                adminOptionString = userOptionInputError(input,adminOptionString);
//            }
//            // IF Option is a number, parse the string as an integer
//            if (isNumeric(adminOptionString)) {
//                adminOption = Integer.parseInt(adminOptionString);
//            }
//
//            // Return to Log In Menu
//            if (adminOptionString.toLowerCase().equals("back")) {
//                return;
//            }
//            // Admin inputs INVALID Menu Option
//            else if (adminOption != 1 && adminOption != 2 && adminOption != 3) {
//                adminOptionString = userOptionInputError(input,adminOptionString);
//            }
//            // Access to Students Collection
//            else if (adminOption == 1) {
//                adminMenuStudents(input, s);
//                break;
//            }
//            // Access to Rooms Collection
//            else if (adminOption == 2) {
//                adminMenuRooms(input,r);
//            }
//            // Access to Books Collection
//            else if (adminOption == 3) {
//                adminMenuBooks(input,b);
//            }
//
//        } while (!adminOptionString.toLowerCase().equals("back"));
//    }
//
//    public static void adminMenuStudentsInfo() {
//        System.out.println("\n ===== ADMIN'S MENU - STUDENTS ======");
//        System.out.println("\n --- What would you like to do? ---");
//        System.out.println("1) Press '1' to Create a New Student Profile.");
//        System.out.println("2) Press '2' to Edit any Current Student Profiles.");
//        System.out.println("3) Press '3' to Delete any Student Profile.");
//        System.out.println("4) Enter 'back' to return to MAIN ADMIN'S MENU.");
//        System.out.print("    Select your option :  ");
//    }
//
//    public static void adminMenuStudents(Scanner input, HashMap<Integer,Student> s) {
//        Integer adminOptionStudent = 0;
//        adminMenuStudentsInfo();
//        String adminOptionStudentString = input.nextLine();
//        do {
//            // Check if Option input is either a number or 'back'
//            while (!isNumeric(adminOptionStudentString) && !adminOptionStudentString.toLowerCase().equals("back")) {
//                adminOptionStudentString = userOptionInputError(input,adminOptionStudentString);
//            }
//            // IF Option is a number, parse the string as an integer
//            if (isNumeric(adminOptionStudentString)) {
//                adminOptionStudent = Integer.parseInt(adminOptionStudentString);
//            }
//
//            // Return to Main Admin's Menu
//            if (adminOptionStudentString.toLowerCase().equals("back")) {
//                return;
//            }
//            // Student inputs INVALID Menu Option
//            else if (adminOptionStudent != 1 && adminOptionStudent != 2 && adminOptionStudent != 3) {
//                adminOptionStudentString = userOptionInputError(input,adminOptionStudentString);
//            }
//            // Create a new Student Profile, and add to Student HashMap
//            else if (adminOptionStudent == 1){
//                // --> Go to createStudent(HashMap<Integer,Student> s) function <--
//                // --> IMPORTANT: in createStudent function, check it !HashMap.isFull();
//            }
//            // Select and Edit a Current Student Profile
//            else if (adminOptionStudent == 2){
//                // --> Go to editStudent(HashMap<Integer,Student> s) function <--
//                // --> IMPORTANT: in editStudent function, check it !HashMap.isEmpty();
//            }
//            // Select and Delete a Current Student Profile
//            else if (adminOptionStudent == 3){
//                // --> Go to deleteStudent(HashMap<Integer,Student> s) function <--
//                // --> IMPORTANT: in deleteStudent function, check it !HashMap.isEmpty();
//            }
//
//        } while (!adminOptionStudentString.toLowerCase().equals("back"));
//    }
//
//    public static void adminMenuRoomsInfo() {
//        System.out.println("\n ===== ADMIN'S MENU - ROOMS ======");
//        System.out.println("\n --- What would you like to do? ---");
//        System.out.println("1) Press '1' to Create a New Room.");
//        System.out.println("2) Press '2' to Delete a Current Room.");
//        System.out.println("3) Press '3' to Manage Current Rooms.");
//        System.out.println("4) Press '4' to Manage the Rooms Waiting List.");
//        System.out.println("5) Enter 'back' to return to MAIN ADMIN'S MENU.");
//        System.out.print("    Select your option :  ");
//    }
//
//    public static void adminMenuRooms(Scanner input, Queue<Room> r){
//        Integer adminOptionRoom = 0;
//        adminMenuRoomsInfo();
//        String adminOptionRoomString = input.nextLine();
//        do {
//            // Check if Option input is either a number or 'back'
//            while (!isNumeric(adminOptionRoomString) && !adminOptionRoomString.toLowerCase().equals("back")) {
//                adminOptionRoomString = userOptionInputError(input,adminOptionRoomString);
//            }
//            // IF Option is a number, parse the string as an integer
//            if (isNumeric(adminOptionRoomString)) {
//                adminOptionRoom = Integer.parseInt(adminOptionRoomString);
//            }
//
//            // Return to Main Admin's Menu
//            if (adminOptionRoomString.toLowerCase().equals("back")) {
//                return;
//            }
//            // Student inputs INVALID Menu Option
//            else if (adminOptionRoom != 1 && adminOptionRoom != 2 && adminOptionRoom != 3 && adminOptionRoom != 4) {
//                adminOptionRoomString = userOptionInputError(input,adminOptionRoomString);
//            }
//            // Create a new Room, and add to Room Queue
//            else if (adminOptionRoom == 1){
//                // --> Go to createRoom(Queue<Room> r) function <--
//                // --> IMPORTANT: in createRoom function, check it !Queue.isFull();
//            }
//            // Select and Delete a Current Room
//            else if (adminOptionRoom == 2){
//                // --> Go to deleteStudent(Queue<Room> r) function <--
//                // --> IMPORTANT: in deleteStudent function, check it !Queue.isEmpty();
//            }
//            // Go to Rooms Management Menu
//            else if (adminOptionRoom == 3){
//                // --> Go to manageRoomsMenu(Queue<Room> r) function <--
//            }
//            // Go to Rooms Waiting List Management Menu
//            else if (adminOptionRoom == 4){
//                // --> Go to manageWaitingListRoomsMenu(Queue<Room> r) function <--
//            }
//
//        } while (!adminOptionRoomString.toLowerCase().equals("back"));
//    }
//
//    public static void adminMenuBooksInfo() {
//        System.out.println("\n ===== ADMIN'S MENU - BOOKS ======");
//        System.out.println("\n --- What would you like to do? ---");
//        System.out.println("1) Press '1' to Create a New Books.");
//        System.out.println("2) Press '2' to Edit any Current Books.");
//        System.out.println("2) Press '3' to Delete a Current Books.");
//        System.out.println("3) Press '4' to Manage Current Books Holders.");
//        System.out.println("4) Press '5' to Manage the Books Waiting List.");
//        System.out.println("5) Enter 'back' to return to MAIN ADMIN'S MENU.");
//        System.out.print("    Select your option :  ");
//    }
//
//    public static void adminMenuBooks(Scanner input, HashMap<String,Books> b) {
//        Integer adminOptionBook = 0;
//        adminMenuBooksInfo();
//        String adminOptionBookString = input.nextLine();
//        do {
//            // Check if Option input is either a number or 'back'
//            while (!isNumeric(adminOptionBookString) && !adminOptionBookString.toLowerCase().equals("back")) {
//                adminOptionBookString = userOptionInputError(input,adminOptionBookString);
//            }
//            // IF Option is a number, parse the string as an integer
//            if (isNumeric(adminOptionBookString)) {
//                adminOptionBook = Integer.parseInt(adminOptionBookString);
//            }
//
//            // Return to Main Admin's Menu
//            if (adminOptionBookString.toLowerCase().equals("back")) {
//                return;
//            }
//            // Student inputs INVALID Menu Option
//            else if (adminOptionBook != 1 && adminOptionBook != 2 && adminOptionBook != 3 && adminOptionBook != 4 && adminOptionBook != 5) {
//                adminOptionBookString = userOptionInputError(input,adminOptionBookString);
//            }
//            // Create a new Books, and add to Books HashMap
//            else if (adminOptionBook == 1){
//                // --> Go to createBook(HashMap<String,Books> b) function <--
//                // --> IMPORTANT: in createRoom function, check it !HashMap.isFull();
//            }
//            // Select and Edit a Current Books
//            else if (adminOptionBook == 2){
//                // --> Go to editBook(HashMap<String,Books> b) function <--
//                // --> IMPORTANT: in editStudent function, check it !HashMap.isEmpty();
//            }
//            // Select and Delete a Current Books
//            else if (adminOptionBook == 3){
//                // --> Go to deleteBook(HashMap<String,Books> b) function <--
//                // --> IMPORTANT: in deleteStudent function, check it !HashMap.isEmpty();
//            }
//            // Go to Books Holders Management Menu
//            else if (adminOptionBook == 4){
//                // --> Go to manageBookHolders(HashMap<String,Books> b) function <--
//            }
//            // Go to Books Waiting List Management Menu
//            else if (adminOptionBook == 5){
//                // --> Go to manageWaitingListBookMenu(HashMap<String,Books> b) function <--
//            }
//        } while (!adminOptionBookString.toLowerCase().equals("back"));
//    }
//
//    // ===== Load Student HashMap =====
//
//    private static void loadStudent (HashMap <Integer,Student> s) {  // KEY = StudentID
//        File  databaseStudent = new File("databaseStudent.txt");
//        FileReader read = null;
//
//        // File Exceptions
//        try {
//            read = new FileReader(databaseStudent);
//            BufferedReader br = new BufferedReader(read);
//
//            String line = null;
//            try {
//                while((line = br.readLine()) != null) {
//                    Student blank  = new Student();
//                    blank.fromCSV(line);
//                    s.put(blank.getStudentID(),blank);
//                }
//            } catch (IOException ex) {
//                System.out.println("STUDENT Binary Files are NOT supported");
//            }
//        } catch (FileNotFoundException ex) {}
//    }
//
//    // ===== Load Student Queue =====
//
//    private static void loadRoom (Queue<Room> r) {
//        File  databaseRooms = new File("databaseRooms.txt");
//        FileReader read = null;
//
//        // File Exceptions
//        try {
//            read = new FileReader(databaseRooms);
//            BufferedReader br = new BufferedReader(read);
//
//            String line = null;
//            try {
//                while((line = br.readLine()) != null) {
//                    Room blank  = new Room();
//                    blank.fromCSV(line);
//                    r.add(blank);
//                }
//            } catch (IOException ex) {
//                System.out.println("ROOMS Binary Files are NOT supported");
//            }
//        } catch (FileNotFoundException ex) {}
//    }
//
//    private static void loadBooks (HashMap <String,Books> b) {   // KEY = Books Title
//        File  databaseBooks = new File("databaseBooks.txt");
//        FileReader read = null;
//
//        // File Exceptions
//        try {
//            read = new FileReader(databaseBooks);
//            BufferedReader br = new BufferedReader(read);
//
//            String line = null;
//            try {
//                while((line = br.readLine()) != null) {
//                    Books blank  = new Books();
//                    blank.fromCSV(line);
//                    b.put(blank.getTitle(),blank);
//                }
//            } catch (IOException ex) {
//                System.out.println("BOOKS Binary Files are NOT supported");
//            }
//        } catch (FileNotFoundException ex) {}
//    }
//
//
//    // ===== Save Student Database (HashMap) =====
//
//    private static void saveStudent(HashMap <Integer,Student> s) { // Saves HashMaps ; KEY = StudentID
//        // ===== FILE CREATION =====
//        FileReader read = null;
//        File databaseStudent = new File("databaseStudent.txt");
//
//        // ===== FILE SAVE FOR STUDENT DATABASE =====
//        try {
//            read = new FileReader(databaseStudent);
//            try {
//                System.out.println("Saving to databaseStudent.txt file\n"); // Tells user the program is saving the Student Database
//                FileWriter writer = null; // Creates new File Writer
//                writer = new FileWriter("databaseStudent.txt");
//                BufferedWriter out = new BufferedWriter(writer);
//
//                for (Iterator<Integer> it = s.keySet().iterator(); it.hasNext();) {
//                    Integer curr = it.next();
//                    out.write(s.get(curr).toCSV()); // Each iteration of student is being saved
//                }
//                out.close(); // Stops the File Writer
//            } catch (IOException ex2) {
//                System.out.println("\n --- STUDENT FILE ERROR --- \n");
//            }
//        } catch (FileNotFoundException ex) { // IF the file doesn't exist...
//            try {
//                System.out.println("Created new file called databaseStudent.txt\n"); // Tells user the program has NOW created the new Student Database
//                FileWriter writer = null; // Creates new File Writer
//                writer = new FileWriter("databaseStudent.txt");
//                BufferedWriter out = new BufferedWriter(writer);
//
//                for (Iterator<Integer> it = s.keySet().iterator(); it.hasNext();) {
//                    Integer curr = it.next();
//                    out.write(s.get(curr).toCSV()); // Each iteration of student is being saved
//                }
//                out.close(); // Stops the File Writer
//            } catch (IOException ex2) {
//                System.out.println("\n --- STUDENT FILE ERROR --- \n");
//            }
//        }
//    }
//
//
//    // ===== Save Room Database (Queue) =====
//
//    private static void saveRoom(Queue <Room> r){ // Saves Queues
//        // ===== FILE CREATION =====
//        FileReader read = null;
//        File databaseRooms = new File("databaseRooms.txt");
//
//        // ===== FILE SAVE FOR ROOMS DATABASE =====
//        try {
//            read = new FileReader(databaseRooms);
//            try {
//                System.out.println("Saving to databaseRooms.txt file\n"); // Tells user the program is saving the Room Database
//                FileWriter writer = null; // Creates new File Writer
//                writer = new FileWriter("databaseRooms.txt");
//                BufferedWriter out = new BufferedWriter(writer);
//
//                for (int i = 0; i < r.toArray().length; i++) {
//                    out.write(r.toArray()[i].toString()); // Each iteration of Room is being saved
//                }
//                out.close(); // Stops the File Writer
//            } catch (IOException ex2) {
//                System.out.println("\n --- ROOMS FILE ERROR --- \n");
//            }
//        } catch (FileNotFoundException ex) { // IF the file doesn't exist...
//            try {
//                System.out.println("Created new file called databaseRooms.txt\n"); // Tells user the program has NOW created the new Student Database
//                FileWriter writer = null; // Creates new File Writer
//                writer = new FileWriter("databaseRooms.txt");
//                BufferedWriter out = new BufferedWriter(writer);
//
//                for (int i = 0; i < r.toArray().length; i++) {
//                    out.write(r.toArray()[i].toString()); // Each iteration of Room is being saved
//                }
//                out.close(); // Stops the File Writer
//            } catch (IOException ex2) {
//                System.out.println("\n --- ROOMS FILE ERROR --- \n");
//            }
//        }
//    }
//
//    // ===== Save Books Database (HashMap) =====
//
//    private static void saveBooks(HashMap <String,Books> b) { // Saves HashMaps ; KEY = Books Titlex
//        // ===== FILE CREATION =====
//        FileReader read = null;
//        File databaseBooks = new File("databaseBooks.txt");
//
//        // ===== FILE SAVE FOR BOOKS DATABASE =====
//        try {
//            read = new FileReader(databaseBooks);
//            try {
//                System.out.println("Saving to databaseBooks.txt file\n"); // Tells user the program is saving the Student Database
//                FileWriter writer = null; // Creates new File Writer
//                writer = new FileWriter("databaseBooks.txt");
//                BufferedWriter out = new BufferedWriter(writer);
//
//                for (Iterator<String> it = b.keySet().iterator(); it.hasNext();) {
//                    String curr = it.next();
//                    out.write(b.get(curr).toCSV()); // Each iteration of student is being saved
//                }
//                out.close(); // Stops the File Writer
//            } catch (IOException ex2) {
//                System.out.println("\n --- BOOKS FILE ERROR --- \n");
//            }
//        } catch (FileNotFoundException ex) { // IF the file doesn't exist...
//            try {
//                System.out.println("Created new file called databaseBooks.txt\n"); // Tells user the program has NOW created the new Student Database
//                FileWriter writer = null; // Creates new File Writer
//                writer = new FileWriter("databaseBooks.txt");
//                BufferedWriter out = new BufferedWriter(writer);
//
//                for (Iterator<String> it = b.keySet().iterator(); it.hasNext();) {
//                    String curr = it.next();
//                    out.write(b.get(curr).toCSV()); // Each iteration of student is being saved
//                }
//                out.close(); // Stops the File Writer
//            } catch (IOException ex2) {
//                System.out.println("\n --- BOOKS FILE ERROR --- \n");
//            }
//        }
//    }
//
