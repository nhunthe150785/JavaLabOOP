/*
 * Copyright(C) 2005, FPT University
 * J1.S.H206
 * LAB211 Assignment J1.S.H206
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-09-13                   1.0            NguyenThiNhu                  First Implement
 */
package square;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class contains methods for data input and printing results on demand.
 *
 * @author NguyenThiNhu
 */
public class PrintSquare {

    /**
     * This method is satisfied if the input is an integer
     *
     * @return an integer
     */
    int getMinNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input min number: ");
            String min = scanner.nextLine();   //Input data
            Pattern pattern = Pattern.compile("^[0-9]+$");  //Pattern with one or more numbers at the start and end
            if (pattern.matcher(min).find()) {  //Return if the number matches the pattern.
                return Integer.parseInt(min);  //Convert min from String to Integer and return number
            } else {
                System.out.println("Invalid, Please input integer number !");
            }
        }
    }

    /**
     * This method is satisfied if the input is an integer
     *
     * @return an integer
     */
    int getMaxNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input max number: ");
            String max = scanner.nextLine();   //Input data
            Pattern pattern = Pattern.compile("^[0-9]+$");  //Pattern with one or more numbers at the start and end
            if (pattern.matcher(max).find()) {  //Return if the number matches the pattern.
                return Integer.parseInt(max);  //Convert max from String to Integer and return number
            } else {
                System.out.println("Invalid, Please input integer number !");
            }
        }
    }

    /**
     * Each line of the square consists of a circular sequence of increasing integers between min and max.
     * Each line prints a different permutation of this sequence.
     * The first line begins with min, the second line begins with min + 1, and so on.
     * When the sequence in any line reaches max, it wraps around back to min.
     * 
     * Example: min = 1, max = 3
     * Result:
     * 1 2 3
     * 2 3 1
     * 3 1 2
     * 
     * @param min start value
     * @param max end value
     */
    void printSquare(int min, int max) {
        for (int i = min; i <= max; i++) { 
            for (int j = i; j <= max; j++) {
                System.out.print(j);  //Print number from min to max
            }
            int temp = min;
            /* When the sequence in any line reaches max, it wraps around back to min */
            for (int k = 1; k <= i - min; k++) {
                System.out.print(temp);
                temp++;  //Increment the temp variable by one unit
            }
            System.out.println(); //After completing a row, create a new line
        }
    }

}
