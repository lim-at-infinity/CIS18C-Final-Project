package studyroom_;

import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

class Book {
    
    // HashMap, mapping a book to it's title
    private HashMap<String, Book> books;
    
    public Book() { 
        books = new HashMap<>(); 
    }

    // Populate the HashMap
    public String addBook(int quantity, String title, String isbn, String author) {
        Book newBook = newBook(quantity, title, isbn, author);
	if (books.containsKey(title)) {
            return "Book is already contained.";
	} else {
            books.put(title, newBook);
        }
        return "Book was succesfully added!";
    }
    
     /*
        * Check out steps:
        * 1. Check if the book exists
	* 2. Check if there are any books left by book.quantity > 0
	* 	2.a If not, add user to queue
	* 3. Rent out the book
    */
    public String checkoutBook(String title, String studentName) {
	Book book = books.get(title);
        
	// Check if book exists
	if(book == null) { 
            return "Book does not exist."; 
        }
        
        // Check if we have any left or if there any people waiting in the queue
	if(book.getQuantity() < 1 || book.getWaitingList().size() > 0) {
            // get book, add person to queue and notify user
            Queue<String> waitingList = book.getWaitingList();
            waitingList.add(studentName);
            book.adjustWaitingList(waitingList);

            // add book back to our HashMap
            books.put(title, book);
            return "There are no more books left but you have been added to the waiting list with number: " + waitingList.size() + ".";
	}
        // If there are available books, update information and add back to HashMap.
	book.setRenter(studentName);
	book.setQuantity(book.getQuantity()-1);
	books.put(title, book);
	return "The book is yours!";
    }
    
    
    // Return book, adjust quantity and display the next person
    // in queue to check out, if there's any
    public String returnBook(String title) {
    	Book book = books.get(title);
        Queue<String> waitingList;
	String ans = "";
        
	// Check if book exists
	if (book == null) { 
            return "This is not our book."; 
        }

        // Check if there's a waiting list and give book to next person
	// If there isn't then adjust the quantity acoordingly.
            waitingList = book.getWaitingList();
            if(waitingList.size() > 0) {
		book.setRenter(waitingList.poll());
		ans += "New person to rent book is " + book.getLastRenter() + ".\n";
            } else {
		book.setRenter("None");
		book.setQuantity(book.getQuantity()+1);
            }

        book.adjustWaitingList(waitingList);
        books.put(title, book);
        ans += "You succesfully returend the book.";
	return ans;
    }

    // Iterate throught 'Books' HashMap and display the contents
    // If a book has a waiting list, then dispaly the waiting list as well.
    public String displayBooks() {
        String ans = "List of available Books:\n";
        //For-each loop 
        //for every entre e in entre set
	for(Map.Entry e : books.entrySet()) {
            ans += e.getKey() + ". " + "Number of available copies: " + 
            books.get(e.getKey()).getQuantity() + ". ";

            //If there is a waiting list, then display waiting list
            if(books.get(e.getKey()).getWaitingList().size() > 0) {
		ans+= "The waiting list is: ";
                //for-each
                // for every name in waiting list, display
		for(String name : books.get(e.getKey()).getWaitingList()) {
                    ans+=name + ", ";
                }
            } else {
		ans+="There is no waiting list on the book.";
            }
            ans+="\n";
	}
	ans+="\n";
	return ans;
    }

    char[] toCSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void fromCSV(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    
        
    

//    String getTitle() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    
//    void fromCSV(String line) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    char[] toCSV() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//}
