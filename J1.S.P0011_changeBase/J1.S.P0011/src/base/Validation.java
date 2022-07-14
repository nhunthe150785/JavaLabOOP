/*
 * Copyright(C) 2005, FPT University
 * J1.S.P0011
 * LAB211 Assignment J1.S.P0011
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-10-25                   1.0            NguyenThiNhu                  First Implement
 */
package base;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class includes methods to check the user input value and get the valid
 * value
 *
 * @author NguyenThiNhu
 */
public class Validation {

    /**
     * This method is used to enter id and this method is satisfied if the input
     * is a positive integer number
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
                Pattern pattern = Pattern.compile("^[0-9]+$");  //Pattern with one or more numbers
                if (pattern.matcher(number).find()) {  //Return if the number matches the pattern
                    return Integer.parseInt(number);
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    /**
     * This method is satisfied if the input is not an empty String If the empty
     * string is passed, asking the user for input until not empty
     *
     * @param message request the user to enter a value
     * @return String as non-null value
     */
    private String getStringType(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String content = scanner.nextLine();   //Input data
            if (!content.trim().isEmpty() && content.length() < 100) {  //If the condition is satisfied, return the content
                return content.trim();
            } else {   //If the requirement is not met, request a re-entry
                System.out.println("Invalid, please input again !");
            }
        }
    }

    /**
     * This method is used to get the correct format value which is a binary
     * number system, binary number system is a numbering system that represents
     * numeric values using two unique digits (0 and 1)
     *
     * @return String the value enter of the user in binary format
     */
    private String getBinaryValue() {
        while (true) {
            System.out.print("Input value: ");
            String result = "";
            result = getStringType(result);
            if (result.matches("[0-1]+")) {
                return result;
            }
        }
    }

    /**
     * This method is used to get the correct format value which is a octal
     * number system, octal uses all eight numbers in the decimal system (0, 1,
     * 2, 3, 4, 5, 6 and 7)
     *
     * @return String the value enter of the user in octal format
     */
    private String getOctalValue() {
        while (true) {
            System.out.print("Input value: ");
            String result = "";
            result = getStringType(result);
            if (result.matches("[0-7]+")) {
                return result;
            }
        }
    }

    /**
     * This method is used to get the correct format value which is a decimal
     * number system, decimal uses all eight numbers in the decimal system (0,
     * 1, 2, 3, 4, 5, 6, 7, 8 and 9)
     *
     * @return String the value enter of the user in decimal format
     */
    private String getDecimalValue() {
        while (true) {
            System.out.print("Input value: ");
            String result = "";
            result = getStringType(result);
            if (result.matches("[0-9]+")) {
                return result;
            }
        }
    }

    /**
     * This method is used to get the correct format value which is a
     * hexadecimal number system, decimal uses all ten numbers in the decimal
     * system (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) and letters A through F
     *
     * @return String the value enter of the user in hexadecimal format
     */
    private String getHexadecimalValue() {
        while (true) {
            System.out.print("Input value: ");
            String result = "";
            result = getStringType(result);
            if (result.matches("[0-9a-fA-F]+")) {
                return result;
            }
        }
    }

    /**
     * This method is used to check when the user enters 1 will have to be
     * binary, enter 2 will have to be octal, enter 3 will have to be decimal,
     * enter 4 will have to be hexadecimal
     *
     * @param message request the user to enter a value
     * @param base to check if the input value is correct for that base
     * @return String of valid input value
     */
    String getValue(int base) {
        while (true) {
            switch (base) {
                case 1:
                    return getBinaryValue();
                case 2:
                    return getOctalValue();
                case 3:
                    return getDecimalValue();
                case 4:
                    return getHexadecimalValue();
            }
        }
    }

    /**
     * When the user enters 1 returns binary, input 2 returns octal, input 3
     * returns decimal, input 4 returns hexadecimal, input 5 exits the program
     *
     * @return integer as valid value after selection
     */
    int getOption() {
        int option = menu();
        switch (option) {
            case 1:
                return 2;
            case 2:
                return 8;
            case 3:
                return 10;
            case 4:
                return 16;
            case 5:
                System.exit(0);
        }
        return 0;
    }

    /**
     * This method displays a menu and asks the user to choose an option from 1
     * to 5
     *
     * @return integer as valid value after user selects
     */
    int menu() {
        Validation validation = new Validation();
        System.out.println("\n1.Binary\n2.Octal\n3.Decimal\n4.Hexadecimal\n5.Exit");
        int option = 0;
        while (true) {
            option = validation.getIntegerType("Your choice: ");
            if (option >= 1 && option <= 5) {
                return option;
            }
        }
    }

}
