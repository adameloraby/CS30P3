/*

Program: Queue2Tester.java          Last Date of this Revision: January 13th, 2026

Purpose: To test the Queue2 class by demonstrating enqueue and dequeue operations
         using a circular queue implemented with an Object array.

Author: Adam Eloraby  
School: CHHS
Course: Computer Programming 30 

*/

package Mastery;

/*
Program: Queue2Tester.java          Last Date of this Revision: January 13th, 2026

Purpose: To test the Queue2 class using different data types.

Author: Adam Eloraby
School: CHHS
Course: Computer Programming 30
*/

public class Queue2Tester {

    public static void main(String[] args) {

        // ================================
        // Test Case 1: String Objects
        // ================================
        System.out.println("=== Queue Test Case 1: Strings ===");

        Queue2 q = new Queue2(5);

        q.enqueue("Hamza");
        q.enqueue("Apple");
        q.enqueue("Nolan");

        q.dequeue();

        q.enqueue("Car");
        q.enqueue("Smiley");

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }


        // ================================
        // Test Case 2: Number Objects
        // ================================
        System.out.println("\n=== Queue Test Case 2: Numbers ===");

        Queue2 numQueue = new Queue2(5);

        numQueue.enqueue(5);
        numQueue.enqueue(12);
        numQueue.enqueue(30);

        numQueue.dequeue();

        numQueue.enqueue(45);
        numQueue.enqueue(60);

        while (!numQueue.isEmpty()) {
            System.out.println(numQueue.dequeue());
        }
    }
}
/* Screen Dump

*/

