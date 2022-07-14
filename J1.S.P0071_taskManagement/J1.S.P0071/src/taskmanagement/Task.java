/*
 * Copyright(C) 2005, FPT University
 * J1.S.P0071
 * LAB211 Assignment J1.S.P0071
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-10-5                   1.0            NguyenThiNhu                  First Implement
 */
package taskmanagement;

/**
 * This class contains initialization constructor and method to get value and
 * set value
 *
 * @author NguyenThiNhu
 */
public class Task {

    private int id;
    private String requirementName;
    private int taskTypeId;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    /**
     * This constructor is used to initialize the properties of the class Task
     *
     * @param id
     * @param requirementName
     * @param taskTypeId
     * @param date
     * @param planFrom
     * @param planTo
     * @param assignee
     * @param reviewer
     */
    public Task(int id, String requirementName, int taskTypeId, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskTypeId = taskTypeId;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    /**
     * This default constructor is called when the object is created. Set the
     * initial value for the class attribute Task
     */
    public Task() {
    }

    /**
     * This method is used to get the id of the Task
     *
     * @return integer
     */
    public int getId() {
        return id;
    }

    /**
     * This method is used to set the id of the Task. The set method takes a
     * parameter (id) and assigns it to the id variable
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method is used to get the requirementName of the Task
     *
     * @return String
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * This method is used to set the requirementName of the Task. The set
     * method takes a parameter (requirementName) and assigns it to the
     * requirementName variable
     *
     * @param requirementName
     */
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    /**
     * This method is used to get the taskTypeId of the Task
     *
     * @return integer
     */
    public int getTaskTypeId() {
        return taskTypeId;
    }

    /**
     * This method is used to set the taskTypeId of the Task. The set method
     * takes a parameter (taskTypeId) and assigns it to the taskTypeId variable
     *
     * @param taskTypeId
     */
    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    /**
     * This method is used to get the date of the Task
     *
     * @return String
     */
    public String getDate() {
        return date;
    }

    /**
     * This method is used to set the date of the Task. The set method takes a
     * parameter (date) and assigns it to the date variable
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * This method is used to get the planFrom of the Task
     *
     * @return double
     */
    public double getPlanFrom() {
        return planFrom;
    }

    /**
     * This method is used to set the planFrom of the Task. The set method takes
     * a parameter (planFrom) and assigns it to the planFrom variable
     *
     * @param planFrom
     */
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    /**
     * This method is used to get the planTo of the Task
     *
     * @return double
     */
    public double getPlanTo() {
        return planTo;
    }

    /**
     * This method is used to set the planTo of the Task. The set method takes a
     * parameter (planTo) and assigns it to the planTo variable
     *
     * @param planTo
     */
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    /**
     * This method is used to get the assignee of the Task
     *
     * @return String
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * This method is used to set the assignee of the Task. The set method takes
     * a parameter (assignee) and assigns it to the assignee variable
     *
     * @param assignee
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /**
     * This method is used to get the reviewer of the Task
     *
     * @return String
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * This method is used to set the reviewer of the Task. The set method takes
     * a parameter (reviewer) and assigns it to the reviewer variable
     *
     * @param reviewer
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    /**
     * This method is used to return the id name corresponding to the user id
     * entered
     *
     * @return String
     */
    private String taskType() {
        switch (taskTypeId) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
        }
        return null;
    }

    /**
     * This method is used to display attribute values to the screen
     *
     * @return String representation of the object
     */
    @Override
    public String toString() {
        return String.format("%-4d%-17s%-11s%-13s%-6.1f%-17s%-17s", id, requirementName, taskType(), date, planTo - planFrom, assignee, reviewer);
    }

}
