public class StudyRoom {
    private int room;
    private boolean isVacant;

    public StudyRoom() {
        room = 0;
        isVacant = true;
    }

    public StudyRoom(int room, boolean isVacant) {
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

}
