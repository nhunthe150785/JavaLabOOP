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
 * This class is used to create names, transactions for the client and print the
 * percentage of transactions that have been filtered to the screen
 *
 * @author NguyenThiNhu
 */
public class Main {

    /**
     * This method is used to set the name, the transaction for the client and
     * print the customer name and filtered transaction percentage
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = new Client();
        client.setName("Nguyen Thi Nhu");
        System.out.println(client);
        FilteredAccount account = new FilteredAccount(client);
        Transaction transactionOne = new Transaction(8);
        account.process(transactionOne);
        Transaction transactionTwo = new Transaction(0);
        account.process(transactionTwo);
        Transaction transactionThree = new Transaction(10);
        account.process(transactionThree);
        System.out.printf("Percent of transactions filtered: %.2f%%\n", account.percentFiltered());
    }
}
