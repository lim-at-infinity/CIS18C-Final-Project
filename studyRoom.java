package reservations;

import java.util.ArrayList;

/**
 *studyRoom is an ArrayList of reservations
 *Users may request and cancel study room it if wanted
 *Ability to increase the number of study rooms  
 */

public class studyRoom {
    //Instance variable
    //ArrayList tracks current reservation
    private final ArrayList<reservation> rooms;
    private int rnum = 1;
    
    //Constructors, to specify how many rooms to begin with
    reservation reserveObj;
    
    /**
     * Constructor
     */
    public studyRoom() {
        rooms = new ArrayList<>();
        rooms.ensureCapacity(1);
        for (int i = 0; i < 4; i++) {
            rooms.add(null);
        }
    }
    
    /**
     * Constructor
     * @param numRooms
     */
    public studyRoom(int numRooms) {
        rooms = new ArrayList<>();
        rooms.ensureCapacity(numRooms);
        for (int i = 0; i < numRooms; i++) {
            rooms.add(null);
        }
    }
    
    //Increasing the study rooms
    //Returning true on success
    /**
     * Method for building study rooms 
     * @param num
     * @return 
     */
    
    public boolean buildRooms(int num) {
        //Makes sure parameter is valid
        if (num <= 0) {
            return false;
        }
        
        //Increase the capacity of the Vector
        rooms.ensureCapacity(rooms.size() + num);
        for (int i = 0; i < num; i++) {
            rooms.add(null);
        }
        //report success
        return true;
    }
    
    //Reserves & returns an avialable studyroom
    //or returns -1 if studyroom is full
    /**
     * Method for reserve study room
     * @param user
     * @return 
     */
    
    public int reserveRoom(String user) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) == null) {
                reserveObj = new reservation(user);
                reserveObj.setRoom(rnum);
                rooms.set(i, reserveObj);
                rnum++;
                return rnum - 1;
            }
        }
        return -1;
    }
    
    //Reserves a particular room for this user
    //Returns false on failure(eg. study room is already reserved)
    /**
     * Reserve study room with user & study room number
     * @param user
     * @param roomNum
     * @return 
     */
    
    public boolean reserveRoom(String user, int roomNum) {
        try {
            if (rooms.get(roomNum - 1) == null) {
                reserveObj = new reservation(user,roomNum);
                rooms.set(roomNum - 1,reserveObj);
                rnum++;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    //Allowing user to cancel reservation
    /**
     * Canceling reservation
     * @param user
     */
    
    public void cancelreservation(String user) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) != null) {
                if (rooms.get(i).getName().equals(user)) {
                    rooms.set(i, null);
                }
            }
        }
    }
    
    // Displays current, total number and vacancies of reservations
    /**
     * Reservation printing
     */
    public void printreservation() {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) != null) {
                System.out.println(rooms.get(i));
            } else {
                System.out.println(("Study room ") + (i + 1 ) + (" is available"));
            }
        }
    }
}

