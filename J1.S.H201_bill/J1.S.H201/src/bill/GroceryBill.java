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

import java.util.ArrayList;

/**
 * This class contains initialization constructor and method to get value and
 * print a list of items
 *
 * @author NguyenThiNhu
 */
public class GroceryBill {

    private final Employee clerk;
    private final ArrayList<Item> items;
    private double total;

    /**
     * This constructor is used to initialize the properties of the class
     *
     * @param cleak 
     */
    public GroceryBill(Employee cleak) {
        this.clerk = cleak;
        items = new ArrayList<>();
        total = 0;
    }

    /**
     * This method is used to add i to this bill total and calculate the total price
     *
     * @param item product item
     */
    public void add(Item item) {
        items.add(item);
        total += item.getPrice();
    }

    /**
     * This method is used to return the total cost of these items
     *
     * @return double
     */
    public double getTotal() {
        return total;
    }

    /**
     * This method is used to print a list of items
     */
    public void printReceipt() {
        System.out.println("List of items:");
        for (Item item : items) {
            System.out.println(item.toString());
        }
        System.out.println();
    }

}
