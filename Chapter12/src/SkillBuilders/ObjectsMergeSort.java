/*

Program: ObjectsMergeSort.java          Last Date of this Revision: December 8th, 2025

Purpose: Demonstrate mergesort on an array of objects (Strings).

Author: Adam Eloraby
School: CHHS
Course: Computer Programming 30  

*/

package SkillBuilders;

public class ObjectsMergeSort {

    public static void main(String[] args) {

        // Test data
        String[] words = { "zebra", "apple", "kite", "mango", "bear", "tiger", "lion" };

        System.out.println("Before Sorting:");
        display(words);

        mergeSort(words, 0, words.length - 1);

        System.out.println("\nAfter Sorting:");
        display(words);
    }

    /**
     * mergeSort
     * Performs a mergesort on an array of Comparable objects.
     */
    public static void mergeSort(Comparable[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    /**
     * merge
     * Merges two sorted subarrays into a single sorted array.
     */
    public static void merge(Comparable[] arr, int left, int mid, int right) {

        int size1 = mid - left + 1;
        int size2 = right - mid;

        Comparable[] L = new Comparable[size1];
        Comparable[] R = new Comparable[size2];

        for (int i = 0; i < size1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < size2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < size1 && j < size2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy rest of L[]
        while (i < size1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy rest of R[]
        while (j < size2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * display
     * Prints array contents.
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
