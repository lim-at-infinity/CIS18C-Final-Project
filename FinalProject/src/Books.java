import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

public class Books
{
    /*
    * Data Structure to represent a book
    * Properties: Author, Title, ISBN, available quantitiy
    */
    private class Book {

    private int quantity;
    private String title;
    private String isbn;
    private String author;
    private String checkedOutBy;
    private Queue<String> waitingList;

	public Book(int quantity, String title, String isbn, String author) {
	    this.quantity = quantity;
	    this.title = title;
	    this.isbn = isbn;
	    this.author = author;
	    checkedOutBy = null;
	    waitingList = new LinkedList<String>();
	}

	public int getQuantity()
        {
            return quantity; 
        }
	public String getTitle()
        { 
            return title; 
        }
	public String getISBN() 
        { 
            return isbn; 
        }public String getAuthor()
        {
            return author; 
        }
	public String getLastRenter() 
        {
            return checkedOutBy; 
        }
	public Queue<String> getWaitingList() 
        {
            return waitingList;
        }

    public void setQuantity(int quantity)
        { 
            this.quantity = quantity;
        }
    public void setTitle(String title)
        { 
           this.title = title; 
        }
    public void setISBN(String isbn)
        { 
            this.isbn = isbn; 
        }
    public void setAuthor(String author)
        { 
            this.author = author;
        }
    public void setRenter(String checkedOutBy)
        { 
            this.checkedOutBy = checkedOutBy; 
        }
    public void adjustWaitingList(Queue<String> updatedWaitingList)
        { 
            waitingList = updatedWaitingList;
        }
    }

    // HashMap, mapping a book to it's title
    private HashMap<String, Book> books;

    public Books() 
    { 
        books = new HashMap<String, Book>(); 
    }

    // Populate the HashMap
    public String addBook(int quantity, String title, String isbn, String author)
    {
        Book newBook = new Book(quantity, title, isbn, author);
	if(books.containsKey(title))
        {
            return "Book is already contained.";
	}
        else
        {
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
    public String checkoutBook(String title, String studentName)
    {
	Book book = books.get(title);
        
	// Check if book exists
	if(book == null)
        { 
            return "Book does not exist."; 
        }

	// Check if we have any left or if there any people waiting in the queue
	if(book.getQuantity() < 1 || book.getWaitingList().size() > 0) 
        {
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
    public String returnBook(String title)
    {
    	Book book = books.get(title);
        Queue<String> waitingList;
	String ans = "";
        
	// Check if book exists
	if(book == null)
        { 
            return "This is not our book."; 
        }

        // Check if there's a waiting list and give book to next person
	// If there isn't then adjust the quantity acoordingly.
            waitingList = book.getWaitingList();
            if(waitingList.size() > 0)
            {
		book.setRenter(waitingList.poll());
		ans += "New person to rent book is " + book.getLastRenter() + ".\n";
            }
            else 
            {
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
    public String displayBooks()
    {
        String ans = "List of available Books:\n";
        //For-each loop 
        //for every entre e in entre set
	for(Map.Entry e : books.entrySet())
        {
            ans += e.getKey() + ". " + "Number of available copies: " + 
            books.get(e.getKey()).getQuantity() + ". ";

            //If there is a waiting list, then display waiting list
            if(books.get(e.getKey()).getWaitingList().size() > 0)
            {
		ans+= "The waiting list is: ";
                //for-each
                // for every name in waiting list, display
		for(String name : books.get(e.getKey()).getWaitingList())
                {
                    ans+=name + ", ";
                }
            }
            else
            {
		ans+="There is no waiting list on the book.";
            }
            ans+="\n";
	}
	ans+="\n";
	return ans;
    }
}
