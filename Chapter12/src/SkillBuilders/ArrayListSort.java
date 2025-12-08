/*
 
Program: ArrayListSort.java          Last Date of this Revision: December 8th, 2025

Purpose: Demonstrates performing a selection sort on an ArrayList of Double
         objects and displays the results before and after sorting.

Author: Adam Eloraby  
School: CHHS
Course: Computer Programming 30 
 
*/

package SkillBuilders;

import java.util.ArrayList;

public class ArrayListSort {

    public static void main(String[] args) {

        // Create and fill ArrayList with Double objects
        ArrayList<Double> nums = new ArrayList<Double>();
        nums.add(8.5);
        nums.add(3.2);
        nums.add(9.9);
        nums.add(1.4);
        nums.add(6.6);
        nums.add(4.1);

        System.out.println("Before sorting:");
        System.out.println(nums);

        selectionSort(nums);

        System.out.println("\nAfter sorting:");
        System.out.println(nums);
    }

    /**
     * Performs a selection sort on an ArrayList of Double values.
     */
    public static void selectionSort(ArrayList<Double> list) {

        for (int i = 0; i < list.size() - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }

            // Swap the two items
            Double temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }
}
/* Screen Dump
Before sorting:
[8.5, 3.2, 9.9, 1.4, 6.6, 4.1]

After sorting:
[1.4, 3.2, 4.1, 6.6, 8.5, 9.9]
*/