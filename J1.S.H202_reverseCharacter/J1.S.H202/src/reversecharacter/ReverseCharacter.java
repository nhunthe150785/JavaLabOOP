/*
 * Copyright(C) 2005, FPT University
 * J1.S.H202
 * LAB211 Assignment J1.S.H202
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-09-13                   1.0            NguyenThiNhu                  First Implement
 */
package reversecharacter;

import java.util.Scanner;

/**
 * This class contains methods for data input and printing results on demand.
 *
 * @author NguyenThiNhu
 */
public class ReverseCharacter {

    /**
     * This method is input data
     *
     * @return a String
     */
    String getPhrase() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the phrase: ");
        String phrase = scanner.nextLine();  //Input data
        if (!phrase.trim().isEmpty()) {  //If the phrase is not empty, return the phrase
            return phrase;
        }
        return phrase;
    }

    /**
     * This method accepts a String as its parameter and prints the characters
     * in opposite order.
     *
     * @param phrase to reverse characters
     */
    void printReverse(String phrase) {
        for (int i = phrase.length() - 1; i >= 0; i--) {  //Reverse string phrase
            System.out.print(phrase.charAt(i));
        }
    }

    /**
     * This method checks and prints the results to the screen. If the empty
     * string is passed, no output is produced
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReverseCharacter reverse = new ReverseCharacter();
        String phrase = reverse.getPhrase();  //Call the method getPhrase()
        if (!phrase.isEmpty()) {  //If the condition is satisfied, print the result
            reverse.printReverse(phrase);  //Print the result after reversing the character
        }
    }
}
