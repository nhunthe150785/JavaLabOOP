/*
 * Copyright(C) 2005, FPT University
 * J1.S.H208
 * LAB211 Assignment J1.S.H208
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-09-13                   1.0            NguyenThiNhu                  First Implement
 */
package swap;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class contains methods for data input and printing results on demand.
 *
 * @author NguyenThiNhu
 */
public class SwapDigitPairs {

    /**
     * This method is satisfied if the input is a positive integer
     *
     * @return an integer
     */
    int getNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input number = ");
            String number = scanner.nextLine();   //Input data
            Pattern pattern = Pattern.compile("^[0-9]+$");  //Pattern with one or more numbers at the start and end
            if (pattern.matcher(number).find() && Integer.parseInt(number) > 0) {  //Return if the number matches the pattern and number > 0
                return Integer.parseInt(number);   //Convert number from String to Integer and return number
            } else {
                System.out.println("Invalid, please input positive integer number !");
            }
        }
    }

    /**
     * Returns a new integer whose value is similar to original number but with
     * each pair of digits swapped in order If the number contains an odd number
     * of digits, leave the leftmost digit in its original place
     *
     * Example: number = 12345 swap1 = 5, number = 1234, swap2 = 4, number = 123
     * , then result = 0 + 1 * 5 * 10 + 1 * 4 = 54, temp = 100 swap1 = 3, number
     * = 12, swap2 = 2, number = 1, then result = 54 + 100 * 3 * 10 + 100 * 2 =
     * 3254, temp = 10000 swap1 = 1, number = 0, then result = 3254 + 10000 * 1
     *
     * Result: 13254
     *
     *
     * @param number the number to swap
     * @return an integer
     */
    int swapDigitPairs(int number) {
        int result = 0;
        int temp = 1;
        while (number > 0) {   //Stop when n <= 0
            int swap1 = number % 10;  //Divide and get the remainder assigned to variable a
            number /= 10;   //Reduce number to 10
            if (number == 0) {  //If number == 0 then have result 
                result += temp * swap1;
                break;
            }
            int swap2 = number % 10;  //Divide and get the remainder assigned to variable b
            number /= 10;  //Reduce number to 10
            result = result + temp * swap1 * 10 + temp * swap2;
            temp *= 100;  // increase temp to 100
        }
        return result;
    }

}
