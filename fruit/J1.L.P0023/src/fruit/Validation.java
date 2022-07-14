package fruit;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyễn Thị Như !
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
                return number; //Return if the number matches the pattern
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
    
    boolean checkIdExist(String id){
        ArrayList<Fruit> fruit = new ArrayList<>();
        for (Fruit object : fruit) {
            if(id.equalsIgnoreCase(object.getFruitId())){
                return false;
            }
        }
        return true;
    }
    
    boolean checkYesNo(){
        Scanner scanner = new Scanner(System.in);
        while (true) {     
            System.out.print("Do you want to continue (yes/no)?: ");
            String check = scanner.nextLine();
            if (check.equalsIgnoreCase("yes")) {
                return true;
            }
            if (check.equalsIgnoreCase("no")) {
                return false;
            }
        }
    }
    
    boolean checkItemExist(String id){
        ArrayList<Order> order = new ArrayList<>();
        for (Order object : order) {
            if(object.getFruitId().equalsIgnoreCase(id)){
                return false;
            }
        }
        return true;
    }
    
    
}
