/*
 * Copyright(C) 2005, FPT University
 * J1.S.P0020
 * LAB211 Assignment J1.S.P0020
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-09-17                   1.0            NguyenThiNhu                  First Implement
 */
package selectionsort;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyễn Thị Như !
 */
public class SelectionSort {

    /**
     * This method is used to enter the size and elements of the array and this
     * method is satisfied if the input is a positive integer number
     *
     * @return an integer
     */
    int getNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        String number = "";
        while (true) {
            System.out.print(message);
            try {
                number = scanner.nextLine();   //Input data
                Pattern pattern = Pattern.compile("[0-9]+$");  //Pattern with one or more numbers
                if (pattern.matcher(number).find()) {  //Return if the number matches the pattern
                    return Integer.parseInt(number);
                } else {
                    System.out.println("Invalid, please input positive integer number !");
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    /**
     * This method is to display all the elements in the array
     *
     * @param array to display
     */
    void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {  //Traverse all elements
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("]\n");
    }

    /**
     * This method specifies that an element is selected from the unsorted array
     * and moved to the sorted array with each iteration of selection sort.
     *
     * array[] = 64 25 12 22 11
     *
     * 11 | 25 12 22 64 11 12 | 25 22 64 11 12 22 | 25 64 11 12 22 25 | 64
     *
     * @param array to sort
     * @return an array after sorting
     */
    int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) { //One by one move boundary of unsorted array
            /* Finding the minimum element in the unsorted part of array */
            int indexMinValue = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexMinValue]) {
                    indexMinValue = j;
                }
            }
            /* Swapping the found minimum element with the first element of the sorted subarray using temp variable */
            int temp = array[indexMinValue];
            array[indexMinValue] = array[i];
            array[i] = temp;
        }
        return array; //Return a sorted array using selection sort
    }
}
