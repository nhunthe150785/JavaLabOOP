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

import java.math.BigInteger;

/**
 * This class contains methods to convert decimal base to other radix, and
 * method to convert other radix to decimal base, and main method used to
 * display the menu and print the required result.
 *
 * @author NguyenThiNhu
 */
public class Management {

    private final String numberSystem = "0123456789ABCDEF";

    /**
     * This method is used to convert from binary or octal or hexadecimal
     * numbers to decimal
     *
     * @param number is the input value the user wants to convert
     * @param base is the original base the user wants to convert to decimal
     * @return BigInteger the result after converting the number from another
     * base to decimal
     */
    private BigInteger otherBaseToDecimal(String number, int base) {
        BigInteger result = new BigInteger("0");
        number = number.toUpperCase();
        for (int i = 0; i < number.length(); i++) {
            result = result.add(new BigInteger(numberSystem.indexOf(number.charAt(i)) + "").multiply(new BigInteger(base + "").pow(number.length() - 1 - i)));
        }
        return result;
    }

    /**
     * This method is used to convert from decimal to binary or octal or
     * hexadecimal
     *
     * @param decimalNumber is the input value the user wants to convert
     * @param base is the desired base to be converted
     * @return String the result after converting the number from decimal to
     * another base
     */
    private String decimalToAnotherBase(BigInteger decimalNumber, int base) {
        String result = "";
        while (decimalNumber.compareTo(BigInteger.valueOf(0)) > 0) {
            result = numberSystem.charAt(Integer.valueOf(String.valueOf(decimalNumber.mod(BigInteger.valueOf(base))))) + result;
            decimalNumber = decimalNumber.divide(BigInteger.valueOf(base));
        }
        return result;
    }

    /**
     * This method displays a menu and asks the user to select an option. The
     * user runs the program. The program prompts the user to select an option.
     * User selects an option, performs the function of that option
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation validation = new Validation();
        Management management = new Management();
        while (true) {
            int option = validation.menu();
            if (option == 5) {
                return;
            }
            String value = validation.getValue(option);
            switch (option) {
                case 1:
                    BigInteger toDecimal = management.otherBaseToDecimal(value, 2);
                    System.out.println("Result: " + management.decimalToAnotherBase(toDecimal, validation.getOption()));
                    break;
                case 2:
                    BigInteger toDecimal2 = management.otherBaseToDecimal(value, 8);
                    System.out.println("Result: " + management.decimalToAnotherBase(toDecimal2, validation.getOption()));
                    break;
                case 3:
                    System.out.println("Result: " + management.decimalToAnotherBase(new BigInteger(value), validation.getOption()));
                    break;
                case 4:
                    BigInteger toDecimal4 = management.otherBaseToDecimal(value, 16);
                    System.out.println("Result: " + management.decimalToAnotherBase(toDecimal4, validation.getOption()));
                    break;
            }
        }
    }

}
