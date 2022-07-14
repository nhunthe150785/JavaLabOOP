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
 * This class contains initialization constructor and method to get value
 *
 * @author NguyenThiNhu
 */
public class Item {

    private final String name;
    private final double price;
    private final double discount;

    /**
     * This constructor is used to initialize the properties of the class
     *
     * @param name
     * @param price
     * @param discount
     */
    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    /**
     * This method is used to get the price for this item
     *
     * @return double
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method is used to get the discount for this item
     *
     * @return double
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * This method is used to display the values: name, price, discount
     *
     * @return a String representation of the object
     */
    @Override
    public String toString() {
        return "Item: " + name + ", Price: " + price + ", Discount: " + discount;
    }

}
