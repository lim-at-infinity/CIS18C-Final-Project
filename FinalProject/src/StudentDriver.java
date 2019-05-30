/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Briana
 */
public class StudentDriver {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        HashMap<String, Integer> studentList = new HashMap<String, Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.print("Enter your choice: ");
        Integer choice = Integer.parseInt(input.nextLine());
        if(choice == 1){
            System.out.println("Login in: ");
            System.out.print("Enter your name: ");
            String name = input.nextLine();
        
            System.out.print("Enter your id number: ");
            Integer idNumber = Integer.parseInt(input.nextLine());        
            studentList.putIfAbsent(name, idNumber);
            
        }else if (choice == 2){
            System.out.println("Registering: ");
            System.out.print("Enter your name: ");
            String name = input.nextLine();
        
            System.out.print("Enter your id number: ");
            Integer idNumber = Integer.parseInt(input.nextLine());        
            studentList.put(name,idNumber);
        }
        
        System.out.println(studentList);
        
    }

    public void bookTest() {
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
