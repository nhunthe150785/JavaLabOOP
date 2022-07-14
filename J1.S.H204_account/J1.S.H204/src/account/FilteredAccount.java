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
 * This class contains initialization constructor and method used to count the
 * number of transactions, filtered transaction, filtered not transaction and
 * method used to return the percent of transactions filtered out
 *
 * @author NguyenThiNhu
 */
public class FilteredAccount extends Account {

    private int numberOfTransaction;
    private int zeroValue;

    /**
     * This constructor is used to initialize the value of client
     *
     * @param client
     */
    public FilteredAccount(Client client) {
        super(client);
        numberOfTransaction = 0;
        zeroValue = 0;
    }

    /**
     * This method is used to process the transaction if the transaction is
     * approved then count the number of transactions and count zero value
     * transactions
     *
     * @param transaction
     * @return true or value of transaction
     */
    @Override
    public boolean process(Transaction transaction) {
        numberOfTransaction++;
        if (transaction.value() == 0) {
            zeroValue++;
            return true;
        } else {
            return super.process(transaction);
        }
    }

    /**
     * This method is used to return the percent of transactions filtered out
     * (between 0.0 and 100.0); returns 0.0 if no transactions submitted
     *
     * @return double
     */
    public double percentFiltered() {
        if (numberOfTransaction == 0) {
            return 0;
        } else {
            return 100 - ((double) zeroValue * 100 / numberOfTransaction);
        }
    }

}
