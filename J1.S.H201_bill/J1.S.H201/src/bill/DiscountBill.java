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
 * Class DiscountBill that extends GroceryBill to compute discounts for
 * preferred customers. This class contains constructor and method to get value
 * and add item and calculate the total cost of these items
 *
 * @author NguyenThiNhu
 */
public class DiscountBill extends GroceryBill {

    private int discountCount;
    private double discountAmount;
    private final boolean preferred;

    /**
     * The constructor for DiscountBill accepts a parameter for whether the
     * customer should get the discount. This constructor is used to initialize
     * the properties of the class
     *
     * @param clerk
     * @param preferred
     */
    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        this.preferred = preferred;
        discountCount = 0;
        discountAmount = 0;
    }

    /**
     * This method is used to get the count of discount
     *
     * @return integer
     */
    public int getDiscountCount() {
        return discountCount;
    }

    /**
     * This method is used to get the amount of discount
     *
     * @return double
     */
    public double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * This method is used to get the percent of discount
     *
     * @return double
     */
    public double getDicountPercent() {
        return (discountAmount * 100) / super.getTotal();
    }

    /**
     * This method is used to add i to this bill total and calculate the total
     * if it is preferred customers price. This method overrides the method of
     * the GroceryBill class
     *
     * @param item product item
     */
    @Override
    public void add(Item item) {
        super.add(item);
        if (preferred && item.getDiscount() > 0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    /**
     * This method is used to return the amount reported by getTotal for
     * preferred customers. This method overrides the method of the GroceryBill
     * class
     *
     * @return double
     */
    @Override
    public double getTotal() {
        return super.getTotal() - discountAmount;
    }

}
