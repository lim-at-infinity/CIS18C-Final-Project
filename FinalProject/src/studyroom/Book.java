package studyroom;

import java.util.LinkedList;
import java.util.Queue;

public class Book implements LSD {
    /*
    * Data Structure to represent a book
    * Properties: Author, Title, ISBN, available quantitiy, Who checked it out, Who's waiting for it after
    */
    
    // Properties of a book
	private Integer quantity;
	private String title;
        private String isbn;
        private String author;
        private String checkedOutBy;
	private Queue<String> waitingList;
        
        // Default Constuctor
        public Book() {
            this.title = null;
            this.author = null;
            this.isbn = null;
            this.quantity = 0;
            this.checkedOutBy = null;
            this.waitingList = null;
        }
        
        // Overloaded Constructor
	public Book(Integer quantity, String title, String isbn, String author) {
            this.quantity = quantity;
            this.title = title;
            this.isbn = isbn;
            this.author = author;
            checkedOutBy = null;
            waitingList = new LinkedList<String>();
	}

        // ----- Quantity Get and Set -----
        // (IN LIBRARY NOT CHECKED OUT)
        public Integer getQuantity() {
            return quantity; 
        }
        public void setQuantity(int quantity) { 
            this.quantity = quantity;
        }
        
        // ----- Title Get and Set -----
	public String getTitle() { 
            return title; 
        }
        public void setTitle(String title) { 
           this.title = title; 
        }
        
        // ----- ISBN Get and Set -----
	public String getISBN() { 
            return isbn; 
        }
        public void setISBN(String isbn) { 
            this.isbn = isbn; 
        }
        
        // ----- Author Get and Set -----
        public String getAuthor() {
            return author; 
        }
        public void setAuthor(String author) { 
            this.author = author;
        }
        
        // ----- CheckedOutBy Get and Set -----
	public String getLastRenter() {
            return checkedOutBy; 
        }
        public void setRenter(String checkedOutBy) { 
            this.checkedOutBy = checkedOutBy; 
        }
        
        // ----- WaitingList Get and Set -----
	public Queue<String> getWaitingList() {
            return waitingList;
        }
        public void adjustWaitingList(Queue<String> updatedWaitingList) { 
            waitingList = updatedWaitingList;
        }
        
        @Override
        public void fromCSV(String CSV) {
            String[] kv = CSV.split(":");
            String key = kv[0];
            
            String[] arrOfStr = kv[1].split(",");
            
            this.title = key;
            this.author = arrOfStr[0];
            this.isbn = arrOfStr[1];
            this.quantity = Integer.parseInt(arrOfStr[2]);
            this.checkedOutBy = arrOfStr[3];
        }
        
        @Override
        public String toCSV() {
            return this.title + ":" + this.author + "," + this.isbn + "," + this.quantity + "," + this.checkedOutBy;
        }

        @Override
        public void display() {
            System.out.println("Title : " + this.title + "\nAuthor : " + this.author + "\nISBN : " + this.isbn 
            + "\nQuantity in Library : " + this.quantity + "Checked out by : " + this.checkedOutBy);
        }
}
