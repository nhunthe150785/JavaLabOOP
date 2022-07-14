/*
 * Copyright(C) 2005, FPT University
 * J1.S.H211
 * LAB211 Assignment J1.S.H211
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-11-1                   1.0            NguyenThiNhu                  First Implement
 */
package fromcounts;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class is used to print the number entered by the user with the number of
 * occurrences of the number entered by the user
 *
 * @author NguyenThiNhu
 */
public class ArrayInList {

    private int[] elementData;
    private int size;

    /**
     * This method is used to enter number and this method is satisfied if the
     * number is an integer number
     *
     * @param message request the user to enter a value
     * @return integer as integer format number
     */
    private int getIntegerType(String message) {
        Scanner scanner = new Scanner(System.in);
        String number = "";
        while (true) {
            System.out.print(message);
            try {
                number = scanner.nextLine();   //Input data
                Pattern pattern = Pattern.compile("^-*[0-9]+$");  //Pattern with one or more numbers
                if (pattern.matcher(number).find()) {  //Return if the number matches the pattern
                    return Integer.parseInt(number);
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    /**
     * This method is used to enter the size of array elements and array
     * elements, size must be greater than 0 and must be even
     */
    private void inputArray() {
        size = getIntegerType("Enter size of array: ");
        while (size % 2 == 1 || size <= 0) {
            size = getIntegerType("Re-enter the size of the array: ");
        }
        elementData = new int[size];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                while (elementData[i] <= 0) {
                    elementData[i] = getIntegerType("Enter the number of occurrences: ");
                }
            } else {
                elementData[i] = getIntegerType("Enter number: ");
            }
        }
    }

    /**
     * This method is used to print the number entered by the user with the
     * number of occurrences that the number entered by the user
     */
    private void fromCounts() {
        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < elementData[i]; j++) {
                System.out.print(elementData[i + 1] + " ");
            }
        }
        System.out.println();
    }

    /**
     * This method is used to call two methods inputArray() and fromCounts(),
     * the user enters the size and element of the array and prints the results
     * to the screen according to the requirements of the problem.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayInList array = new ArrayInList();
        array.inputArray();
        array.fromCounts();
    }

}
