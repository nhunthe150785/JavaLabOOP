/*
 * Copyright(C) 2005, FPT University
 * J1.S.H204
 * LAB211 Assignment J1.S.H204
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-10-20                   1.0            NguyenThiNhu                  First Implement
 */
package account;

/**
 * This class contains initialization constructor and method to get value
 *
 * @author NguyenThiNhu
 */
public class Transaction {

    private final int valueTransaction;

    /**
     * This constructor is used to initialize the value of the Transaction
     *
     * @param valueTransaction
     */
    public Transaction(int valueTransaction) {
        this.valueTransaction = valueTransaction;
    }

    /**
     * This method is used to returns the value of this transaction in pennies
     * (could be negative, positive or zero)
     *
     * @return integer
     */
    public int value() {
        return valueTransaction;
    }
}
