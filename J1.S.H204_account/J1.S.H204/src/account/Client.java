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
 * This class contains initialization constructor and method to set value
 *
 * @author NguyenThiNhu
 */
public class Client {

    private String name;

    /**
     * This method is used to set the name of the Client. The set method takes a
     * parameter (name) and assigns it to the name variable
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is used to display name of customer
     *
     * @return a String representation of the object
     */
    @Override
    public String toString() {
        return "Customer name: " + name;
    }

}
