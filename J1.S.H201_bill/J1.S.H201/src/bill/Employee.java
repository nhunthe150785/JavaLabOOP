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
public class Employee {

    private final String name;

    /**
     * This constructor is used to initialize the name of Employee
     *
     * @param name
     */
    public Employee(String name) {
        this.name = name;
    }

    /**
     * This method is used to get Employee's name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

}
