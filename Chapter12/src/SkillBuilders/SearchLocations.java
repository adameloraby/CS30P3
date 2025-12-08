/*

Program: SearchLocations.java          Last Date of this Revision: December 8th, 2025

Purpose: Perform a binary search while displaying each value examined.

Author: Adam Eloraby  
School: CHHS
Course: Computer Programming 30  

*/

package SkillBuilders;

import java.util.Scanner;

public class SearchLocations {

    public static void main(String[] args) {

        int[] numbers = {
            1, 4, 4, 7, 10, 13, 15, 16, 24, 24, 25, 27, 27, 30, 30, 30,
            49, 50, 51, 52, 53, 54, 54, 55, 57, 58, 64, 69, 74, 78, 79,
            85, 86, 86, 88, 89, 96, 96, 97, 98
        };

        // Print numbers in rows
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            if ((i + 1) % 16 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter a number to search for: ");
            String userInput = input.nextLine().trim();

            if (userInput.equals("")) {
                System.out.println("Exiting...");
                break;
            }

            int target;

            try {
                target = Integer.parseInt(userInput);
            } catch (Exception e) {
                System.out.println("Please enter a valid integer.");
                continue;
            }

            int result = binarySearch(numbers, target);

            if (result == -1) {
                System.out.println("Number not found.");
            } else {
                System.out.println("Number at index: "+ result + " (position: " + (result + 1) + ")");
            }
        }

        input.close();
    }

    /**
     * Binary search that prints values examined.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            // Print EXACTLY like sample output
            System.out.println("Examining " + arr[mid]);

            if (arr[mid] == key) {
                return mid; // found
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // not found
    }
}

/* Screen Dump:

1 4 4 7 10 13 15 16 24 24 25 27 27 30 30 30 
49 50 51 52 53 54 54 55 57 58 64 69 74 78 79 
85 86 86 88 89 96 96 97 98 

Enter a number to search for: 55
Examining 24
Examining 37
Examining 30
Examining 27
Examining 28
Number at position: 28
Enter a number to search for:

*/
