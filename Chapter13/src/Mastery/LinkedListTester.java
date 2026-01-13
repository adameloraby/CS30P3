/*

Program: LinkedListTester.java          Last Date of this Revision: January 13th, 2026

Purpose: To test the LinkedList class by adding, removing, counting, and clearing
         nodes using multiple linked list operations.

Author: Adam Eloraby  
School: CHHS
Course: Computer Programming 30 

*/

package Mastery;

/*
Program: LinkedListTester.java          Last Date of this Revision: January 13th, 2026

Purpose: To test the LinkedList class using different data types.

Author: Adam Eloraby
School: CHHS
Course: Computer Programming 30
*/

public class LinkedListTester {

    public static void main(String[] args) {

        // ================================
        // Test Case 1: String Objects
        // ================================
        System.out.println("=== Linked List Test Case 1: Strings ===");

        LinkedList list = new LinkedList();

        list.addAtFront("Hamza");
        list.addAtFront("Apple");
        list.addAtFront("Nolan");
        list.addAtFront("Car");

        list.addAtEnd("Smiley");

        System.out.println(list);

        System.out.println("list size: " + list.size() + " items.");

        list.makeEmpty();

        System.out.println("list size after makeEmpty(): "
                + list.size() + " items.");


        // ================================
        // Test Case 2: Number Objects
        // ================================
        System.out.println("\n=== Linked List Test Case 2: Numbers ===");

        LinkedList numList = new LinkedList();

        numList.addAtFront("10");
        numList.addAtFront("25");
        numList.addAtFront("40");

        numList.addAtEnd("55");
        numList.addAtEnd("70");

        System.out.println(numList);

        System.out.println("list size: " + numList.size() + " items.");

        numList.makeEmpty();

        System.out.println("list size after makeEmpty(): "
                + numList.size() + " items.");
    }
}
/* Screen Dump
=== Linked List Test Case 1: Strings ===
Car
Nolan
Apple
Hamza
Smiley

list size: 5 items.
list size after makeEmpty(): 0 items.

=== Linked List Test Case 2: Numbers ===
40
25
10
55
70

list size: 5 items.
list size after makeEmpty(): 0 items.
*/

