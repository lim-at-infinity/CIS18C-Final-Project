package studyroom;

public class Room {
    private int room;
    private boolean isVacant;

    public Room() {
        room = 0;
        isVacant = true;
    }

    public Room(int room, boolean isVacant) {
        this.room = room;
        this.isVacant = isVacant;
    }

    public void displayVanacy() {
        if(isVacant = true)
            System.out.println("Study Room " + room + ": Vacant");
        else
            System.out.println("Study Room " + room + ": Occupied");
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public boolean isVacant() {
        return isVacant;
    }

    public void setVacant(boolean vacant) {
        isVacant = vacant;
    }
    
    @Override
    public String toString() {
        return this.room + "," + this.isVacant;
    }

}