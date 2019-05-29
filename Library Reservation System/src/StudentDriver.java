/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdriver;

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

}
