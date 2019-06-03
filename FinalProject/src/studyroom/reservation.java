package studyroom;

/**
 * Reservation class to store the user and study room data
 */

class reservation {

    //Instance variables
    private String name;
    private int roomNumber;


    //Constructor, user name must be added & optionally a room
    public reservation(String user) {
        name = user;
    }

    public reservation(String user, int room) {
        name = user;
        roomNumber = room;
    }

    //Mutators, set the room number or name
    public void setRoom(int newroom) {
        roomNumber = newroom;
    }

    public void setName(String newname) {
        name = newname;
    }


    public String toString() {
        return (name + "  " + roomNumber);
    }

    //accessors, returns the room number or name
    public int getRoom() {
        return roomNumber;
    }

    public String getName() {
        return name;
    }
}