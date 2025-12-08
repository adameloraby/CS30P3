/*

Program: ObjectsInsertionSort.java          Last Date of this Revision: December 8th, 2025

Purpose: Demonstrate insertion sort on an array of objects (Strings).

Author: Adam Eloraby  
School: CHHS  
Course: Computer Programming 30  

*/

package SkillBuilders;

public class ObjectsInsertionSort {

    public static void main(String[] args) {

        // Test data
        String[] words = { "zebra", "apple", "kite", "mango", "bear", "tiger", "lion" };

        System.out.println("Before Sorting:");
        display(words);

        insertionSort(words);

        System.out.println("\nAfter Sorting:");
        display(words);
    }

    /**
     * insertionSort
     * Performs an insertion sort on an array of Comparable objects.
     */
    public static void insertionSort(Comparable[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Comparable key = arr[i];
            int j = i - 1;

            // Move elements greater than key up one index
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    /**
     * display
     * Outputs all elements in an array.
     */
    public static void display(Object[] arr) {
        for (Object o : arr) {
            System.out.println(o);
        }
    }
}

/* Screen Dump:

Before Sorting:
zebra
apple
kite
mango
bear
tiger
lion

After Sorting:
apple
bear
kite
lion
mango
tiger
zebra

*/

