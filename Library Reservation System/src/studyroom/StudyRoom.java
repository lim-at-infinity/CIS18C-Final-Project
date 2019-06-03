
package studyroom;

//import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


public class StudyRoom {

    public static void main(String[] args) {
        Queue<String> waitingQueue = new LinkedList<>();
        
        waitingQueue.add(" ");
        
        System.out.println("Waiting Queue : " + waitingQueue);
        
       // System.out.println("Is the waiting Queue empty? : " + waitingQueue.isEmpty());
        
        System.out.println("The size of the waiting Queue is : " + waitingQueue.size());
        
        String name = " ";
        if(waitingQueue.contains(name)) {
            System.out.println("The waiting Queue contains " + name);
        } else {
            System.out.println("The waiting Queue doesn't contain " + name);
        }
        
        String firstStudentInTheWaitingQueue = waitingQueue.element();
        System.out.println("The next student in the waiting Queue is (element()) : " + firstStudentInTheWaitingQueue);
        
        firstStudentInTheWaitingQueue = waitingQueue.peek();
        System.out.println("The first student in the waiting Queue is : " + firstStudentInTheWaitingQueue);
        
   
    }
     
}
