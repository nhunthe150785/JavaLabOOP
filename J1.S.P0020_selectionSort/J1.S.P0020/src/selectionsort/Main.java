/*
 * Copyright(C) 2005, FPT University
 * J1.S.P0020
 * LAB211 Assignment J1.S.P0020
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-09-27                   1.0            NguyenThiNhu                  First Implement
 */
package selectionsort;

/**
 * This class allows users to input the number of array, enter elements. Display
 * unsorted array and sorted array using selection sort.
 *
 * @author NguyenThiNhu
 */
public class Main {

    /**
     * Check the input data and print the results to the screen
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        /* Call the method getNumber() */
        int size = 0;
        while (true) {
            size = sort.getNumber("Input array size: ");
            if (size > 0) {
                break;
            }
        }
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {  //Input elements of array
            array[i] = sort.getNumber("Input array[" + i + "] = ");
        }
        System.out.print("\nUnsorted Array: ");
        sort.displayArray(array);      //Display all values in unsorted array
        System.out.print("\nSorted Array: ");
        sort.displayArray(sort.selectionSort(array));   //Display all values in sorted array
    }
}
