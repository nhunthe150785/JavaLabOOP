/*
 * Copyright(C) 2005, FPT University
 * J1.S.P0071
 * LAB211 Assignment J1.S.P0071
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-10-5                   1.0            NguyenThiNhu                  First Implement
 */
package taskmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class includes methods to check the user input value
 *
 * @author NguyenThiNhu
 */
public class Validation {

    /**
     * This method is used to enter id and this method is satisfied if the input
     * is a positive integer number
     *
     * @param message request the user to enter a value
     * @return integer
     */
    int getIntegerType(String message) {
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
     * This method is used to enter planFrom, planTo and this method is
     * satisfied if the input is a double number
     *
     * @param message request the user to enter a value
     * @return double
     */
    double getDoubleType(String message) {
        Scanner scanner = new Scanner(System.in);
        double number = 0;
        while (true) {
            System.out.print(message);
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number >= 8 && number <= 17.5 && number % 0.5 == 0) {
                    return number; //Return if the number matches the pattern
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
     * @return String
     */
    String getStringType(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String content = scanner.nextLine();   //Input data
            if (!content.trim().isEmpty() && content.length() < 15) {  //If the condition is satisfied, return the content
                return content;
            } else {   //If the requirement is not met, request a re-entry
                System.out.println("Invalid, please input again !");
            }
        }
    }

    /**
     * This method is used to ask the user to enter a valid date with the
     * correct format, if the user enters a date that does not exist, it is
     * required to re-enter it.
     *
     * @param message request the user to enter a value
     * @return String
     */
    String getDateType(String message) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        dateFormat.setLenient(false);    //If the user enters a date that does not exist, it must be re-entered
        Date date;
        while (true) {
            System.out.print(message);
            try {
                date = dateFormat.parse(scanner.nextLine());
                Date currentDate = new Date();
                if (!date.after(currentDate)) {  //If the user enters a date after the current date, it must be re-entered
                    break;
                }
            } catch (ParseException e) {
            }
        }
        return dateFormat.format(date);
    }

    /**
     * This method is used to get the type id, if the user enters an integer
     * outside the range from 1 to 4, it is required to re-enter it
     *
     * @return integer
     */
    int getTaskTypeId() {
        int taskTypeId = 0;
        while (true) {
            taskTypeId = getIntegerType("Task Type[1-4]: ");
            if (taskTypeId >= 1 && taskTypeId <= 4) {
                return taskTypeId;
            }
        }
    }

    /**
     * This method is used to get the plan from, if the user enters a number
     * equal to 17.5 and the conditions in the method getDoubleType are required
     * to be re-entered
     *
     * @return double
     */
    double getPlanFrom() {
        double planFrom = 0;
        while (true) {
            planFrom = getDoubleType("From: ");
            if (planFrom != 17.5) {
                return planFrom;
            }
        }
    }

    /**
     * This method is used to get the plan to, if the user enters a number less
     * than or equal to the plan from and the conditions in the getDoubleType
     * method require re-entering.
     *
     * @return double
     */
    double getPlanTo(double planFrom) {
        double planTo = 0;
        while (true) {
            planTo = getDoubleType("To: ");
            if (planTo <= planFrom) {
                System.out.println("Input plan to > plan from");
            } else {
                return planTo;
            }
        }
    }

}
