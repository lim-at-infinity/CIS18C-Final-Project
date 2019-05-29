/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyroom;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author jteet
 */
public class Book implements LSD {
    /*
    * Data Structure to represent a book
    * Properties: Author, Title, ISBN, available quantitiy
    */
    
    // Properties of a book
	protected int quantity;
	protected String title;
        protected String isbn;
        protected String author;
        protected String checkedOutBy;
	protected Queue<String> waitingList;
        
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
	public Book(int quantity, String title, String isbn, String author) {
            this.quantity = quantity;
            this.title = title;
            this.isbn = isbn;
            this.author = author;
            checkedOutBy = null;
            waitingList = new LinkedList<String>();
	}

	// Getters
        public int getQuantity() {
            return quantity; 
        }
	public String getTitle() { 
            return title; 
        }
	public String getISBN() { 
            return isbn; 
        }
        public String getAuthor() {
            return author; 
        }
	public String getLastRenter() {
            return checkedOutBy; 
        }
	public Queue<String> getWaitingList() {
            return waitingList;
        }

        // Setters
        public void setQuantity(int quantity) { 
            this.quantity = quantity;
        }
        public void setTitle(String title) { 
           this.title = title; 
        }
        public void setISBN(String isbn) { 
            this.isbn = isbn; 
        }
        public void setAuthor(String author) { 
            this.author = author;
        }
        public void setRenter(String checkedOutBy) { 
            this.checkedOutBy = checkedOutBy; 
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
            + "\nQuantity" + this.quantity + "Checked out by : " + this.checkedOutBy);
        }
}
