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
 * This class contains initialization constructor and method to check
 * transaction
 *
 * @author NguyenThiNhu
 */
public class Account {

    /**
     * This constructor is used to constructs an account using client
     * information
     *
     * @param client
     */
    public Account(Client client) {
    }

    /**
     * This method is used to process the next transaction
     *
     * @param transaction
     * @return true if transaction was approved, false otherwise
     */
    public boolean process(Transaction transaction) {
        return transaction.value() != 0;
    }

}
