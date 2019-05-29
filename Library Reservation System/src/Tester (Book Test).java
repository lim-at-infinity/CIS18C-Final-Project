package tester;
/**
 *
 * @author pita
 */

public class Tester
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
	}
}
