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

/**
 * This class allows the user to input the number of array. Generate random
 * integer in number range input. Display unsorted array and sorted array using
 * bubble sort.
 *
 * @author NguyenThiNhu
 */
public class Main {

    /**
     * Check and print the results to the screen
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        /* Call the method getNumber() */
        int size = 0;
        while (true) {
            size = sort.getNumber("Input array size: ");
            if (size > 0) {
                break;
            }
        }
        int minNumber = 0;
        int maxNumber = 0;
        while (true) {
            minNumber = sort.getNumber("Input min number: ");
            maxNumber = sort.getNumber("Input max number: ");
            if (minNumber < maxNumber) {  //If the condition is satisfied, accept it 
                break;
            } else { //If the requirement is not met, request a re-entry
                System.out.println("Invalid, please input max number > min number !");
            }
        }

        /* Generates a pseudo-random integer in the range from min to max */
        int[] array = sort.randomNumber(size, minNumber, maxNumber);
        System.out.print("\nUnsorted Array: ");
        sort.displayArray(array);      //Display all values in unsorted array
        System.out.print("\nSorted Array: ");
        sort.displayArray(sort.bubbleSort(array));   //Display all values in sorted array
    }
}
