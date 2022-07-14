/*
 * Copyright(C) 2005, FPT University
 * J1.S.H201
 * LAB211 Assignment J1.S.H201
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-10-5                   1.0            NguyenThiNhu                  First Implement
 */
package bill;

/**
 * This class is used to add items and display the number, amount, percent of
 * discount and preferred customer to pay
 *
 * @author NguyenThiNhu
 */
public class Main {

    /**
     * This method is used to print the result to the screen
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee employee = new Employee("Nguyen Thi Nhu");
        DiscountBill discount = new DiscountBill(employee, true);  //Preferred customers 
        discount.add(new Item("Book", 10, 5));  //Add items
        discount.add(new Item("Pen", 20, 10));
        discount.add(new Item("Table", 30, 0));
        discount.printReceipt();  //Prints a list of items
        System.out.println("Number of discount: " + discount.getDiscountCount());
        System.out.println("Amount of discount: " + discount.getDiscountAmount());
        System.out.printf("Percent discount: %.1f%s", discount.getDicountPercent(), "%");
        System.out.println("\nThe amount " + employee.getName() + " has to pay: " + discount.getTotal());
    }

}
