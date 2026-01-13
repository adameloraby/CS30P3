/*

Program: Stack2tester.java          Last Date of this Revision: January 13th, 2026

Purpose: To test the Stack2 class by demonstrating stack operations such as push,
         pop, top, size, and makeEmpty using Object data.

Author: Adam Eloraby  
School: CHHS
Course: Computer Programming 30 

*/

package Mastery;

/*
Program: Stack2Tester.java          Last Date of this Revision: January 13th, 2026

Purpose: To test the Stack2 class using different data types.

Author: Adam Eloraby
School: CHHS
Course: Computer Programming 30
*/

public class Stack2tester {

    public static void main(String[] args) {

        // ================================
        // Test Case 1: String Objects
        // ================================
        System.out.println("=== Stack Test Case 1: Strings ===");

        Stack2 s2 = new Stack2(5);

        s2.push("Hamza");
        s2.push("Apple");
        s2.push("Nolan");

        System.out.println("Top is pointing to: " + s2.top());
        System.out.println("Size of the stack: " + s2.size());

        s2.pop();
        s2.pop();

        s2.push("Car");

        System.out.println("Top is pointing to: " + s2.top());
        System.out.println("Size of the stack: " + s2.size());


        // ================================
        // Test Case 2: Number Objects
        // ================================
        System.out.println("\n=== Stack Test Case 2: Numbers ===");

        Stack2 numStack = new Stack2(5);

        numStack.push(10);
        numStack.push(25);
        numStack.push(42);

        System.out.println("Top is pointing to: " + numStack.top());
        System.out.println("Size of the stack: " + numStack.size());

        numStack.pop();
        numStack.push(99);

        System.out.println("Top is pointing to: " + numStack.top());
        System.out.println("Size of the stack: " + numStack.size());
    }
}
/* Screen Dump
=== Stack Test Case 1: Strings ===
Top is pointing to: Nolan
Size of the stack: 3
Top is pointing to: Car
Size of the stack: 2

=== Stack Test Case 2: Numbers ===
Top is pointing to: 42
Size of the stack: 3
Top is pointing to: 99
Size of the stack: 3
*/