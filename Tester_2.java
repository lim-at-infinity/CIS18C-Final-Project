package tester_2;

/**
 *
 * @author pita
 */
public class Tester_2
{
    public static void main(String[] args)
    {
	Books books = new Books();
	System.out.println(books.addBook(1, "The Alchemist", "189-hn3-038n", "Paulo Cohelo"));
	System.out.println(books.addBook(2, "Mary Had a Little Lamb", "37h-193a-9jj", "Mozart"));
	System.out.println(books.addBook(3, "Calculus 1", "777-777-7777", "Newton"));

	System.out.println(books.displayBooks());

	// Test the Queue system with the Alchemist.		
	System.out.println("Juan checks out 'The Alchemist'.");
	System.out.println(books.checkoutBook("The Alchemist", "Juan"));
	System.out.println(books.displayBooks());

	System.out.println("Pablo checks out 'The Alchemist'.");
	System.out.println(books.checkoutBook("The Alchemist", "Pablo"));
	System.out.println(books.displayBooks());

	System.out.println("Manda checks out 'The Alchemist'.");
	System.out.println(books.checkoutBook("The Alchemist", "Manda"));
	System.out.println(books.displayBooks());

	System.out.println("Juan returns 'The Alchemist'.");
	System.out.println(books.returnBook("The Alchemist"));
	System.out.println(books.displayBooks());

	System.out.println("Pita checks out 'The Alchemist'.");
	System.out.println(books.checkoutBook("The Alchemist", "Pita"));
	System.out.println(books.displayBooks());

	// Test the class User wich implements quicksort and binary search
	Users users = new Users();
	System.out.println(users.addUser("Pita", 852));
	System.out.println(users.addUser("Beto", 658));
	System.out.println(users.addUser("Juan", 966));
	System.out.println(users.addUser("Manda", 10));
	System.out.println(users.addUser("Pablo", 527));
	System.out.println();
        
	System.out.println("Displaying Users.");
	System.out.println(users.displayUsers());
	System.out.println("Displaying users after sorting.");
	
        users.sortUsers();
        System.out.println(users.displayUsers());
        
	System.out.println("Searching for user with id: 527");
	System.out.println("User is : " + users.searchById(527));
	System.out.println("Searching for user with id: 3000");
	System.out.println("User is : " + users.searchById(3000));
	}
}
