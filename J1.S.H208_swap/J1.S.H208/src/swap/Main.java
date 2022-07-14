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

/**
 * This class has a method for checking and printing the swapDigitPairs result
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
        SwapDigitPairs swapDigit = new SwapDigitPairs();
        int number = swapDigit.getNumber();    //Call the method getNumber()
        System.out.println("Result: " + swapDigit.swapDigitPairs(number));  //Print the result
    }
}
