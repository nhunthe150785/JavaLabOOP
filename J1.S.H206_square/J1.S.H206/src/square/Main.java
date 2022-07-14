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

/**
 * This class has a method for checking and printing the PrintSquare result
 *
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
        PrintSquare printSquare = new PrintSquare();
        while (true) {
            int min = printSquare.getMinNumber();  //Call the method getMinNumber()
            int max = printSquare.getMaxNumber(); //Call the method getMaxNumber()
            if (min <= max) {  //If the condition is satisfied, print the result
                printSquare.printSquare(min, max);
                break;
            } else { //If the requirement is not met, request a re-entry
                System.out.println("Invalid, input min number <= max number !");
            }
        }
    }
}
