/*
 * Copyright(C) 2005, FPT University
 * J1.S.H203
 * LAB211 Assignment J1.S.H203
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-09-17                   1.0            NguyenThiNhu                  First Implement
 */
package reverseword;

import java.util.Scanner;

/**
 * This class contains methods for data input and printing results on demand.
 *
 * @author NguyenThiNhu
 */
public class ReverseWord {

    /**
     * This method is satisfied if the input is not an empty String If the empty
     * string is passed, asking the user for input until not empty
     *
     * @return String
     */
    private String getPhrase() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input the phrase:");
            String phrase = scanner.nextLine();   //Input data
            if (!phrase.trim().isEmpty()) {  //If the condition is satisfied, return the phrase
                return phrase;
            } else {   //If the requirement is not met, request a re-entry
                System.out.println("Invalid, please input phrase is not empty !");
            }
        }
    }

    /**
     * This method accepts a String as its parameter and prints the words in
     * opposite order
     *
     * @param phrase to reverse word by word
     */
    private void printReverse(String phrase) {
        String[] array = phrase.split(" "); //Array containing the words of the phrase
        for (int i = array.length - 1; i >= 0; i--) {  //Reverse array
            if (i == array.length - 1) {   //Capitalize the first letter of the last word or only one word
                System.out.print(array[i].toUpperCase().charAt(0) + array[i].substring(1));
            } else {
                System.out.print(" " + array[i]);
            }
        }
        System.out.println();
    }

    /**
     * This method checks and prints the results to the screen
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReverseWord reverse = new ReverseWord();
        String phrase = reverse.getPhrase();  //Call the method getPhrase()
        /* After the string has been reverse, capitalize the first letter, and print the result */
        reverse.printReverse(phrase);
    }
}
