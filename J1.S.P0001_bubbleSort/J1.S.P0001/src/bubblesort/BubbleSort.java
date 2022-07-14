/*
 * Copyright(C) 2005, FPT University
 * J1.S.P0001
 * LAB211 Assignment J1.S.P0001
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-09-17                   1.0            NguyenThiNhu                  First Implement
 */
package bubblesort;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class contains methods for data input and printing results on demand.
 *
 * @author NguyenThiNhu
 */
public class BubbleSort {

    /**
     * This method is used to enter the size of the array and this method is
     * satisfied if the input is a positive integer number
     *
     * @param message
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
     * This method generates a pseudo-random integer in the range from min
     * number to max number
     *
     * @param size the size of array
     * @param min the starting value of the range (inclusive)
     * @param max end of range value (inclusive)
     * @return an array
     */
    int[] randomNumber(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();  //Call function Random()
        for (int i = 0; i < array.length; i++) {
            /* 
             * Generates a random integer between 0 and (max - min), and adding min to it results in a random integer between min to max
             * nextInt is normally exclusive of the top value, so add 1 to make it inclusive
             */
            array[i] = random.nextInt((max - min) + 1) + min;
        }
        return array;  //Array of random numbers
    }

    /**
     * Compare each pair of adjacent elements from the beginning of an array
     * and, if they are in reverse order, swap them. If at least one swap has
     * been done, repeat step 1
     *
     * @param array to sort
     * @return an array after sorting
     */
    int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) { //Loop to access each array element
            for (int j = array.length - 1; j > i; j--) { //Loop to compare array elements
                if (array[j] < array[j - 1]) { //Check if the next number is smaller than the current number
                    int temp = array[j]; //If the conditions are met, swap the 2 numbers for each other
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array; //Return a sorted array using bubble sort
    }

}
