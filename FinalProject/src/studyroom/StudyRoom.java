package studyroom;

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
                // Library Register New User Function
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
        } catch (NumberFormatException|NullPointerException nfe) {
            return false;
        }
        return true;
    }
    
    public static String userOptionInputError(Scanner input, String userOptionString) {
        System.out.println("\n ===== INVALID ENTRY =====");
        System.out.print("  Select your option :  ");
        userOptionString = input.nextLine();
        return userOptionString;
    }
    
    public static void logInMenuInfo() {
        System.out.println("\n ===== LOG IN =====");
        System.out.println(" --- Welcome to the Wilfred J. Airey Library at Norco College ---");
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
        String userStudentIDString = null;
        do {
            System.out.println("\n ---Please enter your Student ID to log in,"
                    + "or enter 'back' to return to the Log In Menu. ---");
            System.out.print("  Student ID : ");
            userStudentIDString = input.nextLine();
            // Check if ID input is either a number, 'admin', or 'back
            while (!isNumeric(userStudentIDString) || !userStudentIDString.toLowerCase().equals("admin") 
                    || !userStudentIDString.toLowerCase().equals("back")) {
                userStudentIDString = functionStudentIDNotNumeric(input, userStudentIDString);
            }
            // If ID is a number, parse the string as an integer
            if (isNumeric(userStudentIDString)) {
                userStudentID = Integer.parseInt(userStudentIDString);
            }
        
            // Admin's Log In
            if (userStudentIDString.toLowerCase().equals("admin")) {
                // --> Go to admin menus <--
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
                // --> Go to Student's Menu
            }
            
        } while (!userStudentIDString.toLowerCase().equals("back"));
    }
    
    public static void functionLogInNotRegistered() {
        System.out.println("ID has not been registered into the Library Collection.");
        System.out.println("Please return to the Log In Menu to register your Student ID.");
    }
    
    public static String functionStudentIDNotNumeric(Scanner input, String userStudentIDString) {
        System.out.println("Student ID is Numeric. Please enter your NUMERIC Student ID.");
        System.out.print("Student ID :  ");
        userStudentIDString = input.nextLine();
        return userStudentIDString;
    }
    
    public static void registerStudent(Scanner input, HashMap<Integer,Student> s) {
        Student temp = new Student();
        
        // New Student ID
        System.out.println("\n --- Please Enter your 7-digit Student ID ---");
        System.out.print("    Student ID :  ");
        String registerStudentID = input.nextLine();
        while (!isNumeric(registerStudentID)) {
            registerStudentID = functionStudentIDNotNumeric(input, registerStudentID);
        }
        temp.setStudentID(Integer.parseInt(registerStudentID));
        
        // New Student Name
        System.out.println("\n --- Please Enter your First Name ---");
        System.out.print("  Student Name :  ");
        String registerStudentName = input.nextLine();
        temp.setName(registerStudentName);
        
        // New Student Email
        System.out.println("\n --- Please Enter your Student Email ---");
        System.out.print("  Student Email :  ");
        String registerStudentEmail = input.nextLine();
        temp.setEmail(registerStudentEmail);
        
        s.put(Integer.parseInt(registerStudentID), temp);
        System.out.println("\n --- New Student added to the Library Collection ---");
    }
    
    public static void adminMenu(Scanner input, HashMap<Integer, Student> s, Queue<Room> r, HashMap<String,Book> b) {
        Integer adminOption = null;
        adminMenuInfo();
        String adminOptionString = input.nextLine();
        do {
            // Check if Option input is either a number or 'back'
            while(!isNumeric(adminOptionString) || adminOptionString.toLowerCase().equals("back")) {
                adminOptionString = userOptionInputError(input,adminOptionString);
            }
            
            // IF Option is a number, parse the string as an integer
            if (isNumeric(adminOptionString)) {
                adminOption = Integer.parseInt(adminOptionString);
            }
            
            // Return to Log In Menu
            if (adminOptionString.toLowerCase().equals("back")) {
                return;
            }
            // Admin inputs INVALID Menu Option
            else if (adminOption != 1 && adminOption != 2 && adminOption != 3) {
                adminOptionString = userOptionInputError(input,adminOptionString);
            }
            // Access to Students Collection
            else if (adminOption == 1) {
                // --> Go to STUDENTS Collection Menu <--
            }
            // Access to Rooms Collection
            else if (adminOption == 2) {
                // --> Go to ROOMS Collection Menu <--
            }
            // Access to Books Collection
            else if (adminOption == 3) {
                // --> Go to BOOKS Collection Menu <--
            }
            
        } while (!adminOptionString.toLowerCase().equals("back"));
        
        
    }
    
    public static void adminMenuInfo(){
        System.out.println("\n ===== ADMIN'S MENU =====");
        System.out.println("\n --- Which Collection would you like to access? ---");
        System.out.println("1) Press '1' to access Student Collection.");
        System.out.println("2) Press '2' to access Rooms Collection.");
        System.out.println("3) Press '3' to access Books Collection.");
        System.out.println("4) Enter 'back' to return to Log In");
        System.out.print("  Select your option :  ");
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
    
    private static void saveStudent(HashMap <Integer,Student> s) { // Saves HashMaps ; KEY = StudentID
        // ===== FILE CREATION =====
        FileReader read = null;
        File databaseStudent = new File("databaseStudent.txt");
        
        // ===== FILE SAVE FOR STUDENT DATABASE ===== 
        try {
            read = new FileReader(databaseStudent);
            try {
                System.out.println("Saving to databaseStudent.txt file\n"); // Tells user the program is saving the Student Database
                FileWriter writer = null; // Creates new File Writer
                writer = new FileWriter("databaseStudent.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<Integer> it = s.keySet().iterator(); it.hasNext();) {
                    Integer curr = it.next();
                    out.write(s.get(curr).toCSV()); // Each iteration of student is being saved
                }
                out.close(); // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- STUDENT FILE ERROR --- \n");
            }
        } catch (FileNotFoundException ex) { // IF the file doesn't exist...
            try {
                System.out.println("Created new file called databaseStudent.txt\n"); // Tells user the program has NOW created the new Student Database
                FileWriter writer = null; // Creates new File Writer
                writer = new FileWriter("databaseStudent.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<Integer> it = s.keySet().iterator(); it.hasNext();) {
                    Integer curr = it.next();
                    out.write(s.get(curr).toCSV()); // Each iteration of student is being saved
                }
                out.close(); // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- STUDENT FILE ERROR --- \n");
            }
        }
    }
    
    
    // ===== Save Room Database (Queue) =====
    
    private static void saveRoom(Queue <Room> r){ // Saves Queues
        // ===== FILE CREATION =====
        FileReader read = null;
        File databaseRooms = new File("databaseRooms.txt");
        
        // ===== FILE SAVE FOR ROOMS DATABASE =====
        try {
            read = new FileReader(databaseRooms);
            try {
                System.out.println("Saving to databaseRooms.txt file\n"); // Tells user the program is saving the Room Database
                FileWriter writer = null; // Creates new File Writer
                writer = new FileWriter("databaseRooms.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (int i = 0; i < r.toArray().length; i++) {
                    out.write(r.toArray()[i].toString()); // Each iteration of Room is being saved
                }
                out.close(); // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- ROOMS FILE ERROR --- \n");
            }
        } catch (FileNotFoundException ex) { // IF the file doesn't exist...
            try {
                System.out.println("Created new file called databaseRooms.txt\n"); // Tells user the program has NOW created the new Student Database
                FileWriter writer = null; // Creates new File Writer
                writer = new FileWriter("databaseRooms.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (int i = 0; i < r.toArray().length; i++) {
                    out.write(r.toArray()[i].toString()); // Each iteration of Room is being saved
                }
                out.close(); // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- ROOMS FILE ERROR --- \n");
            }
        }
    }
    
    // ===== Save Books Database (HashMap) =====
    
    private static void saveBooks(HashMap <String,Book> b) { // Saves HashMaps ; KEY = Book Titlex
        // ===== FILE CREATION =====
        FileReader read = null;
        File databaseBooks = new File("databaseBooks.txt");
        
        // ===== FILE SAVE FOR BOOKS DATABASE ===== 
        try {
            read = new FileReader(databaseBooks);
            try {
                System.out.println("Saving to databaseBooks.txt file\n"); // Tells user the program is saving the Student Database
                FileWriter writer = null; // Creates new File Writer
                writer = new FileWriter("databaseBooks.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<String> it = b.keySet().iterator(); it.hasNext();) {
                    String curr = it.next();
                    out.write(b.get(curr).toCSV()); // Each iteration of student is being saved
                }
                out.close(); // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- BOOKS FILE ERROR --- \n");
            }
        } catch (FileNotFoundException ex) { // IF the file doesn't exist...
            try {
                System.out.println("Created new file called databaseBooks.txt\n"); // Tells user the program has NOW created the new Student Database
                FileWriter writer = null; // Creates new File Writer
                writer = new FileWriter("databaseBooks.txt");
                BufferedWriter out = new BufferedWriter(writer);
                
                for (Iterator<String> it = b.keySet().iterator(); it.hasNext();) {
                    String curr = it.next();
                    out.write(b.get(curr).toCSV()); // Each iteration of student is being saved
                }
                out.close(); // Stops the File Writer
            } catch (IOException ex2) {
                System.out.println("\n --- BOOKS FILE ERROR --- \n");
            }
        }
    }
}
